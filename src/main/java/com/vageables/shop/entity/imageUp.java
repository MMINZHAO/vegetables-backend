package com.vageables.shop.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : @author
 * @date : 2020/4/11 12:29
 * @description : --imageUp类描述--
 */

@Data
public class imageUp {
    String name;
    MultipartFile file;
}
