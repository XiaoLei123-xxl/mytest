package com.xusanjin.mytest.dao;

import com.xusanjin.mytest.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {

    List<Product> getAll();
}
