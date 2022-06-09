package com.service.impl;

import com.dao.BookDAO;

import com.dao.BuildDAO;
import com.dto.*;
import com.service.BookService;


import java.sql.SQLException;
import java.util.*;

/**
 * @author shkstart
 * @create 2022-06-04 15:25
 */
public class BookServiceImpl implements BookService {
    BookDAO bookDAO=new BookDAO();
    BuildDAO buildDAO=new BuildDAO();

    @Override
    public void saveBook(BookDTO book) throws Exception {
        bookDAO.addBook(book);
    }

    @Override
    public void editBook(BookDTO book) throws Exception {
        bookDAO.updateBook(book);
    }

    @Override
    public void removeBook(Integer Id) throws Exception {
        bookDAO.deleteBook(Id);
    }

    public BookDTO getBookById(Integer id) throws Exception{
        return  bookDAO.getBookDTOById(id);

    }





    @Override
    public PageResult<BookDTO> findByPage(String _currentPage, String _rows, Map<String, String[]> condition) throws Exception{
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if(currentPage <=0) {
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageResult<BookDTO> pb = new PageResult<BookDTO>();

        //2.调用dao查询总记录数
        int totalCount = findTotalCount(condition);
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        if (currentPage>=totalPage){
            currentPage=totalPage;
        }
        pb.setTotalCount(totalCount);
        //3.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<BookDTO> list = findListBookByPage(start,rows,condition);
        //设置封装对象Book的书架名

        pb.setList(list);

        //4.计算总页码

        pb.setTotalPage(totalPage);
        if(currentPage>=totalPage){
            currentPage=totalPage;
        }
        //5.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }
    public int findTotalCount(Map<String, String[]> condition) throws Exception{
        Map<String, String> keyValueMap = new HashMap<>();
        //遍历map
        if (condition!=null){

            for (String key : condition.keySet()){
                //排除分页条件参数
                if("currentPage".equals(key) || "rows".equals(key) || "method".equals(key)){
                    continue;
                }
                String value=condition.get(key)[0];
                /*if ("build_name".equals(key)){
                    if (value !=null && !"".equals(value)) {
                        try {
                            BookBuildDTO bean = buildDAO.getBookBuildByName(value );
                            value = String.valueOf(bean.getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }*/

                if(value != null&& !"".equals(value)){
                    keyValueMap.put(key,value);
                }

            }
        }
        return bookDAO.findTotalCountByParam(keyValueMap);

    }


    public List<BookDTO> findListBookByPage(int start, int rows, Map<String, String[]> condition) throws Exception{
        Map<String, String> keyValueMap = new HashMap<>();
        //遍历map
        if (condition!=null){

            for (String key : condition.keySet()){
                //排除分页条件参数
                if("currentPage".equals(key) || "rows".equals(key) || "method".equals(key)){
                    continue;
                }
                String value=condition.get(key)[0];
                /*if ("build_name".equals(key)){
                    if (value !=null && !"".equals(value)) {
                        try {
                            BookBuildDTO bean = buildDAO.getBookBuildByName(value );
                            value = String.valueOf(bean.getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }*/

                if(value != null&& !"".equals(value)){
                    keyValueMap.put(key,value);
                }

            }
        }
        return bookDAO.pageListByParam(start,rows,keyValueMap);

    }

}
