package com.zhaoshijie.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RestErrorResponse {

    private String correlationId;

    private String statusCode;

    private String statusDesc;

    @JsonProperty("errorInfo")
    private List<ErrorDetails> errorInfo;
}
