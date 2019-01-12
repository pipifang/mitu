package com.qfedu.mitu.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

public class FoodsAll {

    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    private Integer uid;
    private String pictures;
    @TableField("foods_price")
    private Double foodsPrice;
    @TableField("foods_info")
    private String foodsInfo;
    private String foodname;
    @TableField("order_foods_time")
    private Date orderFoodsTime;
    @TableField("total_price")
    private Double totalPrice;
    private Integer personcount;
    private Integer foodslevel;
    @TableField("foods_orderno")
    private String foodsOrderno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public Double getFoodsPrice() {
        return foodsPrice;
    }

    public void setFoodsPrice(Double foodsPrice) {
        this.foodsPrice = foodsPrice;
    }

    public String getFoodsInfo() {
        return foodsInfo;
    }

    public void setFoodsInfo(String foodsInfo) {
        this.foodsInfo = foodsInfo;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Date getOrderFoodsTime() {
        return orderFoodsTime;
    }

    public void setOrderFoodsTime(Date orderFoodsTime) {
        this.orderFoodsTime = orderFoodsTime;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPersoncount() {
        return personcount;
    }

    public void setPersoncount(Integer personcount) {
        this.personcount = personcount;
    }

    public Integer getFoodslevel() {
        return foodslevel;
    }

    public void setFoodslevel(Integer foodslevel) {
        this.foodslevel = foodslevel;
    }

    public String getFoodsOrderno() {
        return foodsOrderno;
    }

    public void setFoodsOrderno(String foodsOrderno) {
        this.foodsOrderno = foodsOrderno;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
