package com.example.tripvision.global.exception;

/**
 * BusinessException 처리를 위한 RuntimeException 을 상속받는 클래스입니다.
 *
 */
public class BusinessException extends RuntimeException {

	private final ErrorCode errorCode;

	public BusinessException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
