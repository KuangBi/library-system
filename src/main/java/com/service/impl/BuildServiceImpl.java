package com.service.impl;

import com.dao.BuildDAO;
import com.dto.BookBuildDTO;
import com.service.BuildService;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-06-04 15:39
 */
public class BuildServiceImpl implements BuildService {
    BuildDAO buildDAO=new BuildDAO();
    @Override
    public void saveBuild(BookBuildDTO bookBuild) throws Exception {
        buildDAO.addBookBuild(bookBuild);
    }

    @Override
    public void editBuild(BookBuildDTO bookBuild) throws Exception {
        buildDAO.updateBookBuild(bookBuild);
    }

    @Override
    public void removeBuild(Integer Id) throws Exception {
        buildDAO.deleteBookBuild(Id);
    }

    @Override
    public List<BookBuildDTO> getBuildList() throws Exception {
        return buildDAO.getBookBuildList();
    }

    @Override
    public BookBuildDTO getBookBuildById(Integer id) throws Exception {
        return buildDAO.getBookBuildById(id);
    }
}
