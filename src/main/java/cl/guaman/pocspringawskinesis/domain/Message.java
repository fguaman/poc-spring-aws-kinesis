package cl.guaman.pocspringawskinesis.domain;

public class Message {

    private String id;
    private String text;

    public Message() {
    }

    public Message(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public interface Command {
        void send(Message message);
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
