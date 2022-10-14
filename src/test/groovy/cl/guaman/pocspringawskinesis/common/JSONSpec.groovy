package cl.guaman.pocspringawskinesis.common

import cl.guaman.pocspringawskinesis.domain.Message
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

class JSONSpec extends Specification {

    private JSON<Message> messageJSON = new JSON<>(Message.class)
    private JSON<String> stringJSON = new JSON<>(String.class)


    def "domain to json and json to domain"() {
        given:
        Message message = new Message("1", "Hello")
        Message messageTwo = new Message()
        when:
        String json = messageJSON.toJson(message)
        Message messageThree = messageJSON.toDomain(json)
        then:
        Objects.nonNull(json)
        messageThree.getId() == "1"
        messageThree.getText() == "Hello"
        messageTwo.id == null
    }

    def "bad json to domain and bad domain to json"() {
        given:
        String badJson = "{\"}"
        String badDomain = "{\"lastname}"
        when:
        Message message = messageJSON.toDomain(badJson)
        String json = stringJSON.toJson(badDomain)
        then:
        message === null
        json !== null
    }
}
