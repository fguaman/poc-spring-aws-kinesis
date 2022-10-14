package cl.guaman.pocspringawskinesis.infrastructure

import cl.guaman.pocspringawskinesis.domain.Message
import spock.lang.Specification

class KinesisProducerSpec extends Specification {

    private KinesisProducer kinesisProducer

    def "send message one time in producer"() {
        given:
        kinesisProducer= new KinesisProducer()
        Message message=new Message("1","hello world")
        when:
        kinesisProducer.send(message)
        then:
        0 * kinesisProducer.send(message)
    }
}
