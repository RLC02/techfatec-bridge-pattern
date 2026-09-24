package abstracao;

import implementacao.ExportadorRelatorio;

/**
 * Abstração (Abstraction) do Padrão Bridge.
 *
 * Classe base abstrata que mantém uma referência à interface de implementação
 * (ExportadorRelatorio). Esta referência é a "ponte" que conecta a hierarquia
 * de abstrações (tipos de relatório) à hierarquia de implementações (formatos
 * de exportação), mantendo-as independentes.
 *
 * Injeção de Dependência via Construtor: O exportador concreto nunca é
 * instanciado internamente (sem uso do operador new). Ele é recebido
 * externamente, promovendo baixo acoplamento e testabilidade.
 *
 * Permite a troca dinâmica do exportador em tempo de execução através de
 * setExportador(), sem qualquer alteração nas subclasses.
 */
public abstract class Relatorio {

    // "Ponte": referência à interface de implementação
    protected ExportadorRelatorio exportador;

    /**
     * Construtor com injeção de dependência.
     * O exportador concreto é injetado externamente — jamais instanciado aqui.
     *
     * @param exportador implementação concreta a ser utilizada
     */
    public Relatorio(ExportadorRelatorio exportador) {
        this.exportador = exportador;
    }

    /**
     * Permite a troca dinâmica do exportador em tempo de execução,
     * demonstrando o desacoplamento proporcionado pelo Padrão Bridge.
     *
     * @param exportador nova implementação concreta
     */
    public void setExportador(ExportadorRelatorio exportador) {
        this.exportador = exportador;
    }

    /**
     * Operação de alto nível definida pela abstração.
     * Delegação da exportação à implementação injetada.
     */
    public abstract void gerar();
}
