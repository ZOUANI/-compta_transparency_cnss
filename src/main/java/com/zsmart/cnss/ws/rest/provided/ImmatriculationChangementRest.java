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
import com.zsmart.cnss.service.facade.ImmatriculationChangementService;
import com.zsmart.cnss.bean.ImmatriculationChangement;
import com.zsmart.cnss.ws.rest.vo.ImmatriculationChangementVo;
import com.zsmart.cnss.ws.rest.converter.ImmatriculationChangementConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/ImmatriculationChangement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ImmatriculationChangementRest {

    @Autowired
    private ImmatriculationChangementService immatriculationChangementService;

    @Autowired
    private ImmatriculationChangementConverter immatriculationChangementConverter;

    @PostMapping("/")
    public ImmatriculationChangementVo save(@RequestBody ImmatriculationChangementVo immatriculationChangementVo) {
        ImmatriculationChangement immatriculationChangement = immatriculationChangementConverter.toItem(immatriculationChangementVo);
        return immatriculationChangementConverter.toVo(immatriculationChangementService.save(immatriculationChangement));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        immatriculationChangementService.deleteById(id);
    }

    @GetMapping("/")
    public List<ImmatriculationChangementVo> findAll() {
        return immatriculationChangementConverter.toVo(immatriculationChangementService.findAll());
    }

    public ImmatriculationChangementConverter getImmatriculationChangementConverter() {
        return immatriculationChangementConverter;
    }

    public void setImmatriculationChangementConverter(ImmatriculationChangementConverter immatriculationChangementConverter) {
        this.immatriculationChangementConverter = immatriculationChangementConverter;
    }

    public ImmatriculationChangementService getImmatriculationChangementService() {
        return immatriculationChangementService;
    }

    public void setImmatriculationChangementService(ImmatriculationChangementService immatriculationChangementService) {
        this.immatriculationChangementService = immatriculationChangementService;
    }

}
