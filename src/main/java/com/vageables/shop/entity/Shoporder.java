package com.vageables.shop.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Shoporder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userid;
    private Integer goodsid;
    private BigDecimal goodsprice;
    private Integer goodscount;
    private BigDecimal goodsamount;
    private Integer orderid;
}