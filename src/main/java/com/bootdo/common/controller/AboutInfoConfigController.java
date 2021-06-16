package com.bootdo.common.controller;

import com.bootdo.common.domain.AboutInfoConfigDO;
import com.bootdo.common.service.AboutInfoConfigService;
import com.bootdo.common.utils.GenUtils;
import com.bootdo.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/common/aboutconfig")
@Controller
public class AboutInfoConfigController {

	@Autowired
	private AboutInfoConfigService aboutInfoConfigService;


	String prefix = "common/aboutconfig";

	@GetMapping("/editShow")
	public String edit(@RequestParam(value = "type", required = false, defaultValue = "0") Integer type, Model model) {
		//获取配置的关于的基本信息
		Configuration conf = GenUtils.getAboutConfig();
		Map<String, Object> pageinfo = new HashMap<>(16);
		if (type == 1) {
			AboutInfoConfigDO aboutInfoConfigDO = aboutInfoConfigService.get("1");
			//公司简介
			pageinfo.put("title", aboutInfoConfigDO.getTitle());
			pageinfo.put("author", aboutInfoConfigDO.getAuthor());
			pageinfo.put("origin", aboutInfoConfigDO.getOrigin());
			pageinfo.put("content", aboutInfoConfigDO.getContent());
			pageinfo.put("type", "1");
		} else if (type == 2) {
			AboutInfoConfigDO aboutInfoConfigDO = aboutInfoConfigService.get("2");
			//企业文化
			pageinfo.put("title", aboutInfoConfigDO.getTitle());
			pageinfo.put("author", aboutInfoConfigDO.getAuthor());
			pageinfo.put("origin", aboutInfoConfigDO.getOrigin());
			pageinfo.put("content", aboutInfoConfigDO.getContent());
			pageinfo.put("type", "2");
		} else if (type == 3) {
			AboutInfoConfigDO aboutInfoConfigDO = aboutInfoConfigService.get("3");
			//经营理念
			pageinfo.put("title", aboutInfoConfigDO.getTitle());
			pageinfo.put("author", aboutInfoConfigDO.getAuthor());
			pageinfo.put("origin", aboutInfoConfigDO.getOrigin());
			pageinfo.put("content", aboutInfoConfigDO.getContent());
			pageinfo.put("type", "3");
		} else {//指向未定义的页面
			return prefix + "/error";
		}
		model.addAttribute("property", pageinfo);
		return prefix + "/editshow";
	}

	@ResponseBody
	@PostMapping("/update")
	R update(@RequestParam Map<String, Object> map) {
		AboutInfoConfigDO aboutInfoConfigDO = new AboutInfoConfigDO();
			String type = map.get("type").toString();
			if (type.equals("1")) {
				// 公司简介
				aboutInfoConfigDO.setTitle(map.get("title").toString());
				aboutInfoConfigDO.setAuthor(map.get("author").toString());
				aboutInfoConfigDO.setOrigin(map.get("origin").toString());
				aboutInfoConfigDO.setContent(map.get("content").toString());
				aboutInfoConfigDO.setType("1");
			} else if (type.equals("2")) {
				// 企业文化
				aboutInfoConfigDO.setTitle(map.get("title").toString());
				aboutInfoConfigDO.setAuthor(map.get("author").toString());
				aboutInfoConfigDO.setOrigin(map.get("origin").toString());
				aboutInfoConfigDO.setContent(map.get("content").toString());
				aboutInfoConfigDO.setType("2");
			} else if (type.equals("3")) {
				// 经营理念
				aboutInfoConfigDO.setTitle(map.get("title").toString());
				aboutInfoConfigDO.setAuthor(map.get("author").toString());
				aboutInfoConfigDO.setOrigin(map.get("origin").toString());
				aboutInfoConfigDO.setContent(map.get("content").toString());
				aboutInfoConfigDO.setType("3");
			}
			aboutInfoConfigService.update(aboutInfoConfigDO);
			return R.ok();
	}
}
