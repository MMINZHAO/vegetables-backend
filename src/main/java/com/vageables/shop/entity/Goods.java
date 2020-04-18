package com.vageables.shop.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Goods {

    @Id
    private Integer id;
    private Integer cateid;
    private String goodscode;
    private String goodsname;
    private BigDecimal goodsweight;
    private BigDecimal goodsprice;
    private String goodsinfo;
    private String goodsstate;
}