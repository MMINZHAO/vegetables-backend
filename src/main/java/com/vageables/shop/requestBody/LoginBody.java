package com.vageables.shop.requestBody;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : hello
 * @date : 2020/4/8 12:36
 * @description : --LoginBody类描述--
 */

@Data
public class LoginBody {
    private String username;
    private String password;
    private String usertype;
}
