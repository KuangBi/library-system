package com.service;

import com.dto.BookBuildDTO;
import com.dto.BookDTO;
import com.dto.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-06-04 15:22
 */
public interface BookService {
    /**
     * 根据前端返回的参数查找
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    PageResult<BookDTO> findByPage(String _currentPage, String _rows, Map<String, String[]> condition) throws Exception;
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


    BookDTO getBookById(Integer id) throws Exception;

}
