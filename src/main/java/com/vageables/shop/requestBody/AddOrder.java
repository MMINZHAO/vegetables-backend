package com.vageables.shop.requestBody;

import com.vageables.shop.entity.Shopcar;
import lombok.Data;

import java.util.List;

/**
 * @author : @author
 * @date : 2020/4/14 18:08
 * @description : --AddOrder类描述--
 */
@Data
public class AddOrder {
    //结算
    private List<Integer> shopcars;
    private Integer userId;
    private Integer addressId;
}
