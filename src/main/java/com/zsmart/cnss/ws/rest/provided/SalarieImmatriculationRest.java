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
import com.zsmart.cnss.service.facade.SalarieImmatriculationService;
import com.zsmart.cnss.bean.SalarieImmatriculation;
import com.zsmart.cnss.ws.rest.vo.SalarieImmatriculationVo;
import com.zsmart.cnss.ws.rest.converter.SalarieImmatriculationConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/SalarieImmatriculation")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SalarieImmatriculationRest {

    @Autowired
    private SalarieImmatriculationService salarieImmatriculationService;

    @Autowired
    private SalarieImmatriculationConverter salarieImmatriculationConverter;

    @PostMapping("/")
    public SalarieImmatriculationVo save(@RequestBody SalarieImmatriculationVo salarieImmatriculationVo) {
        SalarieImmatriculation salarieImmatriculation = salarieImmatriculationConverter.toItem(salarieImmatriculationVo);
        return salarieImmatriculationConverter.toVo(salarieImmatriculationService.save(salarieImmatriculation));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        salarieImmatriculationService.deleteById(id);
    }

    @GetMapping("/")
    public List<SalarieImmatriculationVo> findAll() {
        return salarieImmatriculationConverter.toVo(salarieImmatriculationService.findAll());
    }

    public SalarieImmatriculationConverter getSalarieImmatriculationConverter() {
        return salarieImmatriculationConverter;
    }

    public void setSalarieImmatriculationConverter(SalarieImmatriculationConverter salarieImmatriculationConverter) {
        this.salarieImmatriculationConverter = salarieImmatriculationConverter;
    }

    public SalarieImmatriculationService getSalarieImmatriculationService() {
        return salarieImmatriculationService;
    }

    public void setSalarieImmatriculationService(SalarieImmatriculationService salarieImmatriculationService) {
        this.salarieImmatriculationService = salarieImmatriculationService;
    }

}
