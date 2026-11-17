import java.util.ArrayList;
import java.util.List;

public class Imovel {
    private static final int MAX_CONTAS = 12;

    private int codigoRegistro;
    private List<ContaEnergia> contas;

    public Imovel(int codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaEnergia conta) {
        if(contas.size() == MAX_CONTAS) {
            contas.remove(0);
        }
        contas.add(conta);
    }

    public double calcularValorMedio() {
        if (contas.isEmpty()) return 0;
        double soma = 0;
        for(ContaEnergia c : contas) {
            soma+= c.calcularValorTotal();
        }
        return soma/contas.size();
    }

    public ContaEnergia obterContaMaisCara() {
        if(contas.isEmpty()) return null;
        ContaEnergia maisCara = contas.get(0);
        for(ContaEnergia c : contas) {
            maisCara = maisCara.maisCara(c);
        }
        return maisCara;
            
    }

    public String relatorioContasAcimaDaMedia() {
        double media = calcularValorMedio();
        String relatorio = "=== Contas acima da média - Imóvel" + codigoRegistro + " ===\n";
        relatorio += String.format("Média do período: R$ %.2f%n", media);
        for (ContaEnergia c : contas) {
            if (c.calcularValorTotal() > media) {
                relatorio += c.resumo() + "\n";
            }
        }
        return relatorio;
    }

    public String relatorioResumoAnual() {
        String relatorio = " === Resumo anual - Imóvel " + codigoRegistro + " ===\n";
        for (ContaEnergia c : contas) {
            relatorio += c.resumo() + "\n";

        }
        return relatorio;
    }
    public List<ContaEnergia> getContas() {
        return contas;
    }
} 
