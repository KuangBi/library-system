package com.service.impl;

import com.dao.RecordDAO;
import com.dto.RecordDTO;
import com.service.RecordService;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-06-04 15:41
 */
public class RecordServiceImpl implements RecordService {
    RecordDAO recordDAO=new RecordDAO();
    @Override
    public void saveRecord(RecordDTO record) throws Exception {
        recordDAO.addRecord(record);
    }

    @Override
    public void editRecord(RecordDTO record) throws Exception {
        recordDAO.updateRecord(record);
    }

    @Override
    public void removeRecord(Integer Id) throws Exception {
        recordDAO.deleteRecord(Id);
    }

    @Override
    public  List<RecordDTO> getRecordList() throws Exception {
        return recordDAO.getRecordDTOList();
    }
}
