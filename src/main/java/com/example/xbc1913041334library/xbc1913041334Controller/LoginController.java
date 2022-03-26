package com.example.xbc1913041334library.xbc1913041334Controller;

import com.example.xbc1913041334library.xbc1913041334Pojo.User;
import com.example.xbc1913041334library.xbc1913041334Service.IUserService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/admin")
class LoginController {
    @Autowired
    private IUserService iuserService;

    @GetMapping("login")
    public String loginPage(){
        return "file/login";
    }

    @PostMapping("/login")

    public String main(
            HttpServletRequest request,
            HttpSession session,
            Model model) {


        String userName=request.getParameter("username");
        String passWord=request.getParameter("password");
        System.out.println(userName+ "    "+ passWord);
        User user=iuserService.selectUserByUserName(userName);
        System.out.println(user.getUserName()+ "    "+ user.getPassWord() );
        if (user!=null && passWord.equals(user.getPassWord())) {
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/library/table";
        } else {
            model.addAttribute("msg", "账号密码错误");
            //回到登录页面
            return "/file/login";
        }
    }

    @GetMapping("/table.jsp")
    public String mainPage(HttpSession session,Model model) {

        log.info("当前方法是：{}", "mainPage");
        //是否登录。  拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "library/table";
        } else {
            //回到登录页面
            model.addAttribute("msg", "请重新登录");
            return "/file/login";
        }

    }
}
