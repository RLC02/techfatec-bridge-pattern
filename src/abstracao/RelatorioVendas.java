package abstracao;

import implementacao.ExportadorRelatorio;

/**
 * Abstração Refinada (RefinedAbstraction) - Relatório de Vendas.
 *
 * Estende a abstração base adicionando o comportamento específico
 * do Relatório de Vendas. Não possui nenhum conhecimento sobre os
 * formatos de exportação — essa responsabilidade é do exportador injetado.
 *
 * Pode ser combinado com qualquer ExportadorRelatorio sem necessidade
 * de criação de subclasses por formato (prevenção de explosão de subclasses).
 */
public class RelatorioVendas extends Relatorio {

    private final String periodo;
    private final double totalVendas;

    /**
     * Construtor com injeção de dependência do exportador.
     * Nunca instancia o exportador internamente.
     *
     * @param exportador implementação de exportação injetada via construtor
     * @param periodo    período de referência do relatório
     * @param totalVendas valor total de vendas do período
     */
    public RelatorioVendas(ExportadorRelatorio exportador, String periodo, double totalVendas) {
        super(exportador); // Injeção delegada à superclasse
        this.periodo = periodo;
        this.totalVendas = totalVendas;
    }

    /**
     * Gera o conteúdo do Relatório de Vendas e delega a exportação
     * ao implementador injetado (ExportadorRelatorio).
     */
    @Override
    public void gerar() {
        String conteudo = String.format("Relatório de Vendas | Período: %s | Total: R$ %.2f",
                periodo, totalVendas);
        System.out.println("\n[Relatório de Vendas] Gerando conteúdo...");
        exportador.exportar(conteudo);
    }
}
