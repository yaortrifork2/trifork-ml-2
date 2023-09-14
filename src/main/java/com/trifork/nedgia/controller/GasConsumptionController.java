package com.trifork.nedgia.controller;

import com.trifork.nedgia.dto.ConsumptionAllowedParams;
import com.trifork.nedgia.dto.ConsumptionAllowedResponse;
import com.trifork.nedgia.dto.NextPredictedConsumptionParams;
import com.trifork.nedgia.dto.PredictedConsumptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("nedgia")
@RequiredArgsConstructor
public class GasConsumptionController {

    private final Random random;

    @GetMapping("next-predicted-consumption")
    public ResponseEntity<PredictedConsumptionResponse> nextPredictedConsumption(NextPredictedConsumptionParams params) {

        PredictedConsumptionResponse response = PredictedConsumptionResponse.builder()
                .predicted(random.nextLong())
                .build();

        return ok().body(response);
    }

    @GetMapping("consumption-allowed")
    public ResponseEntity<ConsumptionAllowedResponse> consumptionAllowed(ConsumptionAllowedParams params) {

        ConsumptionAllowedResponse response = ConsumptionAllowedResponse.builder()
                .status(random.nextBoolean())
                .build();

        return ok().body(response);
    }

}
