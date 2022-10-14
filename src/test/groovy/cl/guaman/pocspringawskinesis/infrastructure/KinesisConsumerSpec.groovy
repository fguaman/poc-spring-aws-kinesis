package cl.guaman.pocspringawskinesis.infrastructure

import spock.lang.Specification

import java.util.function.Consumer

class KinesisConsumerSpec extends Specification {

    private KinesisConsumer kinesisConsumer
    private Consumer<String> consumer = Stub()

    def "consume data"() {
        given:
        kinesisConsumer = new KinesisConsumer()
        when:
         consumer = kinesisConsumer.consumer()
        then:
        consumer != null
    }
}
