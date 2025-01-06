import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<Conta>();
        System.out.println("What is your name");
        String name = System.console().readLine();
        System.out.println("What year were you born");
        int birthYear = Integer.parseInt(System.console().readLine());
        System.out.println("What month were you born");
        int birthMonth = Integer.parseInt(System.console().readLine());
        System.out.println("What day were you born");
        int birthday = Integer.parseInt(System.console().readLine());

        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthday);
        ContaCorrente conta = new ContaCorrente(name, birthDate);
        contas.add(conta);
        ContaCorrente contaVendedor = new ContaCorrente("vendedor", LocalDate.now());
        contas.add(contaVendedor);
        System.out.println(conta.client);
        conta.sacar(10);

        conta.transferirParaContaCorrente(2.0, contaVendedor);

        conta.cancelarConta("porque sim");
        conta.cancelarConta("porque sim");
    }
}