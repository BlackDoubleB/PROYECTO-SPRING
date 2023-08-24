package edu.pe.idat.response;

import java.util.List;

public class DataResponse<T> {
	private T value;
	private List<T> values;
	private String message;
	private boolean success;
	
	public DataResponse(T val) {
		this.value = val;
		this.success = true;
	}
	
	public DataResponse(List<T> val) {
		this.values = val;
		this.success = true;
	}
	
	public DataResponse(boolean suc) {
		this.success = suc;
	}
	
	public static <R> DataResponse<R> fail() {
		
		return new DataResponse<R>(false);
		
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public List<T> getValues() {
		return values;
	}
	public void setValues(List<T> values) {
		this.values = values;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
