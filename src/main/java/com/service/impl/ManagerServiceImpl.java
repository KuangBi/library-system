/*package com.service.impl;

import com.dao.RecordDAO;
import com.dao.BookDAO;
import com.dao.impl.BuildDAO;
import com.dao.impl.UserDAO;
import com.dto.*;
import com.dto.RecordDTO;
import com.service.ManagerService;

import java.util.List;
import java.util.Map;

*//**
 * @author shkstart
 * @create 2022-06-01 13:14
 *//*
public class ManagerServiceImpl implements ManagerService {
    BookDAO bookDao=new BookDAO();
    BuildDAO buildDao=new BuildDAO();
    BookTypeDAO bookTypeDao=new BookTypeDAO();
    RecordDAO recordDao=new RecordDAO();
    UserDAO userDao=new UserDAO();
    PageDAO pageDao=new PageDAO();

    @Override
    public void saveBook(BookDTO book) throws Exception {
            bookDao.addBook(book);
    }

    @Override
    public void editBook(BookDTO book) throws Exception {
            bookDao.updateBook(book);
    }

    @Override
    public void removeBook(Integer Id) throws Exception {
            bookDao.deleteBook(Id);
    }

    @Override
    public List<BookDTO> getBookList() throws Exception {
        return bookDao.getBookDTOList();
    }

    @Override
    public BookDTO getBookByBuildId(String buildId) throws Exception {
        BookBuildDTO bean = buildDao.getBookBuild(buildId);
        BookDTO book = bookDao.getBeanByBuild(bean.getId());
        return book;
    }

    @Override
    public BookDTO getBookByBookName(String bookName) throws Exception {
        return bookDao.getBeanByName(bookName);
    }

    @Override
    public BookDTO getBookByType(String type) throws Exception {
        BookType bean = bookTypeDao.getBean(type);
        return bookDao.getBeanByTypeId(bean.getId());
    }

    @Override
    public void saveBuild(BookBuildDTO bookBuild) throws Exception {
        buildDao.addBookBuild(bookBuild);
    }

    @Override
    public void editBuild(BookBuildDTO bookBuild) throws Exception {
        buildDao.updateBookBuild(bookBuild);
    }

    @Override
    public void removeBuild(Integer Id) throws Exception {
        buildDao.deleteBookBuild(Id);
    }

    @Override
    public List<BookBuildDTO> getBuildList() throws Exception {
        return buildDao.getListBean();
    }

    @Override
    public void saveRecord(RecordDTO record) throws Exception {
        recordDao.addRecord(record);
    }

    @Override
    public void editRecord(RecordDTO record) throws Exception {
        recordDao.updateRecord(record);
    }

    @Override
    public void removeRecord(Integer Id) throws Exception {
        recordDao.deleteRecord(Id);
    }

    @Override
    public  List<RecordDTO> getRecordList() throws Exception {
        return recordDao.getListBean();
    }

    @Override
    public void editManager(UserDTO user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public PageResult<BookDTO> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if(currentPage <=0) {
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageResult<BookDTO> pb = new PageResult<BookDTO>();

        //2.调用dao查询总记录数
        int totalCount = pageDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //3.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<BookDTO> list = pageDao.findByPage(start,rows,condition);
        pb.setList(list);

        //4.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        if(currentPage>=totalPage){
            currentPage=totalPage;
        }
        //5.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }
}*/
