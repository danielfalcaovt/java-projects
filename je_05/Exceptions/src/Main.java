
import EstadosBrasileiros.EstadosBrasileiros;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
       /* boolean running = true;
        while (running) {
            String valor = System.console().readLine();
                System.out.println(valor);
            if (valor == "end") {
                running = false;
                break;
            }
            Integer resultado = 0;
            try {
                resultado = Integer.parseInt(valor);
            } catch (NumberFormatException err) {
                err.printStackTrace();
                resultado = Integer.parseInt("50");
            }
            System.out.println(resultado);
        }

        for (EstadosBrasileiros es : EstadosBrasileiros.values()) {
            System.out.println(es.name());
        }*/
        Carro carro1 = new Carro("palio");
        Carro carro2 = carro1;
        Carro carro3 = new Carro("palio");
        System.out.println(carro1.equals(carro3));
        System.out.println(carro1.equals(carro2));
        carro2.name = "uno";
        System.out.println(carro2.equals(carro1));
    }
}

class Carro {
    public String name;
    public Carro(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(name, carro.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}