package com.pickmeup.api.controller;

import com.pickmeup.api.model.Cars;
import com.pickmeup.api.Service.CarsService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Govind on 12/22/2016.
 */
@RestController
@RequestMapping("/cars" )
public class CarController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Cars register(@RequestBody Cars car) {
        CarsService service = new CarsService();
        Cars registeredCar = service.register(car);
        return registeredCar;
    }
}



