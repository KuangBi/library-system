package com.test;

import com.dto.BookBuildDTO;
import com.dto.BookDTO;
import com.dto.PageResult;
import com.service.BookService;
import com.service.BuildService;
import com.service.impl.BookServiceImpl;
import com.service.impl.BuildServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-06-06 0:42
 */
public class TestSer {
    @Test
    public void testBook() throws Exception {
        Map<String,String[]> map=new HashMap();
        String[] strs=new String[]{"小王子"};
        map.put("book_name",strs);
        BookService bookService=new BookServiceImpl();
        PageResult<BookDTO> byPage = bookService.findByPage("1", "1", map);
        List<BookDTO> list = byPage.getList();
        for (BookDTO bookDTO:list){
            System.out.println(bookDTO);
        }
    }
    @Test
    public void testBook1() throws Exception {
        Map<String,String[]> map=new HashMap();
        String[] strs=new String[]{"小王子"};
        map.put("book_name",strs);
        BookService bookService=new BookServiceImpl();
        PageResult<BookDTO> byPage = bookService.findByPage("1", "1", map);
        System.out.println(byPage.getTotalPage());
        System.out.println(byPage.getTotalCount());
        List<BookDTO> list = byPage.getList();
        /*for (BookDTO bookDTO:list){
            System.out.println(bookDTO);
        }*/
    }
    @Test
    public void delBook1() throws Exception {
        BookService bookService=new BookServiceImpl();
        BuildService buildService=new BuildServiceImpl();
        BookDTO  bookDTO=new BookDTO();
        bookDTO.setBuildId(1);
        String s="3";
        String id=buildService.getBookBuildById(bookDTO.getBuildId()).getBuildName();
        System.out.println(id);
    }
    @Test
    public void delBuild1() throws Exception {
        BuildService buildService=new BuildServiceImpl();
        List<BookBuildDTO> buildList = buildService.getBuildList();
        for (BookBuildDTO bookBuildDTO:buildList){
            System.out.println("获取到的书架"+bookBuildDTO);
        }
    }
}
