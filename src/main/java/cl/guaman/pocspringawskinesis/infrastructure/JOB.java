package cl.guaman.pocspringawskinesis.infrastructure;

import cl.guaman.pocspringawskinesis.domain.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JOB {

    private final Message.Command command;

    public JOB(KinesisProducer kinesisProducer) {
        this.command = kinesisProducer;
    }

    @Scheduled(fixedDelay = 20000)
    void init() {
        this.command.send(new Message(UUID.randomUUID().toString(), "Hello from JOB!!!"));
    }
}
