package com.cy.controller;

import com.alibaba.fastjson.JSONObject;
import com.cy.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName: UploadController
 * @Description: TODO
 * @date 2020/3/27 16:05
 */
@Controller
public class UploadController extends BaseController {

	@PostMapping("uploadImage")
	@ResponseBody
	public JSONObject uploadImage(@RequestParam("file") MultipartFile file) {
		JSONObject result = null;
		try {
			result = FileUtils.upload(file, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
