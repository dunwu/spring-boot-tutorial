package io.github.dunwu.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "io.github.dunwu")
public class DunwuProperties {

	private int id;

	@Value("io.github.dunwu.author")
	private String author;

	private GenderEnum sex;

	private String mail;

	private List<String> interestList;

	private Map<String, String> infoMap;

	private Map<String, List<String>> skillMap;

	@Override
	public String toString() {
		return "DunwuProperties{" +
			"id=" + id +
			", author='" + author + '\'' +
			", sex=" + sex +
			", mail='" + mail + '\'' +
			", interestList=" + interestList +
			", infoMap=" + infoMap +
			", skillMap=" + skillMap +
			'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public GenderEnum getSex() {
		return sex;
	}

	public void setSex(GenderEnum sex) {
		this.sex = sex;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<String> getInterestList() {
		return interestList;
	}

	public void setInterestList(List<String> interestList) {
		this.interestList = interestList;
	}

	public Map<String, String> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, String> infoMap) {
		this.infoMap = infoMap;
	}

	public Map<String, List<String>> getSkillMap() {
		return skillMap;
	}

	public void setSkillMap(Map<String, List<String>> skillMap) {
		this.skillMap = skillMap;
	}

}
