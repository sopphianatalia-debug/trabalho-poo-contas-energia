public class App {

    public static void main(String[] args) {
        
        Imovel imovel = new Imovel(1001);
        
        imovel.adicionarConta(new ContaEnergia("Jan/2026",5000, 5150));
        imovel.adicionarConta(new ContaEnergia("Fev/2026",5150, 5290));
        imovel.adicionarConta(new ContaEnergia("Mar/2026",5290, 5370));
        imovel.adicionarConta(new ContaEnergia("Abr/2026",5370, 5520));
        imovel.adicionarConta(new ContaEnergia("Mai/2026",5520, 5700));
        imovel.adicionarConta(new ContaEnergia("Jun/2026",5700, 5785));
        imovel.adicionarConta(new ContaEnergia("Jul/2026",5785, 5960));
        imovel.adicionarConta(new ContaEnergia("Ago/2026",5960, 6120));
        imovel.adicionarConta(new ContaEnergia("Set/2026",6120, 6300));
        imovel.adicionarConta(new ContaEnergia("Out/2026",6300, 6380));
        imovel.adicionarConta(new ContaEnergia("Nov/2026",6380, 6560));
        imovel.adicionarConta(new ContaEnergia("Dez/2026",6560, 6750));

        ContaEnergia jan = imovel.getContas().get(0);
        System.out.printf("Valor da conta de Jan: R$ %.2f%n%n", jan.calcularValorTotal());

        System.out.printf("Valor médio: R$ %.2f%n", imovel.calcularValorMedio());
        System.out.println("Conta mais cara: " + imovel.obterContaMaisCara().resumo());
        System.out.println();

        System.out.println(imovel.relatorioContasAcimaDaMedia());

        System.out.println(imovel.relatorioResumoAnual());

        

    }
    
}
