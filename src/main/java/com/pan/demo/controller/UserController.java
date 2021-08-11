package com.pan.demo.controller;

import com.pan.demo.service.UserService;
import com.pan.demo.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author EVA
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String defaultPath(HttpServletRequest request, HttpSession session) {
        return "forward:/page/homepage.html";
    }

    @GetMapping("/login")
    public String login() {
        return "forward:/page/login.html";
    }

    @RequestMapping("/register")
    public String register(HttpSession session, String name, String password, HttpServletResponse response) throws IOException {
        return "forward:/page/register.html";
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(String inputInfo, String password, boolean rem, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String userId = userService.login(inputInfo, password);
        if (userId != null) {
            session.setAttribute("userId", userId);
            if (rem) {
                Cookie cookie1 = new Cookie("userIdOrName", inputInfo);
                Cookie cookie2 = new Cookie("password", password);
                cookie1.setMaxAge(30 * 24 * 60 * 60);
                cookie1.setPath(request.getContextPath());
                response.addCookie(cookie1);
                cookie2.setMaxAge(30 * 24 * 60 * 60);
                cookie2.setPath(request.getContextPath());
                response.addCookie(cookie2);
            }
            return "true";
        }
        return "false";
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView();

        session.setAttribute("userId", null);
        Cookie cookie1 = new Cookie("userId", "");
        Cookie cookie2 = new Cookie("password", "");
        cookie1.setMaxAge(0);
        cookie1.setPath(request.getContextPath());
        response.addCookie(cookie1);
        cookie2.setMaxAge(0);
        cookie2.setPath(request.getContextPath());
        response.addCookie(cookie2);

        return this.homePage(session, mv);
    }

    @RequestMapping("/registerEnsure")
    @ResponseBody
    public String registerEnsure(HttpSession session, String name, String password,String email, HttpServletResponse response) throws IOException {
        if (name == null || password == null) {
            response.sendRedirect("error.html");
            return "error";
        }
        String userId = userService.register(name, password,email);
        session.setAttribute("userId", userId);
        return "true";
    }


    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int width = 240;
        int height = 60;
        BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        String randomVerifyCode = VerifyCode.drawRandomText(width, height, verifyImg);
        req.getSession().setAttribute("verifyCode", randomVerifyCode);
        resp.setContentType("image/png");

        try (OutputStream os = resp.getOutputStream()) {
            ImageIO.write(verifyImg, "png", os);
            os.flush();
        }
    }

    @RequestMapping("/codeCheck")
    @ResponseBody
    public String checkVerifyCode(HttpSession session, String code) {
        String verifyCode = ((String) session.getAttribute("verifyCode")).toLowerCase();
        String inputCode = code.toLowerCase();
        if (verifyCode.equals(inputCode)) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/userNameCheck")
    @ResponseBody
    public String checkUserName(String userName) {
        String userId = userService.getUserIdByName(userName);
        if (userId == null) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/emailCheck")
    @ResponseBody
    public String checkEmail(String email) {
        String userId = userService.getUserIdByEmail(email);
        if (userId == null) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/getLoginInfo")
    @ResponseBody
    public String getLoginInfo(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        boolean isLogin = userId!=null;
        String userName = null;
        if (isLogin){
            userName =userService.getUserName(userId);
        }


       /* if (userId == null) {
            return "-1#0#0";
        } else {
            String userName = userService.getUserName(userId);
            if (userName == null) {
                return "0#0#0";
            } else {
                return "1#" + userId + "#" + userName;
            }
        }*/

        return "{\"isLogin\":"+isLogin+",\"userName\":\""+userName+"\"}";
    }

    @RequestMapping("/u")
    public ModelAndView homePage(HttpSession session, ModelAndView mv) {
        String userId = (String) session.getAttribute("userId");

        mv.addObject("pageOwnerId", userId);
        mv.addObject("pageOwnerName", "name");
        mv.setViewName("homePage");

        return mv;
    }
}
