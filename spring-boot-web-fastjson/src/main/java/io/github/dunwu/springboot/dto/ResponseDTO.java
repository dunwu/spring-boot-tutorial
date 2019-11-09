package io.github.dunwu.springboot.dto;

import java.util.Date;

/**
 * @author Zhang Peng
 * @since 2018-12-29
 */
public class ResponseDTO<T> {

	private Integer code;

	private String message;

	private Date receiveTime;

	private T data;

	public ResponseDTO() {
	}

	public ResponseDTO(Integer code, String message, Date date, T data) {
		this.code = code;
		this.message = message;
		this.receiveTime = date;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDTO{" + "code=" + code + ", message='" + message + '\'' + ", receiveTime=" + receiveTime
			+ ", data=" + data + '}';
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
