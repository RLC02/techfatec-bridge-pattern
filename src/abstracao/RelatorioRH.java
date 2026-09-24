package abstracao;

import implementacao.ExportadorRelatorio;

/**
 * Abstração Refinada (RefinedAbstraction) - Relatório de Desempenho de RH.
 *
 * Estende a abstração base com comportamento específico do módulo de RH.
 * Adicionado ao sistema sem modificar nenhuma classe existente, respeitando
 * o Princípio Aberto/Fechado (OCP) do SOLID.
 *
 * Combinável com qualquer ExportadorRelatorio (PDF, Excel, HTML ou futuros)
 * por meio da injeção de dependência via construtor.
 */
public class RelatorioRH extends Relatorio {

    private final String departamento;
    private final int totalColaboradores;
    private final double indiceDesempenho;

    /**
     * Construtor com injeção de dependência do exportador.
     * Nunca instancia o exportador internamente.
     *
     * @param exportador          implementação de exportação injetada via construtor
     * @param departamento        departamento avaliado
     * @param totalColaboradores  número de colaboradores no período
     * @param indiceDesempenho    índice médio de desempenho (0.0 a 10.0)
     */
    public RelatorioRH(ExportadorRelatorio exportador, String departamento,
                       int totalColaboradores, double indiceDesempenho) {
        super(exportador); // Injeção delegada à superclasse
        this.departamento = departamento;
        this.totalColaboradores = totalColaboradores;
        this.indiceDesempenho = indiceDesempenho;
    }

    /**
     * Gera o conteúdo do Relatório de RH e delega a exportação
     * ao implementador injetado (ExportadorRelatorio).
     */
    @Override
    public void gerar() {
        String conteudo = String.format(
                "Relatório de RH | Depto: %s | Colaboradores: %d | Índice: %.1f/10",
                departamento, totalColaboradores, indiceDesempenho);
        System.out.println("\n[Relatório de RH] Gerando conteúdo...");
        exportador.exportar(conteudo);
    }
}
