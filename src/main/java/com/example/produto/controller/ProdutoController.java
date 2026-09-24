package com.example.produto.controller;

import com.example.produto.dto.ProdutoDTO;
import com.example.produto.dto.ProdutoEventoDTO;
import com.example.produto.producer.ProdutoProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoProducer produtoProducer;

    public ProdutoController(ProdutoProducer produtoProducer) {
        this.produtoProducer = produtoProducer;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrarProduto(
            @RequestBody(required = false) ProdutoDTO request) {

        ProdutoDTO produto = request != null ? request : new ProdutoDTO();

        if (produto.getId() == null || produto.getId().isBlank()) {
            produto.setId(UUID.randomUUID().toString());
        }
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            produto.setNome("Produto Teste");
        }
        if (produto.getPreco() == null) {
            produto.setPreco(new BigDecimal("99.90"));
        }
        if (produto.getQuantidade() == null) {
            produto.setQuantidade(10);
        }

        // Converte ProdutoDTO → ProdutoEventoDTO (contrato com o serviço de venda)
        ProdutoEventoDTO evento = new ProdutoEventoDTO(
                UUID.randomUUID().toString(),   // eventId único por publicação
                "PRODUTO_CRIADO",
                Instant.now(),
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade(),
                1L                              // versão inicial
        );

        produtoProducer.send(evento);

        return ResponseEntity.ok(Map.of(
                "status", "PRODUTO_PUBLICADO",
                "eventId", evento.getEventId(),
                "produto", produto
        ));
    }
}
