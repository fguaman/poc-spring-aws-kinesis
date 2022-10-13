package cl.guaman.pocspringawskinesis.infrastructure

import spock.lang.Specification

class JOBSpec extends Specification {

    private JOB job;
    private KinesisProducer kinesisProducer = Mock();

    def "send message one time"() {
        given:
        kinesisProducer.send(_) >> {}
        job = new JOB(kinesisProducer)
        when:
        job.init()
        then:
        0 * job.init()
    }
}
