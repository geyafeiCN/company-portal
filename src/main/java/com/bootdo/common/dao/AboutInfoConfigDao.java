package com.bootdo.common.dao;

import com.bootdo.common.domain.AboutInfoConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表
 * 
 * huamu.com
 * 
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface AboutInfoConfigDao {

	AboutInfoConfigDO get(String type);

	int update(AboutInfoConfigDO aboutInfoConfig);



}
