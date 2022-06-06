package com.web.servlet; /**
 * @author shkstart
 * @create 2022-06-03 1:01
 */

import com.dto.BookDTO;
import com.dto.PageResult;
import com.dvo.BookVo;
import com.service.BookService;
import com.service.BuildService;
import com.service.impl.BookServiceImpl;
import com.service.impl.BuildServiceImpl;
import com.web.servlet.base.ModelBaseServlet;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookServlet extends ModelBaseServlet {
    BookService bookService=new BookServiceImpl();
    BuildService buildService=new BuildServiceImpl();
    /**
     * 获取书列表
     * @param request
     * @param response
     * @throws Exception
     */
    public void getBookList(HttpServletRequest request, HttpServletResponse response) throws Exception{


        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }


        if(rows == null || "".equals(rows)){
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();


        //2.调用service查询并封装进vo

        PageResult<BookDTO> pb = bookService.findByPage(currentPage,rows,condition);
        List<BookDTO> list = pb.getList();
        BookVo bookVo=new BookVo();
        List<BookVo> changeList=new ArrayList<BookVo>();
        for (BookDTO bookDTO:list){
            bookVo.setId(bookDTO.getId());
            bookVo.setBookName(bookDTO.getBookName());
            bookVo.setAuthor(bookDTO.getAuthor());
            bookVo.setBuildId(bookDTO.getBuildId());
            bookVo.setIntroduce(bookDTO.getIntroduce());
            bookVo.setImgPath(bookDTO.getImgPath());
            if ("1".equals(bookDTO.getType())){
                bookVo.setType("自然");
            }else if ("2".equals(bookDTO.getType())){
                bookVo.setType("人文科学");
            }else if ("3".equals(bookDTO.getType())){
                bookVo.setType("历史");
            }
            bookVo.setBookName(buildService.getBuild(bookDTO.getBuildId()).getBuildName());
            changeList.add(bookVo);

        }

        pb.setList(changeList);



        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//将查询条件存入request
        //4.转发到list.jsp,请求转发不需要虚拟目录
        request.getRequestDispatcher("/userList.jsp").forward(request,response);
    }


}
