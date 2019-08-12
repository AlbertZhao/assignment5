package com.zhaoshijie.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class JwtBodyDto implements Serializable {

	public String sub;
	public String aud;
	public String uid;
	public Long nbf;
	public Long exp;
	public Long iat;
	public String uuid;
	public String correlationId;

}
