package com.cy.controller;

import com.alibaba.fastjson.JSONObject;
import com.cy.constant.Number;
import com.cy.service.PoetryService;
import com.cy.util.ResultUtils;
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

    @GetMapping("loadAuthorInfoToAdd")
    public ModelAndView loadAuthorInfoToAdd() {
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
        ResultUtils.ajaxPrintWriter("success", response);
        mav.setViewName("admin-poetry-list");
        return mav;
    }

    @GetMapping("loadAuthorInfoToEdit")
    public ModelAndView loadAuthorInfoToEdit() {
        ModelAndView mav = new ModelAndView();
        Map<String, List<Map<String, Object>>> result = poetryService.loadAuthorInfo();
        mav.addObject("authorInfoMap", result);
        mav.setViewName("admin-poetry-edit");
        return mav;
    }

    @GetMapping("loadPoetryForEdit")
    @ResponseBody
    public JSONObject loadPoetryForEdit(@RequestParam("poetryId") int poetryId) {
        return poetryService.loadPoetryForEdit(poetryId);
    }

    @PostMapping("editPoetry")
    public ModelAndView editPoetry(@RequestParam("poetryId") int poetryId,
                                   @RequestParam("poetryName") String poetryName,
                                   @RequestParam("authorId") int authorId,
                                   @RequestParam("content") String content,
                                   @RequestParam(value = "imageUrl", required = false) String imageUrl) {
        ModelAndView mav = new ModelAndView();
        poetryService.editPoetry(poetryId, poetryName, authorId, content, imageUrl);
        ResultUtils.ajaxPrintWriter("success", response);
        mav.setViewName("admin-poetry-list");
        return mav;
    }

    @DeleteMapping("deletePoetry")
    public ModelAndView deletePoetry(@RequestParam("poetryId") int poetryId) {
        ModelAndView mav = new ModelAndView();
        poetryService.deletePoetry(poetryId);
        ResultUtils.ajaxPrintWriter("success", response);
        mav.setViewName("admin-poetry-list");
        return mav;
    }

    @DeleteMapping("batchDeletePoetry")
    public ModelAndView batchDeletePoetry(@RequestParam("poetryIds") List<Integer> poetryIds) {
        ModelAndView mav = new ModelAndView();
        poetryService.batchDeletePoetry(poetryIds);
        ResultUtils.ajaxPrintWriter("success", response);
        mav.setViewName("admin-poetry-list");
        return mav;
    }

}
