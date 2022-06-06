package com.dto;

import java.util.Date;

/**
 * @author shkstart
 * @create 2022-05-31 20:45
 */
public class RecordDTO {
    private Integer id;
    private Integer bookId;
    private Integer uid;

    private Date createTime;
    private Date backTime;
    private Integer reState;

    public RecordDTO(Integer id, Integer bookId, Integer uid, Date createTime, Date backTime, Integer reState) {
        this.id = id;
        this.bookId = bookId;
        this.uid = uid;
        this.createTime = createTime;
        this.backTime = backTime;
        this.reState = reState;
    }

    public RecordDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public Integer getReState() {
        return reState;
    }

    public void setReState(Integer reState) {
        this.reState = reState;
    }

    @Override
    public String toString() {
        return "RecordDTO{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", uid=" + uid +
                ", createTime=" + createTime +
                ", backTime=" + backTime +
                ", reState=" + reState +
                '}';
    }
}
