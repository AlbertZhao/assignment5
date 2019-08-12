package com.zhaoshijie.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class JwtHeaderDto implements Serializable {

	public String typ;
	public String alg;
}
