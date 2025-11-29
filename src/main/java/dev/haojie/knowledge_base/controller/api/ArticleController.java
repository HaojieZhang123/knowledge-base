package dev.haojie.knowledge_base.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.haojie.knowledge_base.model.Article;
import dev.haojie.knowledge_base.model.ArticleMetadataDTO;
import dev.haojie.knowledge_base.service.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<ArticleMetadataDTO> getAllArticles(@RequestParam(required = false) String query) {
        if (query != null && !query.isEmpty()) {
            return articleService.searchArticles(query);
        }
        return articleService.getAllArticles();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Article> getArticleBySlug(@PathVariable String slug) {
        return articleService.getArticleBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
