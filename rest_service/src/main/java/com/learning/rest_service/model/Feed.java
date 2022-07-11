package com.learning.rest_service.model;

import javax.persistence.*;

@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String imageUrl;
    private String about;
    private String siteUrl;
    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Feed() {
    }

    public Feed(String title, String imageUrl, String about, String siteUrl, User author, Category category) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.about = about;
        this.siteUrl = siteUrl;
        this.author = author;
        this.category=category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAbout() {
        return about;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public User getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}