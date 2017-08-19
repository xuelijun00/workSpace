package com.yks.bi.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code=HttpStatus.FORBIDDEN,reason="权限不足",value=HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
	
	public ForbiddenException(String exception){
		super("权限不足");
	}

}
