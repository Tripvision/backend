package com.example.tripvision.member.exception;

import com.example.tripvision.global.exception.BusinessException;
import com.example.tripvision.global.exception.ErrorCode;

public class MemberEmailDuplicateException extends BusinessException {
	public MemberEmailDuplicateException(String message, ErrorCode errorCode) {
		super(message, ErrorCode.EMAIL_DUPLICATION);
	}

	public MemberEmailDuplicateException(ErrorCode errorCode) {
		super(errorCode);
	}
}
