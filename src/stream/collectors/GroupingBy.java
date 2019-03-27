package stream.collectors;

import stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GroupingBy {

  public static void main(String[] args) {
      List<Dish> menu =
              Arrays.asList(
                      new Dish("pork", false, 800, Dish.Type.MEAT),
                      new Dish("beef", false, 700, Dish.Type.MEAT),
                      new Dish("chicken", false, 400, Dish.Type.MEAT),
                      new Dish("french fries", true, 530, Dish.Type.OTHER),
                      new Dish("rice", true, 350, Dish.Type.OTHER),
                      new Dish("season fruit", true, 120, Dish.Type.OTHER),
                      new Dish("pizza", true, 550, Dish.Type.OTHER),
                      new Dish("prawns", false, 300, Dish.Type.FISH),
                      new Dish("salmon", false, 450, Dish.Type.FISH));

      Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish ->
      {
          if(dish.getCalories() <= 400) return CaloricLevel.DIET;
          else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
          else return CaloricLevel.FAT;
      }));

      Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
              menu.stream().collect(groupingBy(Dish::getType,
                      groupingBy( dish -> {
                          if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                          else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                          else return CaloricLevel.FAT;
                      })));
  }

  public enum CaloricLevel { DIET, NORMAL, FAT }
}
