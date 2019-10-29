package org.HappyRestApi.springREST.controllers;

import org.HappyRestApi.springREST.controllers.parse.ParseCalculationPOST;
import org.HappyRestApi.springREST.domain.CalculationData;
import org.HappyRestApi.springREST.services.CalculationDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculationDataController {

    private CalculationDataService calculationDataService;

    public CalculationDataController(CalculationDataService calculationDataService) {
        this.calculationDataService = calculationDataService;
    }

    @RequestMapping(method = RequestMethod.POST, value="api/investments/calculations")
    public ResponseEntity<ParseCalculationPOST> addCalculationData(@RequestBody CalculationData calculationData){

        this.calculationDataService.addCalculationData(calculationData.parce());

        return new ResponseEntity<ParseCalculationPOST> (
                new ParseCalculationPOST(calculationData),
                HttpStatus.OK);
    }

    @GetMapping("api/investments/{id}/calculations")
    public ResponseEntity<CalculationData> getCalculationDtaById(@PathVariable Long id){

        CalculationData calculationData = calculationDataService.findCalculationDataById(id);

        if(calculationData == null)
            return ResponseEntity.notFound().build();

        return new ResponseEntity<CalculationData>(
                calculationData,
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="api/investments/{id}/calculations")
    public void deleteCalculationDtaById(@PathVariable Long id){
        this.calculationDataService.deleteCalculationDataById(id);
    }
}
