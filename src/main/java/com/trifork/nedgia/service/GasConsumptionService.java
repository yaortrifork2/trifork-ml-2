package com.trifork.nedgia.service;

import com.trifork.nedgia.dto.ConsumptionAllowedResponse;
import com.trifork.nedgia.dto.PredictedConsumptionResponse;

public interface GasConsumptionService {

    PredictedConsumptionResponse getPredictedConsumption(Long time);

    ConsumptionAllowedResponse isConsumptionAllowed(Long time, Double consumption);

}
