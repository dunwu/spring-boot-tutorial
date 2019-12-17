package io.github.dunwu.springboot.data.repositories;

import io.github.dunwu.springboot.data.entities.OperationDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OperationDocumentRepository extends ElasticsearchRepository<OperationDocument, Long> {
}
