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
import com.zsmart.cnss.service.facade.VilleService;
import com.zsmart.cnss.bean.Ville;
import com.zsmart.cnss.ws.rest.vo.VilleVo;
import com.zsmart.cnss.ws.rest.converter.VilleConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/Ville")
@CrossOrigin(origins = {"http://localhost:4200"})
public class VilleRest {

    @Autowired
    private VilleService villeService;

    @Autowired
    private VilleConverter villeConverter;

    @PostMapping("/")
    public VilleVo save(@RequestBody VilleVo villeVo) {
        Ville ville = villeConverter.toItem(villeVo);
        return villeConverter.toVo(villeService.save(ville));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        villeService.deleteById(id);
    }

    @GetMapping("/")
    public List<VilleVo> findAll() {
        return villeConverter.toVo(villeService.findAll());
    }

    public VilleConverter getVilleConverter() {
        return villeConverter;
    }

    public void setVilleConverter(VilleConverter villeConverter) {
        this.villeConverter = villeConverter;
    }

    public VilleService getVilleService() {
        return villeService;
    }

    public void setVilleService(VilleService villeService) {
        this.villeService = villeService;
    }

}
