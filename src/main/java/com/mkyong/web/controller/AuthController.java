package com.mkyong.web.controller;

import com.cisdi.enfi.pbs.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("authMng")
public class AuthController extends BaseController {

    @RequestMapping("init")
    public ModelAndView authMngInit(){
        ModelAndView mv=createLayoutView("auth/test.ftl");
        return mv;
    }
}
