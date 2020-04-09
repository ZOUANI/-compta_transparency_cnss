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
import com.zsmart.cnss.service.facade.SalarieAffiliationService;
import com.zsmart.cnss.bean.SalarieAffiliation;
import com.zsmart.cnss.ws.rest.vo.SalarieAffiliationVo;
import com.zsmart.cnss.ws.rest.converter.SalarieAffiliationConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/SalarieAffiliation")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SalarieAffiliationRest {

    @Autowired
    private SalarieAffiliationService salarieAffiliationService;

    @Autowired
    private SalarieAffiliationConverter salarieAffiliationConverter;

    @PostMapping("/")
    public SalarieAffiliationVo save(@RequestBody SalarieAffiliationVo salarieAffiliationVo) {
        SalarieAffiliation salarieAffiliation = salarieAffiliationConverter.toItem(salarieAffiliationVo);
        return salarieAffiliationConverter.toVo(salarieAffiliationService.save(salarieAffiliation));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        salarieAffiliationService.deleteById(id);
    }

    @GetMapping("/")
    public List<SalarieAffiliationVo> findAll() {
        return salarieAffiliationConverter.toVo(salarieAffiliationService.findAll());
    }

    public SalarieAffiliationConverter getSalarieAffiliationConverter() {
        return salarieAffiliationConverter;
    }

    public void setSalarieAffiliationConverter(SalarieAffiliationConverter salarieAffiliationConverter) {
        this.salarieAffiliationConverter = salarieAffiliationConverter;
    }

    public SalarieAffiliationService getSalarieAffiliationService() {
        return salarieAffiliationService;
    }

    public void setSalarieAffiliationService(SalarieAffiliationService salarieAffiliationService) {
        this.salarieAffiliationService = salarieAffiliationService;
    }

}
