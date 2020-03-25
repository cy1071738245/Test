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
import java.util.Map;
import java.util.UUID;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

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

    @PostMapping("addPoetry")
    public ModelAndView addPoetry(@RequestParam("poetryName") String poetryName,
                                  @RequestParam("authorId") int authorId,
                                  @RequestParam("content") String content,
                                  @RequestParam(value = "image", required = false) MultipartFile image) {
        ModelAndView mav = new ModelAndView();
        String imageUrl = upload(image);
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

    @PutMapping("editPoetry")
    public ModelAndView editPoetry(@RequestParam("poetryId") int poetryId,
                                   @RequestParam("poetryName") String poetryName,
                                   @RequestParam("authorId") int authorId,
                                   @RequestParam("content") String content,
                                   @RequestParam(value = "image", required = false) MultipartFile image) {
        ModelAndView mav = new ModelAndView();
        String imageUrl = upload(image);
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

    /**
     * 文件上传
     *
     * @param file 文件
     * @return String
     */
    private String upload(MultipartFile file) {
        String fileUrl = null;
        if (nonNull(file)) {
            String str = requireNonNull(file.getOriginalFilename());
            String name = UUID.randomUUID() + str.substring(str.lastIndexOf("."));
            fileUrl = request.getServletContext().getRealPath("/upload") + "/" + name;
        }
        return fileUrl;
    }

}
