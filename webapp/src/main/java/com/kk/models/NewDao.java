package com.kk.models;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewDao extends PagingAndSortingRepository<NewsEntity,Integer>,
        JpaSpecificationExecutor<NewsEntity> {

}
