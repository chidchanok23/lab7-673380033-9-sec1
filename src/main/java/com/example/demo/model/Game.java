package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String platform;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDate releaseDate;

    // ค่าที่รับมาจาก Form (NONE, STUDENT, SEASONAL)
    @Column(nullable = false)
    private String discountType;

    // ชื่อโปรโมชั่นที่จะแสดงใน list.html
    private String discountName;

    // ราคาหลังหักส่วนลดที่จะแสดงใน list.html
    private Double finalPrice;

    public Game() {
    }

    public Game(Long id,
                String title,
                String genre,
                String platform,
                Double rating,
                Double price,
                LocalDate releaseDate,
                String discountType,
                String discountName,
                Double finalPrice) {

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.price = price;
        this.releaseDate = releaseDate;
        this.discountType = discountType;
        this.discountName = discountName;
        this.finalPrice = finalPrice;
    }

    // -------------------- Getter & Setter --------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", discountType='" + discountType + '\'' +
                ", discountName='" + discountName + '\'' +
                ", finalPrice=" + finalPrice +
                '}';
    }
}