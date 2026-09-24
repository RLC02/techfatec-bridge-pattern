package com.example.produto.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Evento publicado na fila produto.queue.
 *
 * Os campos seguem o contrato esperado pelo serviço de venda
 * (AtualizarVendaEscutador): eventId, eventType, occurredAt,
 * produtoId, nomeProduto, quantidade, versao.
 *
 * Campos extras (preco) são ignorados pelo consumidor via Jackson
 * (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES = false, default).
 */
public class ProdutoEventoDTO implements Serializable {

    private String eventId;
    /** PRODUTO_CRIADO | PRODUTO_ATUALIZADO | PRODUTO_REMOVIDO */
    private String eventType;
    private Instant occurredAt;

    private String produtoId;
    private String nomeProduto;
    private BigDecimal preco;
    private Integer quantidade;
    private Long versao;

    public ProdutoEventoDTO() {
    }

    public ProdutoEventoDTO(String eventId, String eventType, Instant occurredAt,
                            String produtoId, String nomeProduto,
                            BigDecimal preco, Integer quantidade, Long versao) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.occurredAt = occurredAt;
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.versao = versao;
    }

    public String getEventId()              { return eventId; }
    public void setEventId(String eventId)  { this.eventId = eventId; }

    public String getEventType()                   { return eventType; }
    public void setEventType(String eventType)     { this.eventType = eventType; }

    public Instant getOccurredAt()                    { return occurredAt; }
    public void setOccurredAt(Instant occurredAt)     { this.occurredAt = occurredAt; }

    public String getProdutoId()                  { return produtoId; }
    public void setProdutoId(String produtoId)    { this.produtoId = produtoId; }

    public String getNomeProduto()                     { return nomeProduto; }
    public void setNomeProduto(String nomeProduto)     { this.nomeProduto = nomeProduto; }

    public BigDecimal getPreco()               { return preco; }
    public void setPreco(BigDecimal preco)     { this.preco = preco; }

    public Integer getQuantidade()                   { return quantidade; }
    public void setQuantidade(Integer quantidade)    { this.quantidade = quantidade; }

    public Long getVersao()               { return versao; }
    public void setVersao(Long versao)    { this.versao = versao; }

    @Override
    public String toString() {
        return "ProdutoEventoDTO{" +
                "eventId='" + eventId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", produtoId='" + produtoId + '\'' +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", quantidade=" + quantidade +
                ", versao=" + versao +
                '}';
    }
}
