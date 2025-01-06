import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        // Controle de Fluxo Condicional
        int employeeProductivityInMonth = 350;
        if (employeeProductivityInMonth > 2000) {
            System.out.println("employee must be rewarded");
        } else if (employeeProductivityInMonth > 1000) {
            System.out.println("employee in line with the goals");
        } else {
            System.out.println("employee must be advert");
        }

        // Controle de Fluxo Ternário
        System.out.println(employeeProductivityInMonth > 2000 ? "employee must be rewarded" : employeeProductivityInMonth > 1000 ? "employee is in expect" : "employee must be advert");


        int i = 0;
        for (; i<=20;) {
            System.out.println(i);
            i += 2;
        }

        String[] professores = { "Claudio", "Pedro", "Marcos" };
        for (String professor : professores) {
            System.out.println(professor);
        }

        boolean awaken = true;
        int carneiros = 0;
        int quantosCarneirosDormiu = new Random().nextInt(10000);;
        while (awaken) {
            carneiros++;
            System.out.printf("%s carneiro(s) \n", carneiros);
            awaken = !(quantosCarneirosDormiu == carneiros);
        }

        ThreadLocalRandom.current().nextInt();
    }
}
