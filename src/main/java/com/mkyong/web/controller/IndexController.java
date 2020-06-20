package com.mkyong.web.controller;

import com.cisdi.enfi.pbs.common.BaseController;
import com.cisdi.enfi.pbs.common.ContextPropHolder;
import com.cisdi.enfi.pbs.common.contant.Const;
import com.cisdi.enfi.pbs.common.data.SessionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

public class IndexController extends BaseController {

    static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("")
    public String index() {
        return "redirect:/loginPage";
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView view = new ModelAndView();
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        ModelAndView view = new ModelAndView();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
//        view.setViewName("redirect:/authMng/init");
//        return view;

        logger.info(ContextPropHolder.getContextProperty("sys_userName"));
        logger.info(ContextPropHolder.getContextProperty("sys_password"));
        if (ContextPropHolder.getContextProperty("sys_userName").equals(userName)&&
                ContextPropHolder.getContextProperty("sys_password").equals(password)) {
            view.setViewName("redirect:/authMng/init");
            request.getSession().setAttribute(Const.USER_NAME,userName);
            request.getSession().setAttribute(Const.USER_ID,password);
            SessionInfo.set(Const.USER_ID, password);
            SessionInfo.set(Const.USER_NAME, userName);
            return view;
        }else {
            view.setViewName("redirect:/loginPage");
            return view;
        }
    }

}
