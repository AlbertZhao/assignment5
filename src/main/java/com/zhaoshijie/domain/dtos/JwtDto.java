package com.zhaoshijie.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class JwtDto implements Serializable {

	public JwtHeaderDto header;
	public JwtBodyDto body;
}
