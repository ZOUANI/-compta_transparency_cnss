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
import com.zsmart.cnss.service.facade.ObjetChangementImmatriculationService;
import com.zsmart.cnss.bean.ObjetChangementImmatriculation;
import com.zsmart.cnss.ws.rest.vo.ObjetChangementImmatriculationVo;
import com.zsmart.cnss.ws.rest.converter.ObjetChangementImmatriculationConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/ObjetChangementImmatriculation")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ObjetChangementImmatriculationRest {

    @Autowired
    private ObjetChangementImmatriculationService objetChangementImmatriculationService;

    @Autowired
    private ObjetChangementImmatriculationConverter objetChangementImmatriculationConverter;

    @PostMapping("/")
    public ObjetChangementImmatriculationVo save(@RequestBody ObjetChangementImmatriculationVo objetChangementImmatriculationVo) {
        ObjetChangementImmatriculation objetChangementImmatriculation = objetChangementImmatriculationConverter.toItem(objetChangementImmatriculationVo);
        return objetChangementImmatriculationConverter.toVo(objetChangementImmatriculationService.save(objetChangementImmatriculation));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        objetChangementImmatriculationService.deleteById(id);
    }

    @GetMapping("/")
    public List<ObjetChangementImmatriculationVo> findAll() {
        return objetChangementImmatriculationConverter.toVo(objetChangementImmatriculationService.findAll());
    }

    public ObjetChangementImmatriculationConverter getObjetChangementImmatriculationConverter() {
        return objetChangementImmatriculationConverter;
    }

    public void setObjetChangementImmatriculationConverter(ObjetChangementImmatriculationConverter objetChangementImmatriculationConverter) {
        this.objetChangementImmatriculationConverter = objetChangementImmatriculationConverter;
    }

    public ObjetChangementImmatriculationService getObjetChangementImmatriculationService() {
        return objetChangementImmatriculationService;
    }

    public void setObjetChangementImmatriculationService(ObjetChangementImmatriculationService objetChangementImmatriculationService) {
        this.objetChangementImmatriculationService = objetChangementImmatriculationService;
    }

}
