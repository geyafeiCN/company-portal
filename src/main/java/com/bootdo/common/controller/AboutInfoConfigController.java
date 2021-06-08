package com.bootdo.common.controller;

import com.bootdo.common.utils.GenUtils;
import com.bootdo.common.utils.R;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/common/aboutconfig")
@Controller
public class AboutInfoConfigController {
	String prefix = "common/aboutconfig";

	@GetMapping("/editShow")
	public String edit(@RequestParam(value = "type", required = false, defaultValue = "0") Integer type,Model model) {
		//获取配置的关于的基本信息
		Configuration conf = GenUtils.getAboutConfig();		
		Map<String, Object> pageinfo = new HashMap<>(16);
		if (type==1) {
			//公司简介
			pageinfo.put("title", conf.getProperty("company_profile_title"));
			pageinfo.put("author", conf.getProperty("company_profile_author"));
			pageinfo.put("origin", conf.getProperty("company_profile_origin"));
			pageinfo.put("content", conf.getProperty("company_profile_content"));
			pageinfo.put("type", "1");
		}else if (type==2) {
			//企业文化
			pageinfo.put("title", conf.getProperty("company_culture_title"));
			pageinfo.put("author", conf.getProperty("company_culture_author"));
			pageinfo.put("origin", conf.getProperty("company_culture_origin"));
			pageinfo.put("content", conf.getProperty("company_culture_content"));
			pageinfo.put("type", "2");
		}else if (type==3) {
			//经营理念
			pageinfo.put("title", conf.getProperty("business_philosophy_title"));
			pageinfo.put("author", conf.getProperty("business_philosophy_author"));
			pageinfo.put("origin", conf.getProperty("business_philosophy_origin"));
			pageinfo.put("content", conf.getProperty("business_philosophy_content"));
			pageinfo.put("type", "3");
		}else{//指向未定义的页面
			return prefix + "/error";
		}
		model.addAttribute("property", pageinfo);
		return prefix + "/editshow";
	}

	@ResponseBody
	@PostMapping("/update")
	R update(@RequestParam Map<String, Object> map) {
		try {
			PropertiesConfiguration conf = new PropertiesConfiguration("aboutus.properties");
			log.info(">>>>>>>>>>>>>>>bashPath为:"+conf.getBasePath()+"<<<<<<<<<<<<<<<<<<<<<");
			String type=map.get("type").toString();
			log.info(">>>>>>>>>>>>>>type值为:"+type+"<<<<<<<<<<<<<<<<<<<<<");
			if (type.equals("1")) {
				// 公司简介
				conf.setProperty("company_profile_title", map.get("title"));
				conf.setProperty("company_profile_author", map.get("author"));
				conf.setProperty("company_profile_origin", map.get("origin"));
				conf.setProperty("company_profile_content", map.get("content"));
			} else if (type.equals("2")) {
				// 企业文化
				conf.setProperty("company_culture_title", map.get("title"));
				conf.setProperty("company_culture_author", map.get("author"));
				conf.setProperty("company_culture_origin", map.get("origin"));
				conf.setProperty("company_culture_content", map.get("content"));
			} else if (type.equals("3")) {
				// 经营理念
				conf.setProperty("business_philosophy_title", map.get("title"));
				conf.setProperty("business_philosophy_author", map.get("author"));
				conf.setProperty("business_philosophy_origin", map.get("origin"));
				conf.setProperty("business_philosophy_content", map.get("content"));
			}
			URL url = conf.getURL();
			log.info(">>>>>>>>>>>>>>url:"+url+">>>>>>>>>>>>>>>>>>");
			conf.save();
		} catch (ConfigurationException e) {
			return R.error("保存配置文件出错");
		}
		return R.ok();
	}
}
