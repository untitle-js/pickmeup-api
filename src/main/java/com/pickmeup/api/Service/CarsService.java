package com.pickmeup.api.Service;

import com.pickmeup.api.dao.CarsDao;
import com.pickmeup.api.model.Carpool;
import com.pickmeup.api.model.Cars;
import java.util.Map;
import java.util.List;
/**
 * Created by Govind on 3/3/2017.
 */
public class CarsService {

    /**
     * Created by Renz on 3/2/17.
     */

        CarsDao dao= new CarsDao();

        public Cars register(Cars car)
        {
            if (car == null)
            {
                throw new IllegalArgumentException();
            }

            Cars registedCar = dao.register(car);
            return car;
        }
    }

