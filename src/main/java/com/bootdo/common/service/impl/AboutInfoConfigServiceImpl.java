package com.bootdo.common.service.impl;

import com.bootdo.common.dao.AboutInfoConfigDao;
import com.bootdo.common.domain.AboutInfoConfigDO;
import com.bootdo.common.service.AboutInfoConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AboutInfoConfigServiceImpl implements AboutInfoConfigService {
    @Autowired
    private AboutInfoConfigDao aboutInfoConfigDao;

    @Override
    public AboutInfoConfigDO get(String type) {
        return aboutInfoConfigDao.get(type);
    }

    @Override
    public int update(AboutInfoConfigDO aboutInfoConfig) {
        return aboutInfoConfigDao.update(aboutInfoConfig);
    }
}
