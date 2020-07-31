package com.xusanjin.mytest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Product {

    //商品id
    private Long productId;
    //商品名
    private String productName;
    //商品描述
    private String productDesc;
    //缩略图地址
    private String imgAddr;
    //原价
    private String normalPrice;
    //折扣价
    private String promotionPrice;
    //权重
    private Integer priority;
    //商品积分
    private Integer point;
    //创建时间
    private Date createTime;
    //修改时间
    private Date lastEditTime;
    //状态   0=下架，1=商品可用
    private Integer enableStatus;
    //商品图片
//    private List<ProductImg> productImgList;
    //属于哪个商品
//    private ProductCategory productCategory;
    //属于哪个店铺
//    private Shop shop;
}
