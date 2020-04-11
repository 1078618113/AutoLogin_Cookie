package cn.rzpt.filter;

import cn.rzpt.domain.User;
import cn.rzpt.service.UserService;
import cn.rzpt.service.impl.UserServiceImpl;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebFilter("/index.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        System.out.println("准备开始进行拦截");
        //获得cookie中的用户名和密码  进行登录操作
        String cookie_username = "";
        String cookie_password = "";
        //获得cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //获取名字是cookie_username和cookie_password
                if ("cookie_username".equals(cookie.getName())) {
                    cookie_username = cookie.getValue();

                    //解码cookie
                    cookie_username = URLDecoder.decode(cookie_username, "utf-8");
                }
                if ("cookie_password".equals(cookie.getName())) {
                    cookie_password = cookie.getValue();
                }
            }
        }
        //判断username和password是否为null
        if (!cookie_username.equals("") && !cookie_password.equals("")) {
            UserService userService = new UserServiceImpl();
            User user = null;
            try {
                user = userService.login(cookie_username, cookie_password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将登陆的用户放入session中
            session.setAttribute("user", user);
            response.sendRedirect("/autologin/success.jsp");
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
