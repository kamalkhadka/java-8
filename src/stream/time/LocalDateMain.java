package stream.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateMain {
  public static void main(String[] args) {
      LocalDate date = LocalDate.of(2014, 3, 18);
      int year = date.getYear();
      System.out.println("Year is: " + year);

      Month month = date.getMonth();
    System.out.println(month);

      DayOfWeek dow = date.getDayOfWeek();
    System.out.println(dow);

    int len = date.lengthOfMonth();
    System.out.println(len);

    boolean leap = date.isLeapYear();
    System.out.println(leap);

    // current date from the system clock
      LocalDate today = LocalDate.now();
    System.out.println(today);

    year = date.get(ChronoField.YEAR);
    int month1 = date.get(ChronoField.MONTH_OF_YEAR);
    int day = date.get(ChronoField.DAY_OF_MONTH);


  }
}
