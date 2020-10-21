package com.fascalsj.clienttest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientTestApplicationTests {

    @Test
    void contextLoads() {
        ClientTestApplication.main(new String[]{
                "--spring.main.web-environment=false",
        });
        Assertions.assertTrue(true);
    }

}
