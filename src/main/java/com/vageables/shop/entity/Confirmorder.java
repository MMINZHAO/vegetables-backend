package com.vageables.shop.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Confirmorder {

    @Id
    private Integer id;
    private Integer userid;
    private Integer addressid;
    private String ordernum;
    private BigDecimal totalprice;
    private String paystate;
    private Date paytime;
}