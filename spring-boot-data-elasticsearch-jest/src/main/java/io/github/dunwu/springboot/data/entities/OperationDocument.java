package io.github.dunwu.springboot.data.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

@Data
@ToString
@Document(indexName = "operations", type = "operation")
public class OperationDocument {

	@Id
	private Long id;

	@Field(
		type = FieldType.Text,
		searchAnalyzer = "standard",
		analyzer = "standard",
		store = true
	)
	private String operationName;

	@Field(
		type = FieldType.Date,
		index = false,
		store = true,
		format = DateFormat.custom,
		pattern = "yyyy-MM-dd hh:mm:ss"
	)
	private Date dateUp;

	@Field(
		type = FieldType.Text,
		index = false,
		store = false
	)
	private String someTransientData;

	@Field(type = FieldType.Nested)
	private List<Sector> sectors;

}

