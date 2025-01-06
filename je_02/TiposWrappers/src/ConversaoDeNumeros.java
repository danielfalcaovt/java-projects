public class ConversaoDeNumeros {
    double numeroDecimal = 5.7;
    int numeroInteiro = 10;

    ConversaoDeNumeros() {
        this.numeroInteiro = (int) this.numeroDecimal;
        System.out.println(this.numeroInteiro );
    }
}
