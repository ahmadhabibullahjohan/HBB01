/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Hashtable;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CarService;

/**
 *
 * @author ACER
 */
@ComponentScan({"model","service"})
@RestController
//@RequestMapping("/hello")
public class CarController {
    
    @Autowired
    CarService cs;
    
    
    @RequestMapping("/hello")
    public Hashtable<String, Car>getAll(){
        return cs.getAll();
    }
    
    @RequestMapping("/{id}")
    public Car getCar(@PathVariable("id")String id){
        return cs.getCar(id);
    }
    
}
