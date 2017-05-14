package com.yue.util;

public class JsonResult<T> {
	private String code;
	private T data;
	private String message;
	
	public JsonResult(T t){
		code="OK";
		data=t;
		message="成功";
	}
	public JsonResult(Throwable e){
		code="ServerError";
		data=null;
		message="服务器错误500";
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
