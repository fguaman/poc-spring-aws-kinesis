package cl.guaman.pocspringawskinesis.infrastructure;

import cl.guaman.pocspringawskinesis.domain.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class WEB {

    private final Message.Command command;

    public WEB(KinesisProducer kinesisProducer) {
        this.command = kinesisProducer;
    }

    @GetMapping(path = "/message", produces = "text/plain")
    public ResponseEntity<String> sendMessage() {
        command.send(new Message(UUID.randomUUID().toString(), "Hello from WEB!!!"));
        return ResponseEntity.ok("generated message");
    }
}
