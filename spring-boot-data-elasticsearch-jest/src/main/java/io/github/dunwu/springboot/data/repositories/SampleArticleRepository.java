package io.github.dunwu.springboot.data.repositories;

import io.github.dunwu.springboot.data.entities.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SampleArticleRepository extends ElasticsearchRepository<Article, String> {
}
