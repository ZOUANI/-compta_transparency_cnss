package com.zsmart.cnss.ws.rest.provided;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.cnss.service.facade.AffilieService;
import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.ws.rest.vo.AffilieVo;
import com.zsmart.cnss.ws.rest.converter.AffilieConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/Affilie")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AffilieRest {

    @Autowired
    private AffilieService affilieService;

    @Autowired
    private AffilieConverter affilieConverter;

    @PostMapping("/")
    public AffilieVo save(@RequestBody AffilieVo affilieVo) {
        Affilie affilie = affilieConverter.toItem(affilieVo);
        return affilieConverter.toVo(affilieService.save(affilie));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        affilieService.deleteById(id);
    }

    @GetMapping("/")
    public List<AffilieVo> findAll() {
        return affilieConverter.toVo(affilieService.findAll());
    }

    public AffilieConverter getAffilieConverter() {
        return affilieConverter;
    }

    public void setAffilieConverter(AffilieConverter affilieConverter) {
        this.affilieConverter = affilieConverter;
    }

    public AffilieService getAffilieService() {
        return affilieService;
    }

    public void setAffilieService(AffilieService affilieService) {
        this.affilieService = affilieService;
    }

}
