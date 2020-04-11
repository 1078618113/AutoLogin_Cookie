package cn.rzpt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.清空cookie中的值
        Cookie cookie_username = new Cookie("cookie_username","");
        Cookie cookie_password = new Cookie("cookie_password","");
        cookie_username.setMaxAge(0);
        cookie_password.setMaxAge(0);
        cookie_username.setPath(request.getContextPath());
        cookie_password.setPath(request.getContextPath());
        response.addCookie(cookie_username);
        response.addCookie(cookie_password);
        HttpSession session = request.getSession();

        //2.清空session中存储的账号密码
        session.setAttribute("user",null);

        response.sendRedirect(request.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
