package com.kk.dao;

import com.kk.models.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewDao extends PagingAndSortingRepository<NewsEntity,Integer>,
        JpaSpecificationExecutor<NewsEntity>,JpaRepository<NewsEntity,Integer> {

}
