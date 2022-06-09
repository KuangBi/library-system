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
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

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
            //out.println(bookDTO);
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
        pageResult.setCurrentPage(pb.getCurrentPage());
        pageResult.setRows(pb.getRows());
        pageResult.setTotalPage(pb.getTotalPage());
        pageResult.setTotalCount(pb.getTotalCount());

        request.setAttribute("pb",pageResult);
        request.setAttribute("condition",condition);//将查询条件存入request
        //4.转发到list.jsp,请求转发不需要虚拟目录
        HttpSession session = request.getSession();

        if (Integer.valueOf(1).equals((Integer) session.getAttribute("state"))){

            request.getRequestDispatcher("/manBookList.jsp").forward(request,response);
            return;

        }
        request.getRequestDispatcher("/userBookList.jsp").forward(request,response);
    }
    public void delBook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("id");
        out.println(id);
        bookService.removeBook(Integer.parseInt(id));
       response.sendRedirect(request.getContextPath()+"/book?method=getBookList");


    }
    public void toUpdateBook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("id");
        //bookService.editBook();
        BookDTO book = bookService.getBookById(Integer.valueOf(id));
        request.setAttribute("book",book);
        request.getRequestDispatcher("/bookUpdate.jsp").forward(request,response);


    }
    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, String[]> map = request.getParameterMap();
        BookDTO book=new BookDTO();
        BeanUtils.populate(book,map);
        bookService.editBook(book);
        response.sendRedirect(request.getContextPath()+"/book?method=getBookList");


    }
    public void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, String[]> map = request.getParameterMap();
        BookDTO book=new BookDTO();
        BeanUtils.populate(book,map);
        bookService.saveBook(book);
        //PrintWriter out = response.getWriter();
        //out.println("<script>alert('添加书籍成功');location.href='book?method=getBookList';</script>");
        //request.getRequestDispatcher("/book?method=getBookList").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/book?method=getBookList");
    }

}
