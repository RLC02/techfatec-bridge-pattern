package com.example.produto;

import com.example.produto.dto.ProdutoEventoDTO;
import com.example.produto.producer.ProdutoProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@SpringBootApplication
public class ProdutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutoApplication.class, args);
    }

    @Bean
    CommandLineRunner publicarProdutoInicial(ProdutoProducer producer) {
        return args -> {
            ProdutoEventoDTO evento = new ProdutoEventoDTO(
                    UUID.randomUUID().toString(),
                    "PRODUTO_CRIADO",
                    Instant.now(),
                    UUID.randomUUID().toString(),
                    "Produto Inicial",
                    new BigDecimal("49.90"),
                    100,
                    1L
            );
            producer.send(evento);
        };
    }
}
