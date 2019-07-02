package service;

import domain.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findAll(int page,int size) throws Exception;

    public Orders findById(String id);
}
