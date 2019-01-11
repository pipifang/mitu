package com.qfedu.mitu.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zcg
 * @since 2019-01-10
 */
@TableName("t_foods")
public class TFoods extends Model<TFoods> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String pictures;
	@TableField("foods_price")
	private Double foodsPrice;
	@TableField("foods_info")
	private String foodsInfo;
	private String foodname;


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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
