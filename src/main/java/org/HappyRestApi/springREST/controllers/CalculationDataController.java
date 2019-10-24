package org.HappyRestApi.springREST.controllers;

import org.HappyRestApi.springREST.controllers.parse.ParseCalculationPOST;
import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.services.CalculationDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculationDataController {

    private CalculationDataService calculationDataService;

    public CalculationDataController(CalculationDataService calculationDataService) {
        this.calculationDataService = calculationDataService;
    }

    @RequestMapping(method = RequestMethod.POST, value="api/investments/calculations")
    public ParseCalculationPOST addCalculationData(@RequestBody CalculationData calculationData){
        this.calculationDataService.addCalculationData(calculationData);
        return new ParseCalculationPOST(calculationData);
    }

    @GetMapping("api/investments/{id}/calculations")
    public CalculationData getCalculationDtaById(@PathVariable Long id){
        return calculationDataService.findCalculationDataById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="api/investments/{id}/calculations")
    public void deleteCalculationDtaById(@PathVariable Long id){
        this.calculationDataService.deleteCalculationDataById(id);
    }
}
