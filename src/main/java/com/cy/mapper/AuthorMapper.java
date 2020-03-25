package com.cy.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuthorMapper {

    List<Map<String, Object>> getAuthorList(@Param("page") int page, @Param("size") int size, @Param("keyword") String keyword);

    int getAuthorListCount(@Param("keyword") String keyword);

    int addAuthor(@Param("authorName") String authorName, @Param("sex") String sex,
                  @Param("dynasty") String dynasty, @Param("description") String description);

    int editAuthor(@Param("authorId") int authorId, @Param("authorName") String authorName, @Param("sex") String sex,
                   @Param("dynasty") String dynasty, @Param("description") String description);

    int deleteAuthor(@Param("authorId") int authorId);

}
