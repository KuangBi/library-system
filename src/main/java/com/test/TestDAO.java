package com.test;

import com.dto.BookDTO;
import org.junit.Test;
import com.dao.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-06-05 19:37
 */
public class TestDAO {
    @Test
    /**
     * 对分页查DAO的测试
     *
     */
    public void testBook(){
        Map map = new HashMap<>();

        map.put("type","神话");
        BookDAO bookDAO=new BookDAO();

        List<BookDTO> list = bookDAO.pageListByParam(0, 5, map);
        for (BookDTO bookDTO:list){
            System.out.println(bookDTO);
        }

    }
}
