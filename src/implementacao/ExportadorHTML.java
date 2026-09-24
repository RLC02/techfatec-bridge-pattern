package implementacao;

/**
 * Implementação Concreta (ConcreteImplementor) - Exportador HTML.
 *
 * Implementa a interface ExportadorRelatorio para o formato HTML.
 * Adicionada sem modificar qualquer classe de abstração existente,
 * demonstrando o Princípio Aberto/Fechado (OCP).
 */
public class ExportadorHTML implements ExportadorRelatorio {

    @Override
    public void exportar(String conteudo) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║         EXPORTANDO PARA HTML             ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  Formato : HTML (HyperText Markup Lang.) ║");
        System.out.println("║  Conteúdo: " + padRight(conteudo, 30) + "║");
        System.out.println("║  Status  : Arquivo .html gerado com êxito║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    private String padRight(String text, int length) {
        if (text.length() > length) {
            return text.substring(0, length - 3) + "...";
        }
        return String.format("%-" + length + "s", text);
    }
}
