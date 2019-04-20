package com.example.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DemoApplication.class })
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test()
    {
        DemoApplication.main(new String[]{
        });
    }

}
