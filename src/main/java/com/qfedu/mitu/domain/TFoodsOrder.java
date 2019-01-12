package com.qfedu.mitu.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
@TableName("t_foods_order")
public class TFoodsOrder extends Model<TFoodsOrder> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer uid;
	private Integer fid;
	@TableField("foods_orderno")
	private String foodsOrderno;
	@TableField("order_foods_time")
	private Date orderFoodsTime;
	@TableField("total_price")
	private Double totalPrice;
	private Integer personcount;
	private Integer foodslevel;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFoodsOrderno() {
		return foodsOrderno;
	}

	public void setFoodsOrderno(String foodsOrderno) {
		this.foodsOrderno = foodsOrderno;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
