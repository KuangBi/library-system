package com.test;

import com.dto.BookDTO;
import com.dto.PageResult;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
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
}
