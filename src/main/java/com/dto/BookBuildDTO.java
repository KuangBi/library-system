package com.dto;

/**
 * @author shkstart
 * @create 2022-05-31 20:42
 */
public class BookBuildDTO {
    private Integer id;
    private String buildName;

    public BookBuildDTO(Integer id, String buildName) {
        this.id = id;
        this.buildName = buildName;
    }

    public BookBuildDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    @Override
    public String toString() {
        return "BookBuild{" +
                "id=" + id +
                ", buildName='" + buildName + '\'' +
                '}';
    }
}
