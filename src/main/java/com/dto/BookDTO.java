package com.dto;

/**
 * @author shkstart
 * @create 2022-05-31 20:38
 */
public class BookDTO {
    //外键id
    private Integer id;
    private String bookName;
    private String author;
    private Integer buildId;
    private String type;
    private String introduce;
    private String imgPath;

    public BookDTO(Integer id, String bookName, String author, Integer buildId, String type, String introduce, String imgPath) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.buildId = buildId;
        this.type = type;
        this.introduce = introduce;
        this.imgPath = imgPath;
    }

    public BookDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", buildId=" + buildId +
                ", type='" + type + '\'' +
                ", introduce='" + introduce + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
