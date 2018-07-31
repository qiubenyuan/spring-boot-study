package com.github.example.controller;

import com.github.example.utils.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Arvin
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("redirect.do")
    public ModelAndView redirect(String url) throws IOException {

        ModelAndView view = new ModelAndView("redirect:" + url);

        view.addObject("name", "http://udblogin.duowan.com/login.do?game=SYOL&server=s45&pid=&report_ver=new&ref=yygHome/ZJ/YX1/JRYX&ref_desc=%E6%B8%B8%E6%88%8F%E5%A4%A7%E5%8E%85%E9%A6%96%E9%A1%B5%2F%E6%9C%80%E8%BF%91%E7%99%BB%E5%BD%95%2F%E6%B8%B8%E6%88%8F1%2F%E8%BF%9B%E6%B8%B8%E6%88%8F&webyygame&showtools=0&pro=webyygame&rso=from_explorer&rso_desc=%E6%B5%8F%E8%A7%88%E5%99%A8%E5%A4%A7%E5%8E%85&from=explorerhttp://udblogin.duowan.com/login.do?game=SYOL&server=s45&pid=&report_ver=new&ref=yygHome/ZJ/YX1/JRYX&ref_desc=%E6%B8%B8%E6%88%8F%E5%A4%A7%E5%8E%85%E9%A6%96%E9%A1%B5%2F%E6%9C%80%E8%BF%91%E7%99%BB%E5%BD%95%2F%E6%B8%B8%E6%88%8F1%2F%E8%BF%9B%E6%B8%B8%E6%88%8F&webyygame&showtools=0&pro=webyygame&rso=from_explorer&rso_desc=%E6%B5%8F%E8%A7%88%E5%99%A8%E5%A4%A7%E5%8E%85&from=explorerhttp://udblogin.duowan.com/login.do?game=SYOL&server=s45&pid=&report_ver=new&ref=yygHome/ZJ/YX1/JRYX&ref_desc=%E6%B8%B8%E6%88%8F%E5%A4%A7%E5%8E%85%E9%A6%96%E9%A1%B5%2F%E6%9C%80%E8%BF%91%E7%99%BB%E5%BD%95%2F%E6%B8%B8%E6%88%8F1%2F%E8%BF%9B%E6%B8%B8%E6%88%8F&webyygame&showtools=0&pro=webyygame&rso=from_explorer&rso_desc=%E6%B5%8F%E8%A7%88%E5%99%A8%E5%A4%A7%E5%8E%85&from=explorer");

        return view;
    }

    @RequestMapping("redirect2.do")
    public void redirect(HttpServletResponse response, String url) throws IOException {

        String name = "http://udblogin.duowan.com/login.do?game=SYOL&server=s45&pid=&report_ver=new&ref=yygHome/ZJ/YX1/JRYX&ref_desc=%E6%B8%B8%E6%88%8F%E5%A4%A7%E5%8E%85%E9%A6%96%E9%A1%B5%2F%E6%9C%80%E8%BF%91%E7%99%BB%E5%BD%95%2F%E6%B8%B8%E6%88%8F1%2F%E8%BF%9B%E6%B8%B8%E6%88%8F&webyygame&showtools=0&pro=webyygame&rso=from_explorer&rso_desc=%E6%B5%8F%E8%A7%88%E5%99%A8%E5%A4%A7%E5%8E%85&from=explorerhttp://udblogin.duowan.com/login.do?game=SYOL&server=s45&pid=&report_ver=new&ref=yygHome/ZJ/YX1/JRYX&ref_desc=%E6%B8%B8%E6%88%8F%E5%A4%A7%E5%8E%85%E9%A6%96%E9%A1%B5%2F%E6%9C%80%E8%BF%91%E7%99%BB%E5%BD%95%2F%E6%B8%B8%E6%88%8F1%2F%E8%BF%9B%E6%B8%B8%E6%88%8F&webyygame&showtools=0&pro=webyygame&rso=from_explorer&rso_desc=%E6%B5%8F%E8%A7%88%E5%99%A8%E5%A4%A7%E5%8E%85&from=explorerhttp://udblogin.duowan.com/login.do?game=SYOL&server=s45&pid=&report_ver=new&ref=yygHome/ZJ/YX1/JRYX&ref_desc=%E6%B8%B8%E6%88%8F%E5%A4%A7%E5%8E%85%E9%A6%96%E9%A1%B5%2F%E6%9C%80%E8%BF%91%E7%99%BB%E5%BD%95%2F%E6%B8%B8%E6%88%8F1%2F%E8%BF%9B%E6%B8%B8%E6%88%8F&webyygame&showtools=0&pro=webyygame&rso=from_explorer&rso_desc=%E6%B5%8F%E8%A7%88%E5%99%A8%E5%A4%A7%E5%8E%85&from=explorer";
        response.sendRedirect(url + "?name=" + URLEncoder.encode(name, "UTF-8"));

    }

    @RequestMapping("/wck.do")
    public void wck(String name, String value, Boolean httpOnly, Boolean p3p, HttpServletRequest request, HttpServletResponse response) throws IOException {

        CookieUtil.addCookie(name, value, CookieUtil.MAX_AGE_FOREVER,
                null != httpOnly && httpOnly,
                p3p != null && p3p,
                request,
                response);
        response.getWriter().write("OK");
    }
}
