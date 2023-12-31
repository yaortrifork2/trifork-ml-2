package com.trifork.nedgia.service;

import com.trifork.nedgia.dto.ConsumptionAllowedResponse;
import com.trifork.nedgia.dto.PredictedConsumptionResponse;
import com.trifork.nedgia.repository.GasConsumptionRepository;
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
    private final GasConsumptionRepository repository;

    @Override
    public PredictedConsumptionResponse getPredictedConsumption(Long time) {

        Double predicted = repository.get(time)
                .orElse(random.nextGaussian() * 4527 + 28534);

        repository.save(time, predicted);

        return PredictedConsumptionResponse.builder()
                .predicted(predicted)
                .build();

    }

    @Override
    public ConsumptionAllowedResponse isConsumptionAllowed(Long time, Double consumption) {

        Double finalPred = repository.get(time)
                .orElseGet(() -> {
                    Double predicted = random.nextGaussian() * 4527 + 28534;
                    repository.save(time, predicted);
                    return predicted;
                });

        Boolean status = of(finalPred)
                .filter(p -> abs(p - consumption) < 5000)
                .map(x -> TRUE)
                .orElse(FALSE);

        return ConsumptionAllowedResponse.builder()
                .status(status)
                .build();

    }


}
