package com.example.tripvision.member.exception;

import com.example.tripvision.global.exception.BusinessException;
import com.example.tripvision.global.exception.ErrorCode;

/**
 * <h3> </h3>
 */
public class MemberNotFoundException extends BusinessException {

	public MemberNotFoundException(String value) {
		super(value, ErrorCode.USER_NOT_FOUND);
	}

	public MemberNotFoundException(String value, ErrorCode errorCode) {
		super(value, errorCode);
	}
}
