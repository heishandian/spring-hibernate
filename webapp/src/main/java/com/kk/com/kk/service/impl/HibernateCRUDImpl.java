package com.kk.com.kk.service.impl;

import com.kk.models.NewDao;
import com.kk.models.NewsEntity;
import com.kk.service.IHibernateCRUD;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("hibernateCRUD")
public class HibernateCRUDImpl implements IHibernateCRUD {
   @Resource
    private NewDao newDao;
    public void insert(NewsEntity news) {
         newDao.save(news);
    }

    public NewsEntity select(Integer id) {
       return newDao.findOne(id);
    }
}
