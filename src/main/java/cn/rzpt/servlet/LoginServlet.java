package cn.rzpt.servlet;

import cn.rzpt.domain.User;
import cn.rzpt.service.UserService;
import cn.rzpt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String autoLogin = request.getParameter("autoLogin");

        System.out.println(username + "---" + password + "---" + autoLogin);

        UserService userService = new UserServiceImpl();
        User user;

        user = userService.login(username, password);
        System.out.println(user);

        if (user != null) {
            //自动登录按钮 不为空
            if (autoLogin != null) {
                System.out.println("密码对了×××××××进行cookie操作");

                //首先对中文用户名进行编码操作(cookie不能存储中文)
                String username_code = URLEncoder.encode(username, "utf-8");

                Cookie cookie_username = new Cookie("cookie_username", username_code);
                Cookie cookie_password = new Cookie("cookie_password", password);

                //设置cookie的持久化时间
                cookie_password.setMaxAge(60*2);//单位 秒  2分钟存储
                cookie_password.setMaxAge(60*2);

                //设置cookie的携带路径
                //设置为当前项目下的路径都携带这个cookie
                cookie_username.setPath(request.getContextPath());
                cookie_password.setPath(request.getContextPath());

                //发送cookie
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);
            }
            System.out.println("密码对了×××××××但是不保存用户");

            //将登陆的对象存入session中
            request.setAttribute("user", user);//使每个页面都可以获取user对象的信息
            response.sendRedirect("/autologin/success.jsp");
        } else {
            System.out.println("密码错误！！！！！！！！");
            request.setAttribute("loginInfo", "用户名或密码错误");
            request.getRequestDispatcher("/autologin/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
