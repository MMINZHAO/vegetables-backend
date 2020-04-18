package com.vageables.shop.config;

import com.vageables.shop.entity.Confirmorder;
import com.vageables.shop.repository.*;
import com.vageables.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : @author
 * @date : 2020/4/8 14:51
 * @description : --ControllerAutowiredService类描述--
 */

public class ControllerAutowiredService {
    @Autowired
    public AddressService addressService;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public ConfirmorderService confirmorderService;
    @Autowired
    public GoodsService goodsService;
    @Autowired
    public GoodsimageService goodsimageService;
    @Autowired
    public LoginService loginService;
    @Autowired
    public ShopcarService shopcarService;
    @Autowired
    public ShoporderService shoporderService;
    @Autowired
    public UserinfoService userinfoService;
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public ConfirmorderRepository confirmorderRepository;
    @Autowired
    public GoodsRepository goodsRepository;
    @Autowired
    public GoodsimageRepository goodsimageRepository;
    @Autowired
    public ShopcarRepository shopcarRepository;
    @Autowired
    public ShoporderRepository shoporderRepository;
    @Autowired
    public UserinfoRepository userinfoRepository;
}
