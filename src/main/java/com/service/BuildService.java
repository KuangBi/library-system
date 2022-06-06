package com.service;

import com.dto.BookBuildDTO;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-06-04 15:38
 */
public interface BuildService {
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

    BookBuildDTO getBuild(Integer id) throws Exception;
}
