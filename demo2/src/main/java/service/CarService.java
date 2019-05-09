/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Hashtable;
import org.springframework.stereotype.Service;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author ACER
 */
@Service
public class CarService {
    Hashtable<String, Car> cars = new Hashtable<String, Car>();
    
    public CarService(){
        Car c = new Car();
       // c.setId("1");
        c.setManufacturer("Honda");
        c.setName("Civic");
        cars.put("1",c);
        
        c = new Car();
        //c.setId("2");
        c.setManufacturer("Toyota");
        c.setName("Estima");
        cars.put("2",c);
    }
    public Car getCar(String id){
        if (cars.containsKey(id))
            return cars.get(id);
        else
            return null;
    }
    public Hashtable<String, Car>getAll(){
        return cars;
    } 

}
