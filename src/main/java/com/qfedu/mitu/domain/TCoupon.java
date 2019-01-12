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
 * @since 2019-01-11
 */
@TableName("t_coupon")
public class TCoupon extends Model<TCoupon> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("cou_value")
	private Integer couValue;
	private Integer credits;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCouValue() {
		return couValue;
	}

	public void setCouValue(Integer couValue) {
		this.couValue = couValue;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
