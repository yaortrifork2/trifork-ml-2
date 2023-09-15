package com.trifork.nedgia.service;

import com.trifork.nedgia.dto.ConsumptionAllowedResponse;
import com.trifork.nedgia.dto.PredictedConsumptionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Math.abs;
import static java.util.Optional.of;

@Slf4j
@Service
@RequiredArgsConstructor
public class GasConsumptionServiceImpl implements GasConsumptionService {

    private final Random random;

    @Override
    public PredictedConsumptionResponse getPredictedConsumption(Long time) {
        Double predicted = random.nextGaussian() * 4527 + 28534;

        return PredictedConsumptionResponse.builder()
                .predicted(predicted)
                .build();

    }

    @Override
    public ConsumptionAllowedResponse isConsumptionAllowed(Long time, Double consumption) {
        Double predicted = random.nextGaussian() * 4527 + 28534;

        Boolean status = of(predicted)
                .filter(p -> abs(p - consumption) < 5000)
                .map(x -> TRUE)
                .orElse(FALSE);

        return ConsumptionAllowedResponse.builder()
                .status(status)
                .build();

    }


}
