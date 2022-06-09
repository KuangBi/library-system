package com.web.servlet;

import com.common.TypeEnum;
import com.dto.BookBuildDTO;
import com.dto.BookDTO;
import com.service.BuildService;
import com.service.impl.BuildServiceImpl;
import com.web.servlet.base.ModelBaseServlet;
import com.web.vo.BookVO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * @author shkstart
 * @create 2022-06-09 21:02
 */
public class BuildServlet extends ModelBaseServlet {
    BuildService buildService=new BuildServiceImpl();

    /**
     * 显示书架列表
     */
    public void getBuildList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<BookBuildDTO> buildList = buildService.getBuildList();
        request.setAttribute("buildList",buildList);
        for (BookBuildDTO bookBuildDTO:buildList){
            System.out.println("1获取到的书架"+bookBuildDTO);
        }
        request.getRequestDispatcher("/buildList.jsp").forward(request,response);
    }
    /**
     * 修改书架过渡
     */
    public void toUpdateBuild(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("id");
        //bookService.editBook();
        BookBuildDTO build = buildService.getBookBuildById(Integer.valueOf(id));
        request.setAttribute("build",build);
        request.getRequestDispatcher("/buildUpdate.jsp").forward(request,response);
    }
    public void updateBuild(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, String[]> map = request.getParameterMap();
        BookBuildDTO build=new BookBuildDTO();
        BeanUtils.populate(build,map);
        buildService.editBuild(build);
        response.sendRedirect(request.getContextPath()+"/build?method=getBuildList");
    }
    public void addBuild(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, String[]> map = request.getParameterMap();
        BookBuildDTO build=new BookBuildDTO();
        BeanUtils.populate(build,map);
        out.println("添加书架"+build);
        buildService.saveBuild(build);
        //PrintWriter out = response.getWriter();
        //out.println("<script>alert('添加书籍成功');location.href='book?method=getBookList';</script>");
        //request.getRequestDispatcher("/book?method=getBookList").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/build?method=getBuildList");
    }
    public void delBuild(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("id");
        //out.println(id);
        buildService.removeBuild(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath()+"/build?method=getBuildList");

    }
}
