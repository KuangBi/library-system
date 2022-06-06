package com.dao;

import com.dto.RecordDTO;
import com.dao.BaseDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-06-01 7:31
 */
public class RecordDAO extends BaseDAO<RecordDTO> {

    public void addRecord(RecordDTO record) throws SQLException {
        String sql="insert into record(book_id  ,u_id ,create_time  ,back_time ,re_state  ) values(?,?,?,?,?,?)";
        update(sql,record.getBookId(),record.getUid(),record.getCreateTime(),record.getBackTime(),record.getReState());
    }


    public void updateRecord(RecordDTO record) throws SQLException {
        String sql="update record set book_id=?,u_id=?,create_time=?,back_time=?,re_state=? where id=?";
        update(sql,record.getBookId(),record.getUid(),record.getCreateTime(),record.getBackTime(),record.getReState(),record.getId());
    }


    public void deleteRecord(Integer Id) throws SQLException {
        String sql="delete from record where id=?";
        update(sql,Id);
    }


    public List<RecordDTO> getRecordDTOList() throws SQLException {
        String sql="select id, book_id bookId ,u_id uId,create_time createTime ,back_time backTime,re_state reState from record";
        return getBeanList(RecordDTO.class,sql);
    }


    public RecordDTO getRecordDTOById(Integer Id) throws SQLException {
        String sql="select id, book_id bookId ,u_id uId,create_time createTime ,back_time backTime,re_state reState from record where id=?";
        return getBean(RecordDTO.class,sql);
    }
}
