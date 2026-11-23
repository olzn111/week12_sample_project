package edu.handong.week12.book.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookRequest {
    @NotBlank(message = "제목은 필수 입력값입니다.")
    private String title;

    @NotBlank(message = "저자는 필수 입력값입니다.")
    private String author;

    @Min(value = 0, message = "가격은 0원 이상이어야 합니다.")
    private int price;

    public BookRequest() {
    }

    public BookRequest(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}