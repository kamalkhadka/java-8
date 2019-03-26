package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishMain {

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

    /*List<Dish> vegeterianDishes =
        menu.stream().filter(Dish::isVegeterian).collect(Collectors.toList());

    vegeterianDishes.forEach(System.out::println);

    List<Dish> dishes = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .limit(3)
            .collect(Collectors.toList());

    List<Dish> skipDishes = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .skip(2)
            .collect(Collectors.toList());*/

//    menu.stream().map(Dish::getName).forEach(System.out::println);
//    menu.stream().map(Dish::getName).map(String::length).forEach(System.out::println);

    // filtering and matching
//    if(menu.stream().anyMatch(Dish::isVegeterian)){
//      System.out.println("menu is somewhat vegeterian friendly");
//    }
//
//    boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
//
//    System.out.println(isHealthy);
//
//    menu.stream().filter(Dish::isVegeterian).findAny()
//            .ifPresent(d -> System.out.println(d.getName()));


    List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> firstSquareDivisibleByThree =
            someNumbers.stream().map(x -> x * x)
            .filter( x -> x % 3 == 0).findFirst();
    firstSquareDivisibleByThree.ifPresent(System.out::println);

    int calories = menu.stream().mapToInt(Dish::getCalories).sum();
    System.out.println(calories);
  }
}
