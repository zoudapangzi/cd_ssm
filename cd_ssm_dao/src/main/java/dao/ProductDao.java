package dao;

import domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from product ")
    public List<Product> findAll() throws Exception;

    /**
     * 添加产品信息
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 通过ID查询信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    public Product findById(int id) throws Exception;
}
