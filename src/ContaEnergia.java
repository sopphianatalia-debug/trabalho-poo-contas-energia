public class ContaEnergia {

    private static final double TARIFA_KWH = 0.92;
    private static final double TAXA_ILUMINACAO = 0.025;
    private static final double TAXA_ICMS = 0.22;
    private static final double LIMITE_ISENCAO_KWH = 90;


    private String mesReferencia;
    private int leituraAnterior;
    private int leituraAtual;


public ContaEnergia(String mesReferencia, int leituraAnterior,int leituraAtual) {
    if (leituraAtual < leituraAnterior) {
        throw new IllegalArgumentException(
            "A leitura atual não pode ser inferior á leitura do mês anterior.");

    }
    this.mesReferencia = mesReferencia;
    this.leituraAnterior = leituraAnterior;
    this.leituraAtual = leituraAtual;
    }

public int getConsumo() {
    return leituraAtual - leituraAnterior;
}

public double calcularValorConsumo() {
    return getConsumo() * TARIFA_KWH;
}

public boolean isIsenta() {
    return getConsumo() < LIMITE_ISENCAO_KWH;
}

public double calcularContribuicaoIluminacao() {
    if (isIsenta()) return 0;
    return calcularValorConsumo() * TAXA_ILUMINACAO;
}

public double calcularICMS() {
    if (isIsenta()) return 0;
    return (calcularValorConsumo() + calcularContribuicaoIluminacao()) * TAXA_ICMS;
}

public double calcularValorTotal() {
    return calcularValorConsumo() + calcularContribuicaoIluminacao() + calcularICMS();
}

public ContaEnergia maisCara(ContaEnergia outra) {
    if (this.calcularValorTotal() >= outra.calcularValorTotal()) {
        return this;
    }
    return outra;
}

public String resumo() {
    return String.format("Mês: %s | Consumo: %d Kwh | Total: R$ %.2f",
        mesReferencia,getConsumo(), calcularValorTotal());
    
}

public String getMesReferencia() {
    return mesReferencia;
}

}
