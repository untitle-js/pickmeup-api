package com.pickmeup.api.Service;

import com.pickmeup.api.dao.CarpoolDao;
import com.pickmeup.api.model.Carpool;
import com.pickmeup.api.model.CarpoolUsers;
import com.pickmeup.api.model.CarpoolUsersDetails;

import java.util.List;
import java.util.Map;

/**
 * Created by selva on 3/6/2017.
 */
public class CarpoolService {

    public List<Carpool> listCarpool()
    {
        CarpoolDao dao= new CarpoolDao();
        List<Carpool> carsList= dao.listCarpool();
        return carsList;
    }

    public List<CarpoolUsersDetails> listCarpoolUsers(Map<String, String> params)
    {
        CarpoolDao dao= new CarpoolDao();
        return dao.listCarpoolUsers(params);
    }

    public Carpool addCarpool(Carpool carpool)
    {
        CarpoolDao dao= new CarpoolDao();
        if (carpool == null)
        {
            throw new IllegalArgumentException();
        }
        return dao.addCarpool(carpool);
    }

    public CarpoolUsers addCarpoolUser(CarpoolUsers carpoolUser)
    {
        CarpoolDao dao= new CarpoolDao();
        if (carpoolUser == null)
        {
            throw new IllegalArgumentException();
        }
        return dao.addCarpoolUser(carpoolUser);
    }

}
