package stream.collectors;

import stream.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class Collector {
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

    long howManyCalories = menu.stream().collect(counting());
    long howManyDishes = menu.stream().count();

    Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

    Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));

    mostCalorieDish.ifPresent(System.out::println);

    int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
    System.out.println(totalCalories);

    double avgCalories = menu.stream().collect(averagingDouble(Dish::getCalories));
    System.out.println(avgCalories);

    String shortMenu = menu.stream().map(Dish::getName).collect(joining());
    System.out.println(shortMenu);

    shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
    System.out.println(shortMenu);
  }
}
