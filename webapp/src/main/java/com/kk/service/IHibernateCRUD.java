package com.kk.service;

        import com.kk.models.NewsEntity;

public interface IHibernateCRUD {

    public void insert(NewsEntity news);

    public NewsEntity select(Integer id);

    public void update(NewsEntity newsEntity);

    public void delete(Integer id);

}
