package com.zhaoshijie.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {

    private String fieldName;
    private String message;
}
