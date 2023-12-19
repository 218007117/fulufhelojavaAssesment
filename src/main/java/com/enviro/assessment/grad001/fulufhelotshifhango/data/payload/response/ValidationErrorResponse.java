package com.enviro.assessment.grad001.fulufhelotshifhango.data.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse {

    private String errorMsg;
}
