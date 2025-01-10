import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 2);
        LocalDate now = LocalDate.now();
        System.out.println(date.isBefore(now)); // false
        System.out.println(now.isAfter(date)); // true
        System.out.println(now.isEqual(date)); // false

        LocalDate newDate = LocalDate.of(2012, 12, 25);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatter.format(newDate));
        LocalDate meuBirthday = LocalDate.parse("05/12/2006", formatter);
        System.out.println(meuBirthday);
        System.out.println(meuBirthday.plusYears(18)); // when i'd have 18

        LocalTime nowH = LocalTime.now();
        LocalTime time = LocalTime.of(20, 10, 10);
        System.out.println(time.isAfter(nowH));
    }
}