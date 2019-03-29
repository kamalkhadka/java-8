package stream.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

// LocalDateTime pairs a LocalDate and LocalTime
// it represents both date and a time, without a time zone
public class LocalDateTimeMain {
  LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 24, 20);
  LocalDateTime dt2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
  LocalDateTime dt3 = LocalDate.now().atTime(LocalTime.now());
  LocalDateTime dt5 = LocalTime.now().atDate(LocalDate.now());

  LocalDate date1 = dt1.toLocalDate();
  LocalTime time1 = dt1.toLocalTime();


}
