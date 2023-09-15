package com.trifork.nedgia.controller;

import com.trifork.nedgia.dto.ConsumptionAllowedParams;
import com.trifork.nedgia.dto.ConsumptionAllowedResponse;
import com.trifork.nedgia.dto.NextPredictedConsumptionParams;
import com.trifork.nedgia.dto.PredictedConsumptionResponse;
import com.trifork.nedgia.service.GasConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("nedgia")
@RequiredArgsConstructor
public class GasConsumptionController {

    GasConsumptionService gasConsumptionService;

    @GetMapping("next-predicted-consumption")
    public ResponseEntity<PredictedConsumptionResponse> nextPredictedConsumption(NextPredictedConsumptionParams params) {

        PredictedConsumptionResponse response = gasConsumptionService.getPredictedConsumption(params.getTime());
        return ok().body(response);

    }

    @GetMapping("consumption-allowed")
    public ResponseEntity<ConsumptionAllowedResponse> consumptionAllowed(ConsumptionAllowedParams params) {

        ConsumptionAllowedResponse response = gasConsumptionService.isConsumptionAllowed(params.getTime(), params.getConsumption());
        return ok().body(response);

    }

}
