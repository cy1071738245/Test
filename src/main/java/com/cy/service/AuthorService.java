package com.cy.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: AuthorService
 * @Description: TODO
 * @date 2020/3/25 17:03
 */
public interface AuthorService {

	Map<String, Object> getAuthorList(int page, int size, String keyword);

	void addAuthor(String authorName, String sex, String dynasty, String description);

	void editAuthor(int authorId, String authorName, String sex, String dynasty, String description);

	void deleteAuthor(int authorId);

	void batchDeleteAuthor(List<Integer> authorIds);

}
