import java.time.LocalDate;
import java.util.UUID;

public abstract class Conta {
    public UUID id = UUID.randomUUID();
    public Double funds = 0.0;
    public String client = "";
    public LocalDate birthDate = null;

    Conta(Double funds, String client, LocalDate birthDate) {
        this.birthDate = birthDate;
        this.funds = funds;
        this.client = client;
    }
}
