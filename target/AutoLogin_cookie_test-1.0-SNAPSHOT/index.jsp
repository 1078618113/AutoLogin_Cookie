<%--
  Created by IntelliJ IDEA.
  User: Gjl10
  Date: 2020/4/11
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/LoginServlet" >
    <table>
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="text" name="password"></td>
      </tr>
      <tr>
        <td>自动登录</td>
        <td><input type="checkbox" name="autoLogin"></td>
      </tr>
      <tr>
        <td><input type="submit" value="提交"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
