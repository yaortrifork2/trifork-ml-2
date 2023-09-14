package com.trifork.nedgia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Setter
@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumptionAllowedParams {

    Long time;
    Double consumption;

}
