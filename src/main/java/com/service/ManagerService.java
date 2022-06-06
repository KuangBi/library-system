package com.service;

import com.dto.*;
import com.dto.RecordDTO;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-06-01 12:51
 */
public interface ManagerService {
    /**
     * 添加书
     *
     */
    void saveBook(BookDTO book) throws Exception;
    /**
     * 修改书
     */
    void editBook(BookDTO book) throws Exception;
    /**
     * 删除书
     */
    void removeBook(Integer Id) throws Exception;
    /**
     * 查询书列表
     */
    List<BookDTO> getBookList() throws Exception;
    /**
     * 书架号查询书
     */
    BookDTO getBookByBuildId(String buildId) throws Exception;
    /**
     * 书名查询
     */
    BookDTO getBookByBookName(String bookName) throws Exception;
    /**
     * 类别查询
     */
    BookDTO getBookByType(String type) throws Exception;
    /**
     * 添加书架号
     */
    void saveBuild(BookBuildDTO bookBuild) throws Exception;
    /**
     * 修改书架号
     */
    void editBuild(BookBuildDTO bookBuild) throws Exception;
    /**
     * 删除书架号
     */
    void removeBuild(Integer Id) throws Exception;
    /**
     * 查询书架列表
     */
    List<BookBuildDTO> getBuildList() throws Exception;
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
    /**
     * 修改管理员密码
     */
    void editManager(UserDTO user) throws Exception;
    /**
     * 分页查询
     */
    PageResult<BookDTO> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
