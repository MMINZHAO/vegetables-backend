package com.vageables.shop.service;

import com.vageables.shop.entity.Confirmorder;
import com.vageables.shop.entity.Userinfo;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 12:29
 * @description : --Confirmorder类描述--
 */

public interface ConfirmorderService {
    Object AddConfirmorder(Confirmorder confirmorder);

    List<Confirmorder> ViewConfirmorders();

    void DeleteConfirmorder(Confirmorder confirmorder);

    List<Confirmorder> ViewConfirmorders(Userinfo userinfo);

    List<Confirmorder> getMaxID();
}
