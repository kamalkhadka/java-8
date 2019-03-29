package stream.time;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalTimeMain {
  public static void main(String[] args) {
      LocalTime time = LocalTime.of(13, 45, 20);
      int hour = time.getHour();
      int minute = time.getMinute();
      int second = time.getSecond();

      // LocalDate and LocalTime can be created by parsing a String
      LocalDate date = LocalDate.parse("2014-03-18");
      time = LocalTime.parse("13:45:20");

      // it's possible to pass DateTimeFormatter to the parse method
      // instance of this class specifies how to format date and / or time object

  }
}
