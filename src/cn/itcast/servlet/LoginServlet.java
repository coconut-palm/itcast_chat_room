package cn.itcast.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String PASSWORD = "123456";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        //1.接受页面传递的参数 用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map resultMap = new HashMap();
        //2.判定用户名和密码是否正确

        //3.如果正确 响应登陆成功的信息
        if(PASSWORD.equals(password)) {
            resultMap.put("success",true);
            resultMap.put("message","登陆成功");

            req.getSession().setAttribute("username",username);

        }else { //4.如果失败 响应登陆失败的信息
            resultMap.put("success",false);
            resultMap.put("message","登陆失败");
        }
        //5.响应数据
        resp.getWriter().write(JSON.toJSONString(resultMap));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
