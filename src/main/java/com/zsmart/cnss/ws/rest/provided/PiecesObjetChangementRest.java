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
import com.zsmart.cnss.service.facade.PiecesObjetChangementService;
import com.zsmart.cnss.bean.PiecesObjetChangement;
import com.zsmart.cnss.ws.rest.vo.PiecesObjetChangementVo;
import com.zsmart.cnss.ws.rest.converter.PiecesObjetChangementConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/PiecesObjetChangement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PiecesObjetChangementRest {

    @Autowired
    private PiecesObjetChangementService piecesObjetChangementService;

    @Autowired
    private PiecesObjetChangementConverter piecesObjetChangementConverter;

    @PostMapping("/")
    public PiecesObjetChangementVo save(@RequestBody PiecesObjetChangementVo piecesObjetChangementVo) {
        PiecesObjetChangement piecesObjetChangement = piecesObjetChangementConverter.toItem(piecesObjetChangementVo);
        return piecesObjetChangementConverter.toVo(piecesObjetChangementService.save(piecesObjetChangement));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        piecesObjetChangementService.deleteById(id);
    }

    @GetMapping("/")
    public List<PiecesObjetChangementVo> findAll() {
        return piecesObjetChangementConverter.toVo(piecesObjetChangementService.findAll());
    }

    public PiecesObjetChangementConverter getPiecesObjetChangementConverter() {
        return piecesObjetChangementConverter;
    }

    public void setPiecesObjetChangementConverter(PiecesObjetChangementConverter piecesObjetChangementConverter) {
        this.piecesObjetChangementConverter = piecesObjetChangementConverter;
    }

    public PiecesObjetChangementService getPiecesObjetChangementService() {
        return piecesObjetChangementService;
    }

    public void setPiecesObjetChangementService(PiecesObjetChangementService piecesObjetChangementService) {
        this.piecesObjetChangementService = piecesObjetChangementService;
    }

}
