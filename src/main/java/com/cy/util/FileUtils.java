package com.cy.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * @ClassName: FileUtils
 * @Description: TODO
 * @date 2020/3/26 16:54
 */
public class FileUtils {

	/**
	 * 文件上传
	 *
	 * @param file 文件
	 * @return String
	 */
	public static String upload(MultipartFile file, HttpServletRequest request) {
		String fileUrl = null;
		if (nonNull(file)) {
			String str = requireNonNull(file.getOriginalFilename());
			String name = UUID.randomUUID() + str.substring(str.lastIndexOf("."));
			fileUrl = request.getServletContext().getRealPath("/upload") + "/" + name;
		}
		return fileUrl;
	}

}
