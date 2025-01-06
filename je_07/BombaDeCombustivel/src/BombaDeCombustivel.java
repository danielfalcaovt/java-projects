import java.math.BigDecimal;
import java.math.RoundingMode;

public class BombaDeCombustivel {
    private BigDecimal precoLitro = new BigDecimal(5.799);
    public BigDecimal totalResultado = new BigDecimal(0.0);
    /**
     * @param precoLitro  preço referente ao litro do combustível.
     * */
    public BombaDeCombustivel(double precoLitro) {
        this.precoLitro = new BigDecimal(precoLitro);
    }

    public BigDecimal calcularValor(double litros) {
        this.totalResultado = this.precoLitro.multiply(new BigDecimal(litros));
        return this.totalResultado.setScale(3, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getPrecoLitro() {
        return precoLitro;
    }

    public void setPrecoLitro(BigDecimal precoLitro) {
        this.precoLitro = precoLitro;
    }

    public BigDecimal getTotalResultado() {
        return totalResultado;
    }

    public void setTotalResultado(BigDecimal totalResultado) {
        this.totalResultado = totalResultado;
    }
}
