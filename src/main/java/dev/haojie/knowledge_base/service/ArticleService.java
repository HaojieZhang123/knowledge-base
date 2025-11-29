package dev.haojie.knowledge_base.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.haojie.knowledge_base.model.Article;
import dev.haojie.knowledge_base.model.ArticleMetadataDTO;
import dev.haojie.knowledge_base.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // get all articles (metadata only)
    public List<ArticleMetadataDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(Article::getMetadata)
                .collect(Collectors.toList());
    }

    // get article by slug
    public Optional<Article> getArticleBySlug(String slug) {
        return articleRepository.findBySlug(slug);
    }

    // search article by query (metadata only)
    public List<ArticleMetadataDTO> searchArticles(String query) {
        return articleRepository.findAllByTitleContainingIgnoreCase(query).stream()
                .map(Article::getMetadata)
                .collect(Collectors.toList());
    }
}
