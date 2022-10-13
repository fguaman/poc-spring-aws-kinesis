package cl.guaman.pocspringawskinesis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PocSpringAwsKinesisApplicationTests {

    @Test
    void contextLoads() {
        String text = "Hello world!!!";
        Assertions.assertEquals("Hello world!!!", text);
    }
}
