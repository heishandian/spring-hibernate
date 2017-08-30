package com.kk.service.impl;

import com.kk.dao.NewDao;
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

    public void update(NewsEntity newsEntity) {
        // 把所有订单的金额加 10
      //  Query query = em.createQuery(" update Order as o set o.amount=o.amount+10 ");
        //update 的记录数
      //  int result = query. executeUpdate ();
    }

    public void delete(Integer id) {
        newDao.delete(id);
    }


}
