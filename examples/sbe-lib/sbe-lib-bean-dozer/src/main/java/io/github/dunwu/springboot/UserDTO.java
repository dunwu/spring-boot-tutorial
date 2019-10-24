package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @since 2018-11-02
 */
public class UserDTO {

	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return String.format("[UserBO] id = %d, name = %s", id, name);
	}

}
