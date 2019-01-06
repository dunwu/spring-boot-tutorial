package io.github.dunwu.springboot;

import java.util.List;

/**
 * @author Zhang Peng
 * @date 2019-01-06
 */
public class ResponseDTO<T> {
    private Integer total;
    private List<T> rows;

    public ResponseDTO(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
