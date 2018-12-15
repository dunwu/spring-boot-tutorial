package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @date 2018-11-02
 */
public class UserDO {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[UserDO] id = %d, name = %s", id, name);
    }
}
