package com.cy.controller;

import com.cy.constant.Number;
import com.cy.service.AuthorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName: AuthorController
 * @Description: 诗人管理
 * @date 2020/3/25 16:55
 */
public class AdminAuthorController extends BaseController {

	@Resource
	private AuthorService authorService;

	@GetMapping("adminAuthorList")
	public ModelAndView adminAuthorList(@RequestParam("page") int page, @RequestParam(value = "keyword", required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = authorService.getAuthorList(page, Number.size, keyword);
		mav.addObject("authorResultMap", result);
		mav.setViewName("admin-author-list");
		return mav;
	}

	@PostMapping("addAuthor")
	public ModelAndView addAuthor(@RequestParam("authorName") String authorName,
	                              @RequestParam("sex") String sex,
	                              @RequestParam("dynasty") String dynasty,
	                              @RequestParam("description") String description) {
		ModelAndView mav = new ModelAndView();
		authorService.addAuthor(authorName, sex, dynasty, description);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("admin-author-list");
		return mav;
	}

	@PutMapping("editAuthor")
	public ModelAndView editAuthor(@RequestParam("authorId") int authorId,
	                               @RequestParam("authorName") String authorName,
	                               @RequestParam("sex") String sex,
	                               @RequestParam("dynasty") String dynasty,
	                               @RequestParam("description") String description) {
		ModelAndView mav = new ModelAndView();
		authorService.editAuthor(authorId, authorName, sex, dynasty, description);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("admin-author-list");
		return mav;
	}

	@DeleteMapping("deleteAuthor")
	public ModelAndView deleteAuthor(@RequestParam("authorId") int authorId) {
		ModelAndView mav = new ModelAndView();
		authorService.deleteAuthor(authorId);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("admin-author-list");
		return mav;
	}

}
