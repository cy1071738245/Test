package com.cy.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
	public static JSONObject upload(MultipartFile file, HttpServletRequest request) throws IOException {
		String imageUrl = null;
		String name = "";
		if (nonNull(file)) {
			String str = requireNonNull(file.getOriginalFilename());
			name = UUID.randomUUID() + str.substring(str.lastIndexOf("."));
			String fileUrl = request.getServletContext().getRealPath("/upload") + "/" + name;
			imageUrl = request.getServletPath() + "/upload/" + name;
			file.transferTo(new File(fileUrl));
		}
		return new JSONObject().fluentPut("src", imageUrl).fluentPut("name", name);
	}

}
