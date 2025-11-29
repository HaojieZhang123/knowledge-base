package dev.haojie.knowledge_base.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.haojie.knowledge_base.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findBySlug(String slug);

    List<Article> findAllByTitleContainingIgnoreCase(String title);
}
