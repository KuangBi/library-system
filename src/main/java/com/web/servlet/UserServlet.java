package com.web.servlet; /**
 * @author shkstart
 * @create 2022-06-03 1:02
 */

import com.dto.UserDTO;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.web.servlet.base.ModelBaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UserServlet extends ModelBaseServlet {
    UserService userService=new UserServiceImpl();
    /**
     * 登录方法,定义为public怕反射不到，统一格式才能反射到
     */
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取数据
        String verifycode=request.getParameter("verifycode");
        //校验验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保代码一次性

        //String自己的方法，只能传参String型 equalsIgnoreCase作用一般是用来比较字母的长度和字符是否相同，切不区分大小写
        if (!checkcode_server.equalsIgnoreCase(verifycode)){
            request.setAttribute("log_msg","验证码错误");
            //getRequestDispatcher()包含两个重要方法，分别是请求转发和请求包含。一个请求跨多个Servlet时，需要使用请求转发和请求包含
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        Map<String,String[]> map=request.getParameterMap();
        //封装对象
        //beanUtils.populate( Object bean, Map properties )。这个方法会遍历map<key,value>中的key,如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。
        UserDTO user=new UserDTO();
        try {
            BeanUtils.populate(user,map);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service查询
        System.out.println(user);
        UserDTO loginUser = userService.getUser(user.getUid());
        if(loginUser != null){
            session.setAttribute("user",loginUser);
            if (Integer.valueOf(1234).equals((Integer) loginUser.getUid()) && "1234".equals(loginUser.getPassword())){
                session.setAttribute("state",1);
                System.out.println("管理员"+session.getAttribute("state"));

            }
            //${pageContext.request.contextPath}是JSP取得绝对路径的方法，等价于<%=request.getContextPath()%>
            response.sendRedirect(request.getContextPath()+"/book?method=getBookList");
        }else {
            request.setAttribute("log_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
    /**
     * 注册方法
     */
    public void doRegist(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, String[]> map = request.getParameterMap();
        UserDTO user=new UserDTO();
        BeanUtils.populate(user,map);
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
    /**
     * 退出登录
     */
    public void doQuit(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

}
