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
import com.zsmart.cnss.service.facade.TypeDemandeService;
import com.zsmart.cnss.bean.TypeDemande;
import com.zsmart.cnss.ws.rest.vo.TypeDemandeVo;
import com.zsmart.cnss.ws.rest.converter.TypeDemandeConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/TypeDemande")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypeDemandeRest {

    @Autowired
    private TypeDemandeService typeDemandeService;

    @Autowired
    private TypeDemandeConverter typeDemandeConverter;

    @PostMapping("/")
    public TypeDemandeVo save(@RequestBody TypeDemandeVo typeDemandeVo) {
        TypeDemande typeDemande = typeDemandeConverter.toItem(typeDemandeVo);
        return typeDemandeConverter.toVo(typeDemandeService.save(typeDemande));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        typeDemandeService.deleteById(id);
    }

    @GetMapping("/")
    public List<TypeDemandeVo> findAll() {
        return typeDemandeConverter.toVo(typeDemandeService.findAll());
    }

    public TypeDemandeConverter getTypeDemandeConverter() {
        return typeDemandeConverter;
    }

    public void setTypeDemandeConverter(TypeDemandeConverter typeDemandeConverter) {
        this.typeDemandeConverter = typeDemandeConverter;
    }

    public TypeDemandeService getTypeDemandeService() {
        return typeDemandeService;
    }

    public void setTypeDemandeService(TypeDemandeService typeDemandeService) {
        this.typeDemandeService = typeDemandeService;
    }

}
