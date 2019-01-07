package io.github.dunwu.springboot;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Zhang Peng
 * @date 2019-01-06
 */
@RestController
public class ApiController {


    @RequestMapping(value = "/api/model")
    public ResponseDTO<Model> index() {

        Model model = new Model();
        model.setId(1L);
        model.setProductid(UUID.randomUUID().toString());
        model.setProductname("xx产品");
        model.setStatus("上线");
        model.setItemid("ITEM-A");
        model.setUnitcost(10.0);
        model.setListprice(36.5);
        model.setAttr1("Large");

        List<Model> list = new ArrayList<>();
        list.add(model);

        return new ResponseDTO<>(list.size(), list);
    }


}
