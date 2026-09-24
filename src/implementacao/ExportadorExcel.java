package implementacao;

/**
 * Implementação Concreta (ConcreteImplementor) - Exportador Excel (XLSX).
 *
 * Implementa a interface ExportadorRelatorio para o formato XLSX.
 * Adicionada sem modificar qualquer classe de abstração existente,
 * demonstrando o Princípio Aberto/Fechado (OCP).
 */
public class ExportadorExcel implements ExportadorRelatorio {

    @Override
    public void exportar(String conteudo) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║         EXPORTANDO PARA EXCEL            ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  Formato : XLSX (Microsoft Excel)        ║");
        System.out.println("║  Conteúdo: " + padRight(conteudo, 30) + "║");
        System.out.println("║  Status  : Arquivo .xlsx gerado com êxito║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    private String padRight(String text, int length) {
        if (text.length() > length) {
            return text.substring(0, length - 3) + "...";
        }
        return String.format("%-" + length + "s", text);
    }
}
