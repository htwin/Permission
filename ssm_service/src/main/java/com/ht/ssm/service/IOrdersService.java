package com.ht.ssm.service;

import com.ht.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**
     * 查询所有订单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    public List<Orders> findAll(int page,int size) throws Exception;

    /**
     * 根据id查询订单详情
     * @param id
     * @return
     * @throws Exception
     */
    public Orders findById(String id) throws Exception;
}
