package com.pickmeup.api.controller;

import com.pickmeup.api.Service.CarpoolService;
import com.pickmeup.api.model.Carpool;
import com.pickmeup.api.model.CarpoolUsers;
import com.pickmeup.api.model.CarpoolUsersDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by selva on 3/6/2017.
 */
@RestController
@RequestMapping("/carpool" )
public class CarpoolController {

    @RequestMapping(value="/list" ,method = RequestMethod.GET)
    public List<Carpool> listCarpool()
    {
        CarpoolService service = new CarpoolService();
        return service.listCarpool();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Carpool addCarpool(@RequestBody Carpool carpool)
    {
        CarpoolService service = new CarpoolService();
        service.addCarpool(carpool);
        return carpool;
    }

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public CarpoolUsers addUser(@RequestBody CarpoolUsers carpoolUsers)
    {
        CarpoolService service = new CarpoolService();
        service.addCarpoolUser(carpoolUsers);
        return carpoolUsers;
    }

    @RequestMapping(value="/getAllUsers", method = RequestMethod.GET)
    public List<CarpoolUsersDetails> addUser(@RequestParam Map<String, String> params)
    {
        CarpoolService service = new CarpoolService();
        return service.listCarpoolUsers(params);
    }
}
