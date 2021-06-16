package com.bootdo.common.service;

import com.bootdo.common.domain.AboutInfoConfigDO;

/**
 * 公司信息
 * @date
 */
public interface AboutInfoConfigService {

	AboutInfoConfigDO get(String type);

	int update(AboutInfoConfigDO aboutInfoConfigDO);

}
