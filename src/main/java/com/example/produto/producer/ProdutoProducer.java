package com.example.produto.producer;

import com.example.produto.dto.ProdutoEventoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProdutoProducer {

    private static final Logger log = LoggerFactory.getLogger(ProdutoProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange:produto.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routingkey:produto.created}")
    private String routingKey;

    public ProdutoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(ProdutoEventoDTO evento) {
        log.info(">>> [PRODUTO] Enviando evento | tipo={} | produto={} | qtd={}",
                evento.getEventType(), evento.getNomeProduto(), evento.getQuantidade());
        try {
            String json = new com.fasterxml.jackson.databind.ObjectMapper()
                    .registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule())
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(evento);
            log.info(">>> [PRODUTO] Payload JSON:\n{}", json);
        } catch (Exception e) {
            log.warn(">>> [PRODUTO] Não foi possível serializar o JSON: {}", e.getMessage());
        }
        rabbitTemplate.convertAndSend(exchange, routingKey, evento);
        log.info(">>> [PRODUTO] Evento publicado na fila '{}'", exchange);
    }
}
