package com.web.servlet; /**
 * @author shkstart
 * @create 2022-06-03 1:01
 */

import com.common.TypeEnum;
import com.dto.BookDTO;
import com.dto.PageResult;
import com.mysql.jdbc.StringUtils;
import com.web.vo.BookVO;
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
        currentPage = StringUtils.isNullOrEmpty(currentPage)?"1": currentPage;
        rows = StringUtils.isNullOrEmpty(rows)? "5": rows;

        //2.调用service查询并封装进vo
        Map<String, String[]> condition = request.getParameterMap();
        PageResult<BookDTO> pb = bookService.findByPage(currentPage,rows,condition);
        List<BookVO> bookVOList = new ArrayList<BookVO>();
        for (BookDTO bookDTO: pb.getList()){
            BookVO bookVO =new BookVO();
            bookVO.setId(bookDTO.getId());
            bookVO.setBookName(bookDTO.getBookName());
            bookVO.setAuthor(bookDTO.getAuthor());
            bookVO.setBuildId(bookDTO.getBuildId());
            bookVO.setIntroduce(bookDTO.getIntroduce());
            bookVO.setImgPath(bookDTO.getImgPath());
            bookVO.setTypeCode(bookDTO.getType());
            bookVO.setTypeName(TypeEnum.getDescByCode(bookDTO.getType()));
            bookVO.setBuildName(buildService.getBookBuildById(bookDTO.getBuildId()).getBuildName());
            bookVOList.add(bookVO);
        }

        //3.将PageBean存入request
        PageResult<BookVO> pageResult = new PageResult();
        pageResult.setList(bookVOList);
        request.setAttribute("pb",pageResult);
        request.setAttribute("condition",condition);//将查询条件存入request
        //4.转发到list.jsp,请求转发不需要虚拟目录
        request.getRequestDispatcher("/userList.jsp").forward(request,response);
    }


}
