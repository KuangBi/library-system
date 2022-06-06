package com.dao;

import com.dto.BookBuildDTO;
import com.dao.BaseDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-06-01 7:31
 */
public class BuildDAO extends BaseDAO<BookBuildDTO>  {

    public void addBookBuild(BookBuildDTO bookBuild) throws SQLException {
        String sql="insert into book_build(build_name) values(?)";
        update(sql,bookBuild.getBuildName());
    }


    public void updateBookBuild(BookBuildDTO bookBuild) throws SQLException {
        String sql="update book_build set build_name=? where id=?";
        update(sql,bookBuild.getBuildName(),bookBuild.getId());
    }


    public void deleteBookBuild(Integer Id) throws SQLException {
        String sql="delete from book_build where id=?";
        update(sql,Id);
    }


    public List<BookBuildDTO> getBookBuildList() throws SQLException {
        String sql="select id,build_name buildName from book_build";
        return getBeanList(BookBuildDTO.class,sql);
    }


    public BookBuildDTO getBookBuildById(Integer id) throws SQLException {
        String sql="select id,build_name buildName from book_build where id=?";
        return getBean(BookBuildDTO.class,sql,id);
    }

    public BookBuildDTO getBookBuildByName(String build_name) throws SQLException {
        String sql="select id,build_name buildName from book_build where id=?";
        return getBean(BookBuildDTO.class,sql,build_name);
    }
}
