import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            LocalDate.of(2024, 20,05);
            LocalDate.parse("05/12/2006");
            DbCreateUser dbCreateUser = new DbCreateUser();
            User user = dbCreateUser.create("claudio76");

            System.out.println(user.name);;

            user = dbCreateUser.create("");
        } catch (PersonalizedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}