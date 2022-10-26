package com.example.tripvision.global.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
	// Common
	INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
	METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
	ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
	INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
	INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
	HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),
	ALREADY_USER(400, "C007", "ALREADY USER"),

	// Member
	EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
	LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid"),
	USER_NOT_FOUND(404, "U001", "해당 유저가 존재하지 않습니다."),

	// Journal
	JOURNAL_NOT_FOUND(404, "J001", "해당 다이어리가 존재하지 않습니다."),

	// Post
	POST_NOT_FOUND(404, "P001", "해당 포스트가 존재하지 않습니다."),

	// Post Photo
	POST_PHOTO_NOT_FOUND(404, "T001", "해당 포스트의 이미지가 존재하지 않습니다.");
	private final String code;
	private final String message;
	private final int status;

	ErrorCode(final int status, final String code, final String message) {
		this.status = status;
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public String getCode() {
		return code;
	}

	public int getStatus() {
		return status;
	}

}

