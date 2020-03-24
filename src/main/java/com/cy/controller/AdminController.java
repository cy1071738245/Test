package com.cy.controller;

import com.cy.constant.Number;
import com.cy.service.PoetryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class AdminController extends BaseController {

    @Resource
    private PoetryService poetryService;

    @GetMapping("adminPoetryList")
    public ModelAndView poetryList(@RequestParam("page") int page) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> result = poetryService.getPoetryList(page, Number.size);
        mav.addObject("poetryResultMap", result);
        mav.setViewName("admin-poetry-list");
        return mav;
    }

    @PostMapping("addPoetry")
    public ModelAndView addPoetry(@RequestParam("poetryName") String poetryName,
                          @RequestParam("authorId") int authorId,
                          @RequestParam("content") String content,
                          @RequestParam(value = "imageUrl", required = false) String imageUrl) {
        ModelAndView mav = new ModelAndView();
        poetryService.addPoetry(poetryName, authorId, content, imageUrl);
        try {
            PrintWriter out = response.getWriter();
            out.print("success");
            //关闭流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mav.setViewName("admin-poetry-list");
        return mav;
    }

}
