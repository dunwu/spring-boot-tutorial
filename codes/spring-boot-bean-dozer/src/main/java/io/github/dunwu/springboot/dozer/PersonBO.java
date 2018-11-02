package io.github.dunwu.springboot.dozer;

/**
 * @author Zhang Peng
 * @date 2018-11-01
 */
public class PersonBO {
    private long id;
    private Info info;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return String.format("[PersonBO] id = %d, info = %s", id, info.getContent());
    }
}
