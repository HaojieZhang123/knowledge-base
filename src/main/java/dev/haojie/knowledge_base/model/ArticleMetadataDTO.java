package dev.haojie.knowledge_base.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class ArticleMetadataDTO {

    private Long id;

    @NotBlank
    private String slug;

    @NotBlank
    private String title;

    private String summary;

    private List<String> tags;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    // constructors
    public ArticleMetadataDTO() {
    }

    public ArticleMetadataDTO(Long id, String slug, String title, String summary, List<String> tags,
            LocalDate createdAt,
            LocalDate updatedAt) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.summary = summary;
        this.tags = tags;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
