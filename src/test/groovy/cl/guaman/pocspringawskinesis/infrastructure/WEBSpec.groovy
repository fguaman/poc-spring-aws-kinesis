package cl.guaman.pocspringawskinesis.infrastructure

import org.springframework.http.ResponseEntity
import spock.lang.Specification

class WEBSpec extends Specification {

    private WEB web
    private KinesisProducer kinesisProducer = Mock()

    def "send message and return 2XX"() {
        given:
        kinesisProducer.send(_) >> {}
        web = new WEB(kinesisProducer)
        when:
        ResponseEntity response = web.sendMessage()
        then:
        response.statusCode.is2xxSuccessful()
    }
}
