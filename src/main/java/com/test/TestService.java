/*
package com.test;

import com.dto.BookDTO;
import com.dto.BookBuildDTO;
import com.dto.PageResult;
import com.dto.RecordDTO;
import com.service.ManagerService;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * @author shkstart
 * @create 2022-06-01 13:47
 *//*

public class TestService {
    */
/*ManagerService managerService=new ManagerServiceImpl();*//*

    //------------------------------对书的操作
    @Test
    public void addBook() throws Exception {
        managerService.saveBook(new BookDTO(1,"0000王子","老八",1,1,"111","无"));
    }
    @Test
    public void updateBook() throws Exception {
        managerService.editBook(new BookDTO(1,"1111110000王子","老八",1,1,"111","无"));
    }
    @Test
    public void deleteBook() throws Exception {
        managerService.removeBook(1);
    }
    //------------------对书架的操作
    @Test
    public void addBuild() throws Exception {
        managerService.saveBuild(new BookBuildDTO(1,"贵妇堂"));
    }
    @Test
    public void updateBuild() throws Exception {
        managerService.editBuild(new BookBuildDTO(2,"q妇堂"));
    }
    @Test
    public void deteleBuild() throws Exception {
        managerService.removeBuild(2);
    }
    //-----------------对记录的操作
    @Test
    public void addRecord() throws Exception {
        managerService.saveRecord(new RecordDTO(null,1,1,"1111王子","2016-01-04 21:09:23","2016-01-04 21:09:23",0));
    }
    //---------------------模糊查询
    @Test
    public void getBookByother() throws Exception {
        BookDTO book = managerService.getBookByBuildId("贵妇堂");
        System.out.println(book);
    }
    @Test
    public void getBookByother2() throws Exception {
        BookDTO book = managerService.getBookByType("文学");
        System.out.println(book);
    }
    //-------------分页查
    @Test
    public void getBookListByPage() throws Exception {
        ManagerService managerService=new ManagerServiceImpl();
        Map map = new HashMap();
        String[] set=new String[]{"00王子"};

        map.put("book_name",set);


        PageResult userByPage = managerService.findUserByPage("1", "2", map);
        System.out.println(userByPage);
    }
}
*/
