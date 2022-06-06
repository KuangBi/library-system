package com.service;

import com.dto.RecordDTO;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-06-04 15:28
 */
public interface RecordService {
    /**
     * 添加借阅信息
     */
    void saveRecord(RecordDTO record) throws Exception;
    /**
     * 修改借阅信息
     */
    void editRecord(RecordDTO record) throws Exception;
    /**
     * 删除借阅
     */
    void removeRecord(Integer Id) throws Exception;
    /**
     * 查询借阅信息
     */
    List<RecordDTO> getRecordList() throws Exception;
}
