package com.example.springboot.demo.Controller;

import com.example.springboot.demo.DemoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DemoApplication.class })
public class TDDDemoControllerTest {


    @Autowired
    TestRestTemplate TestRestTemplate;

    @Test
    public void test_TDDDemoControllerTest_HappyPath() {
        ResponseEntity<String> result = TestRestTemplate.getForEntity("/User/UserInfo?userId=PXM8137", String.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("User is Invalid", result.getBody());
    }

    @Test
    public void test_TDDDemoControllerTest_HappyPath2() {
        ResponseEntity<String> result = TestRestTemplate.getForEntity("/User/UserInfo?userId=RXK8291", String.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("Rohit Kumar", result.getBody());
    }

    @Test
    public void test_TDDDemoControllerTest_missingParameters() {
        ResponseEntity<String> result = TestRestTemplate.getForEntity("/User/UserInfo", String.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void test_TDDDemoControllerTest_incorrectPath() {
        ResponseEntity<String> result = TestRestTemplate.getForEntity("/abcd/example", String.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void test_TDDDemoControllerTest_empty() {
        ResponseEntity<String> result = TestRestTemplate.getForEntity("/User/UserInfo?userId=", String.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("User is Invalid", result.getBody());
    }

    @Test
    public void test_TDDDemoControllerTest_wrongParam() {
        ResponseEntity<String> result = TestRestTemplate.getForEntity("/User/UserInfo?us", String.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void test_TDDDemoControllerTest_wrongParam2() {
        ResponseEntity<String> result = TestRestTemplate.getForEntity("/User/UserInfo?user='RXK8IWY", String.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }



}
