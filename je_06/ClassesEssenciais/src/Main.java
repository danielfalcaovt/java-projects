import java.lang.reflect.Field;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] arr = { "name", "phone", "email" };
        String verifiedString = "data1;data2;data3";
        Scanner scanner = new Scanner(verifiedString);
        scanner.useDelimiter(";");

        int index = 0;
        Usuario novoUsuario = new Usuario();
        Field[] properties = Usuario.class.getDeclaredFields();
        String[] fields = new String[3];
        for (Field field : properties) {
            fields[index] = field.getName();
            System.out.println(field.getName());
        }
        while (scanner.hasNext()) {
            if (index == 0) {
                novoUsuario.name = scanner.next();
            } else if (index == 1) {
                novoUsuario.phone = scanner.next();
            } else {
                novoUsuario.email = scanner.next();
            }

            index++;
        }
        double anyValue = 5000.3;
        System.out.printf("name: %s phone: %s email %s altura: %,.2f", novoUsuario.name, novoUsuario.phone, novoUsuario.email, anyValue);
    }
}

class Usuario {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProperty(String value, String property) {

    }
}
