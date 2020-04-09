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
import com.zsmart.cnss.service.facade.PiecesImmatriculationChangementService;
import com.zsmart.cnss.bean.PiecesImmatriculationChangement;
import com.zsmart.cnss.ws.rest.vo.PiecesImmatriculationChangementVo;
import com.zsmart.cnss.ws.rest.converter.PiecesImmatriculationChangementConverter;
import com.zsmart.cnss.service.util.*;

@RestController
@RequestMapping("/cnss/PiecesImmatriculationChangement")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PiecesImmatriculationChangementRest {

    @Autowired
    private PiecesImmatriculationChangementService piecesImmatriculationChangementService;

    @Autowired
    private PiecesImmatriculationChangementConverter piecesImmatriculationChangementConverter;

    @PostMapping("/")
    public PiecesImmatriculationChangementVo save(@RequestBody PiecesImmatriculationChangementVo piecesImmatriculationChangementVo) {
        PiecesImmatriculationChangement piecesImmatriculationChangement = piecesImmatriculationChangementConverter.toItem(piecesImmatriculationChangementVo);
        return piecesImmatriculationChangementConverter.toVo(piecesImmatriculationChangementService.save(piecesImmatriculationChangement));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        piecesImmatriculationChangementService.deleteById(id);
    }

    @GetMapping("/")
    public List<PiecesImmatriculationChangementVo> findAll() {
        return piecesImmatriculationChangementConverter.toVo(piecesImmatriculationChangementService.findAll());
    }

    public PiecesImmatriculationChangementConverter getPiecesImmatriculationChangementConverter() {
        return piecesImmatriculationChangementConverter;
    }

    public void setPiecesImmatriculationChangementConverter(PiecesImmatriculationChangementConverter piecesImmatriculationChangementConverter) {
        this.piecesImmatriculationChangementConverter = piecesImmatriculationChangementConverter;
    }

    public PiecesImmatriculationChangementService getPiecesImmatriculationChangementService() {
        return piecesImmatriculationChangementService;
    }

    public void setPiecesImmatriculationChangementService(PiecesImmatriculationChangementService piecesImmatriculationChangementService) {
        this.piecesImmatriculationChangementService = piecesImmatriculationChangementService;
    }

}
