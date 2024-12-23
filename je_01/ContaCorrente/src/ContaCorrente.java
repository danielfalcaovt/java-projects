import java.time.LocalDate;

public class ContaCorrente extends Conta {
    public int account;
    public int agency;
    private boolean cancelProcess = false;

    ContaCorrente(String clientName, LocalDate birthdate) {
        super(15.0, clientName, birthdate);
        this.account = (int) Math.floor(Math.random() * 9);
        this.agency = (int) Math.floor(Math.random() * 5);
    }

    public void receberTransferencia(int value) {
        this.funds += value;
    }

    public void sacar(int value) {
        this.funds -= value;
        System.out.printf("Sacando o valor %s R$ da conta do cliente: %s%n", value, this.client);
    }

    public void transferirParaContaCorrente(int value, ContaCorrente conta) {
        // verificar se conta existe
        if (this.funds - value > 0) {
            System.out.printf("Valor da conta pré transferência %s\n", this.funds);
            System.out.printf("Valor da conta pré transferência %s\n", conta.funds);
            this.funds -= value;
            conta.receberTransferencia(value);
            System.out.printf("Valor da conta de %s após transfrencia de %s\n", conta.client, conta.funds);
            System.out.printf("Valor da conta de %s após transfrencia de %s\n", this.client, this.funds);
            return;
        }
        throw new RuntimeException("you don't have enough funds.");
    }

    public void cancelarConta(String why) {
        if (!this.cancelProcess) {
            System.out.printf("Processo de cancelamento: %s\n", this.cancelProcess ? "Cancelado" : "Aguardando resposta");
            enviarJustificativa(why);
            return;
        }
        verificarAprovacao(this);
    }

    private void enviarJustificativa(String why) {
        // if aprovado :
        this.cancelProcess = true;
        // envio de justificativa para banco de dados no qual outra aplicação/serviço vai acessá-la e aprovar ou reprovar
    }

    private void verificarAprovacao(Conta conta) {
        // acessar banco de dados de aprovações
        // verificar se requerimento foi aprovado ou não
        // retornar resultado
        // retorno de valor mockado, devido a falta de banco de dados
        System.out.printf("Processo de cancelamento: %s\n", this.cancelProcess ? "Cancelado" : "Aguardando resposta");
        return;
    }
}