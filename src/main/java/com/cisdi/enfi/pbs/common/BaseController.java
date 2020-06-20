package com.cisdi.enfi.pbs.common;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {
    protected ModelAndView createLayoutView(String path) {
        return createLayoutView(path, null);
    }

    protected ModelAndView createLayoutView(String path, String layout) {
        ModelAndView view = new ModelAndView();
        if (layout == null) {
            view.setViewName("common/layout");
            view.addObject("header_path", "common/header.ftl");
            view.addObject("left_path", "common/left.ftl");
            view.addObject("footer_path", "common/footer.ftl");
        } else {
            view.setViewName(layout);
            view.addObject("header_path", "common/header.ftl");
            view.addObject("left_path", "common/left.ftl");
            view.addObject("footer_path", "common/footer.ftl");
        }
        view.addObject("content_path", path);
        return view;
    }
}
