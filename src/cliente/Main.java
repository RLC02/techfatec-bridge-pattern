package cliente;

import abstracao.Relatorio;
import abstracao.RelatorioRH;
import abstracao.RelatorioVendas;
import implementacao.ExportadorExcel;
import implementacao.ExportadorHTML;
import implementacao.ExportadorPDF;

/**
 * Cliente (Client) do Padrão Bridge — TechFatec Business Intelligence.
 *
 * Esta classe demonstra o desacoplamento proporcionado pelo Padrão Bridge:
 *   - As abstrações (Relatorio) e implementações (Exportador) variam
 *     independentemente.
 *   - A troca de formato em tempo de execução é feita via setExportador(),
 *     sem nenhuma alteração nas classes de relatório.
 *   - Nenhuma classe de relatório instancia diretamente um exportador (sem new).
 *
 * Rotinas de validação exigidas:
 *   1. Relatório de Vendas exportado em PDF.
 *   2. Mesmo relatório de vendas trocado dinamicamente para Excel (XLSX).
 *   3. Relatório de RH exportado em HTML.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================================");
        System.out.println("  TechFatec Business Intelligence — Módulo de Relatórios  ");
        System.out.println("  Padrão Bridge | Injeção de Dependência via Construtor   ");
        System.out.println("==========================================================");

        // ----------------------------------------------------------------
        // ROTINA 1: Relatório de Vendas → PDF
        // Exportador PDF criado externamente e INJETADO via construtor.
        // ----------------------------------------------------------------
        System.out.println("\n>>> ROTINA 1: Relatório de Vendas em PDF");
        Relatorio relatorioVendas = new RelatorioVendas(
                new ExportadorPDF(),          // <-- injeção de dependência
                "Janeiro/2025",
                187_450.00
        );
        relatorioVendas.gerar();

        // ----------------------------------------------------------------
        // ROTINA 2: Troca DINÂMICA do formato em tempo de execução (PDF → Excel)
        // O mesmo objeto de relatório recebe um novo exportador sem recriação.
        // Demonstra o desacoplamento do Padrão Bridge.
        // ----------------------------------------------------------------
        System.out.println("\n>>> ROTINA 2: Troca dinâmica — Relatório de Vendas agora em EXCEL");
        relatorioVendas.setExportador(new ExportadorExcel()); // troca em runtime
        relatorioVendas.gerar();

        // ----------------------------------------------------------------
        // ROTINA 3: Relatório de RH → HTML
        // Novo tipo de relatório + novo formato, sem alterar nenhuma classe existente.
        // ----------------------------------------------------------------
        System.out.println("\n>>> ROTINA 3: Relatório de Desempenho de RH em HTML");
        Relatorio relatorioRH = new RelatorioRH(
                new ExportadorHTML(),         // <-- injeção de dependência
                "Engenharia de Software",
                42,
                8.7
        );
        relatorioRH.gerar();

        System.out.println("\n==========================================================");
        System.out.println("  Todas as rotinas executadas com sucesso.                ");
        System.out.println("  Padrão Bridge validado: abstrações e implementações     ");
        System.out.println("  variam de forma independente (OCP/SOLID).               ");
        System.out.println("==========================================================");
    }
}
