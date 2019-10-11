package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @date 2018-11-01
 */
public class PersonDTO {

	private long id;

	private InfoDTO infoDTO;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public InfoDTO getInfoDTO() {
		return infoDTO;
	}

	public void setInfoDTO(InfoDTO infoDTO) {
		this.infoDTO = infoDTO;
	}

	@Override
	public String toString() {
		return String.format("[PersonBO] id = %d, infoDTO = %s", id, infoDTO.getContent());
	}

}
