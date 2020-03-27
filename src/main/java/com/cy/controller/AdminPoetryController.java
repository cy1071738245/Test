package com.cy.controller;

import com.cy.constant.Number;
import com.cy.service.PoetryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class AdminPoetryController extends BaseController {

    @Resource
    private PoetryService poetryService;

    @GetMapping("adminPoetryList")
    public ModelAndView adminAuthorList(@RequestParam("page") int page, @RequestParam(value = "keyword", required = false) String keyword) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> result = poetryService.getPoetryList(page, Number.size, keyword);
        mav.addObject("poetryResultMap", result);
        mav.setViewName("admin-poetry-list");
        return mav;
    }

    @GetMapping("loadAuthorInfo")
    public ModelAndView loadAuthorInfo() {
        ModelAndView mav = new ModelAndView();
        Map<String, List<Map<String, Object>>> result = poetryService.loadAuthorInfo();
        mav.addObject("authorInfoMap", result);
        mav.setViewName("admin-poetry-add");
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

    @PostMapping("editPoetry")
    public ModelAndView editPoetry(@RequestParam("poetryId") int poetryId,
                                   @RequestParam("poetryName") String poetryName,
                                   @RequestParam("authorId") int authorId,
                                   @RequestParam("content") String content,
                                   @RequestParam(value = "image", required = false) MultipartFile image) {
        ModelAndView mav = new ModelAndView();
        String imageUrl = null;
        poetryService.editPoetry(poetryId, poetryName, authorId, content, imageUrl);
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

    @DeleteMapping("deletePoetry")
    public ModelAndView deletePoetry(@RequestParam("poetryId") int poetryId) {
        ModelAndView mav = new ModelAndView();
        poetryService.deletePoetry(poetryId);
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

    @DeleteMapping("batchDeletePoetry")
    public ModelAndView batchDeletePoetry(@RequestParam("poetryIds") List<Integer> poetryIds) {
        ModelAndView mav = new ModelAndView();
        System.err.println(poetryIds);
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
