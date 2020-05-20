package com.cy.controller;

import com.cy.constant.Number;
import com.cy.service.AuthorService;
import com.cy.util.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: AuthorController
 * @Description: 诗人管理
 * @date 2020/3/25 16:55
 */
@Controller
public class AdminAuthorController extends BaseController {

	@Resource
	private AuthorService authorService;

	/**
	 * 诗人管理分页查询
	 *
	 * @param page 页数
	 * @param keyword 查询关键词
	 * @return ModelAndView
	 */
	@GetMapping("adminAuthorList")
	public ModelAndView adminAuthorList(@RequestParam("page") int page,
										@RequestParam(value = "keyword", required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = authorService.getAuthorList(page, Number.size, keyword);
		mav.addObject("authorResultMap", result);
		mav.setViewName("admin-author-list");
		return mav;
	}

	/**
	 * 添加诗人
	 *
	 * @param authorName 诗人名
	 * @param sex 性别
	 * @param dynasty 朝代
	 * @param description 简介
	 * @return ModelAndView
	 */
	@PostMapping("addAuthor")
	public ModelAndView addAuthor(@RequestParam("authorName") String authorName,
	                              @RequestParam("sex") String sex,
	                              @RequestParam("dynasty") String dynasty,
	                              @RequestParam("description") String description) {
		ModelAndView mav = new ModelAndView();
		authorService.addAuthor(authorName, sex, dynasty, description);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-author-list");
		return mav;
	}

	/**
	 * 编辑诗人信息
	 *
	 * @param authorId 诗人id
	 * @param authorName 诗人名
	 * @param sex 性别
	 * @param dynasty 朝代
	 * @param description 诗人简介
	 * @return ModelAndView
	 */
	@PostMapping("editAuthor")
	public ModelAndView editAuthor(@RequestParam("authorId") int authorId,
	                               @RequestParam("authorName") String authorName,
	                               @RequestParam("sex") String sex,
	                               @RequestParam("dynasty") String dynasty,
	                               @RequestParam("description") String description) {
		ModelAndView mav = new ModelAndView();
		authorService.editAuthor(authorId, authorName, sex, dynasty, description);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-author-list");
		return mav;
	}

	@DeleteMapping("deleteAuthor")
	public ModelAndView deleteAuthor(@RequestParam("authorId") int authorId) {
		ModelAndView mav = new ModelAndView();
		authorService.deleteAuthor(authorId);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-author-list");
		return mav;
	}

	/**
	 * 批量删除诗人
	 *
	 * @param authorIds 诗人id
	 * @return ModelAndView
	 */
	@DeleteMapping("batchDeleteAuthor")
	public ModelAndView batchDeleteAuthor(@RequestParam("authorIds") List<Integer> authorIds) {
		ModelAndView mav = new ModelAndView();
		authorService.batchDeleteAuthor(authorIds);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-poetry-list");
		return mav;
	}

}
