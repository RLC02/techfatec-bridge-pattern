package implementacao;

/**
 * Interface de Implementação (Implementor) do Padrão Bridge.
 *
 * Define o contrato para todos os exportadores concretos de formatos.
 * Representa a "ponte" que desacopla a abstração (Relatorio) da
 * implementação concreta de exportação.
 *
 * Princípio Aberto/Fechado (OCP): novos formatos de exportação podem ser
 * adicionados criando novas implementações desta interface, sem alterar
 * nenhuma classe de relatório existente.
 */
public interface ExportadorRelatorio {

    /**
     * Exporta o conteúdo do relatório no formato específico da implementação.
     *
     * @param conteudo O conteúdo textual do relatório a ser exportado.
     */
    void exportar(String conteudo);
}
