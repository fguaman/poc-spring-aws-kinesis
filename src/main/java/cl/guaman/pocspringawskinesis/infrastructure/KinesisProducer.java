package cl.guaman.pocspringawskinesis.infrastructure;


import cl.guaman.pocspringawskinesis.common.JSON;
import cl.guaman.pocspringawskinesis.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@Component
public class KinesisProducer implements Message.Command {
    private static final Logger log = LoggerFactory.getLogger(KinesisProducer.class);
    private final JSON<Message> messageJSON;

    private final BlockingQueue<String> event = new LinkedBlockingQueue<>();


    public KinesisProducer() {
        this.messageJSON = new JSON<>(Message.class);
    }

    @Override
    public void send(Message message) {
        String json = messageJSON.toJson(message);
        boolean result = this.event.offer(json);
        log.info("result={}", result);
    }

    @Bean
    public Supplier<String> producer() {
        return this.event::poll;
    }
}
