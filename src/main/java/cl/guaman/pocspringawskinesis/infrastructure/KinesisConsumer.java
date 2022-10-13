package cl.guaman.pocspringawskinesis.infrastructure;

import cl.guaman.pocspringawskinesis.common.JSON;
import cl.guaman.pocspringawskinesis.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class KinesisConsumer {

    private static final Logger log = LoggerFactory.getLogger(KinesisConsumer.class);
    private  final JSON<Message> messageJSON;

    public KinesisConsumer() {
        this.messageJSON = new JSON<>(Message.class);
    }

    @Bean
    public Consumer<String> consumer() {
        return event -> {
            Message message = messageJSON.toDomain(event);
            log.info("id -> {}", message.getId());
            log.info("text -> {}", message.getText());

        };
    }
}
