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
import com.zsmart.cnss.service.facade.LieuActiviteService;
import com.zsmart.cnss.bean.LieuActivite;
import com.zsmart.cnss.ws.rest.vo.LieuActiviteVo;
import com.zsmart.cnss.ws.rest.converter.LieuActiviteConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/LieuActivite")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LieuActiviteRest {

    @Autowired
    private LieuActiviteService lieuActiviteService;

    @Autowired
    private LieuActiviteConverter lieuActiviteConverter;

    @PostMapping("/")
    public LieuActiviteVo save(@RequestBody LieuActiviteVo lieuActiviteVo) {
        LieuActivite lieuActivite = lieuActiviteConverter.toItem(lieuActiviteVo);
        return lieuActiviteConverter.toVo(lieuActiviteService.save(lieuActivite));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        lieuActiviteService.deleteById(id);
    }

    @GetMapping("/")
    public List<LieuActiviteVo> findAll() {
        return lieuActiviteConverter.toVo(lieuActiviteService.findAll());
    }

    public LieuActiviteConverter getLieuActiviteConverter() {
        return lieuActiviteConverter;
    }

    public void setLieuActiviteConverter(LieuActiviteConverter lieuActiviteConverter) {
        this.lieuActiviteConverter = lieuActiviteConverter;
    }

    public LieuActiviteService getLieuActiviteService() {
        return lieuActiviteService;
    }

    public void setLieuActiviteService(LieuActiviteService lieuActiviteService) {
        this.lieuActiviteService = lieuActiviteService;
    }

}
