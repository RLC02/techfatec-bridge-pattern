package com.example.produto.consumer;

import com.example.produto.dto.ProdutoEventoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumer {

    private static final Logger log = LoggerFactory.getLogger(ProdutoConsumer.class);

    @RabbitListener(queues = "${app.rabbitmq.queue:produto.queue}")
    public void receberEvento(ProdutoEventoDTO evento) {
        log.info("Evento de produto recebido: {}", evento);
    }
}
