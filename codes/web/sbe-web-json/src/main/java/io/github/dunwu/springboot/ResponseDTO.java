package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @date 2018-12-29
 */
public class ResponseDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseDTO() {}

    public ResponseDTO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
