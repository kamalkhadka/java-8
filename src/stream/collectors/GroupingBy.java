package stream.collectors;

import stream.Dish;
import stream.DishMenu;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class GroupingBy {

  public static void main(String[] args) {
    List<Dish> menu = DishMenu.getMenuItem();

    Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
        menu.stream()
            .collect(
                groupingBy(
                    dish -> {
                      if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                      else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                      else return CaloricLevel.FAT;
                    }));

    Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
        menu.stream()
            .collect(
                groupingBy(
                    Dish::getType,
                    groupingBy(
                        dish -> {
                          if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                          else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                          else return CaloricLevel.FAT;
                        })));

    Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
    System.out.println(typesCount);

    Map<Boolean, List<Dish>> partitionedMenu =
        menu.stream().collect(partitioningBy(Dish::isVegeterian));
    List<Dish> vegeterianDishes = partitionedMenu.get(true);
    System.out.println(vegeterianDishes);
  }

  public enum CaloricLevel {
    DIET,
    NORMAL,
    FAT
  }
}
