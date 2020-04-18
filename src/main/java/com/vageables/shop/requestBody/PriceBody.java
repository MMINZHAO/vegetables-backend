package com.vageables.shop.requestBody;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : hello
 * @date : 2020/4/8 14:02
 * @description : --PriceBody类描述--
 */

@Data
public class PriceBody {
    private BigDecimal price1;
    private BigDecimal price2;
}
