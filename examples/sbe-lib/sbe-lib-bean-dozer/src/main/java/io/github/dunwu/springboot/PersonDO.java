package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @since 2018-11-01
 */
public class PersonDO {

	private Long id;

	private String info;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return String.format("[PersonDO] id = %d, info = %s", id, info);
	}

}
