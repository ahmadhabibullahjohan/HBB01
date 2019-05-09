/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.json.JSONException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

//@ComponentScan({"model","service"})
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/**
 *
 * @author ACER
 */
public class CarControllerIT {
    
    @LocalServerPort
    private int port;
    
    TestRestTemplate restTemplate = new TestRestTemplate();
    
    HttpHeaders headers = new HttpHeaders();
    /**
    @Test
    public void testCreateCar() throws JSONException{
        
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
            createURLWithPort("/hello"),
            HttpMethod.GET, entity, String.class);
        
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("/hello"));
        
    }**/
    @Test
    public void testRetreiveCar() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/hello"), HttpMethod.GET, entity, String.class);
        String expected = "{\"2\":{\"manufacturer\":\"Honda\",\"name\":\"City\",\"id\":\"City\"},\"1\":{\"manufacturer\":\"Honda\",\"name\":\"Civic\",\"id\":\"Civic\"}}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    
    private String createURLWithPort(String url){
        return "http://localhost:"+ 8080 + url;
    }
    
}
