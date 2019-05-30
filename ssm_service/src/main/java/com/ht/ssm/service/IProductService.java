package com.ht.ssm.service;

import com.ht.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll() throws  Exception;
}
