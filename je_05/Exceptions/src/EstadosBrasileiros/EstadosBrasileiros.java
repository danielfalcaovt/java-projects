package EstadosBrasileiros;

public enum EstadosBrasileiros {
    PIAUI("Piaui", "PI"),
    RIOJANEIRO("Rio de Janeiro", "RJ"),
    SAOPAULO("São Paulo", ""),
    ESPIRITOSANTO("Espírito Santo", ""),
    MINASGERAIS("Minas Gerais", "");

    private String name = "";
    private String sigla = "";
    private EstadosBrasileiros(String name, String sigla) {
        this.name = name;
        this.sigla = sigla;
    }
}
