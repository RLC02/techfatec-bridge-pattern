package implementacao;

/**
 * Implementação Concreta (ConcreteImplementor) - Exportador PDF.
 *
 * Implementa a interface ExportadorRelatorio para o formato PDF.
 * Esta classe pode evoluir ou ser substituída sem impacto nas abstrações.
 */
public class ExportadorPDF implements ExportadorRelatorio {

    @Override
    public void exportar(String conteudo) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║         EXPORTANDO PARA PDF              ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  Formato : PDF (Portable Document Format)║");
        System.out.println("║  Conteúdo: " + padRight(conteudo, 30) + "║");
        System.out.println("║  Status  : Arquivo .pdf gerado com êxito ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    private String padRight(String text, int length) {
        if (text.length() > length) {
            return text.substring(0, length - 3) + "...";
        }
        return String.format("%-" + length + "s", text);
    }
}
