package com.ruoyi.food.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 菜品管理对象 food
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
public class Food extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long foodId;

    /** 名称 */
    @Excel(name = "名称")
    private String foodName;

    /** 评分 */
    @Excel(name = "评分")
    private String foodStar;

    /** 销量 */
    @Excel(name = "销量")
    private String foodVote;

    /** 价格 */
    @Excel(name = "价格")
    private String foodPrice;

    /** 折扣 */
    @Excel(name = "折扣")
    private String foodDiscount;

    /** 份量 */
    @Excel(name = "份量")
    private String foodDesc;

    /** 状态 */
    @Excel(name = "状态")
    private String foodStatus;

    /** 类型 */
    @Excel(name = "类型")
    private String foodType;

    /** 种类 */
    @Excel(name = "种类")
    private String foodCategory;

    /** 参考图 */
    @Excel(name = "参考图")
    private String foodSrc;

    public void setFoodId(Long foodId) 
    {
        this.foodId = foodId;
    }

    public Long getFoodId() 
    {
        return foodId;
    }
    public void setFoodName(String foodName) 
    {
        this.foodName = foodName;
    }

    public String getFoodName() 
    {
        return foodName;
    }
    public void setFoodStar(String foodStar) 
    {
        this.foodStar = foodStar;
    }

    public String getFoodStar() 
    {
        return foodStar;
    }
    public void setFoodVote(String foodVote) 
    {
        this.foodVote = foodVote;
    }

    public String getFoodVote() 
    {
        return foodVote;
    }
    public void setFoodPrice(String foodPrice) 
    {
        this.foodPrice = foodPrice;
    }

    public String getFoodPrice() 
    {
        return foodPrice;
    }
    public void setFoodDiscount(String foodDiscount) 
    {
        this.foodDiscount = foodDiscount;
    }

    public String getFoodDiscount() 
    {
        return foodDiscount;
    }
    public void setFoodDesc(String foodDesc) 
    {
        this.foodDesc = foodDesc;
    }

    public String getFoodDesc() 
    {
        return foodDesc;
    }
    public void setFoodStatus(String foodStatus) 
    {
        this.foodStatus = foodStatus;
    }

    public String getFoodStatus() 
    {
        return foodStatus;
    }
    public void setFoodType(String foodType) 
    {
        this.foodType = foodType;
    }

    public String getFoodType() 
    {
        return foodType;
    }
    public void setFoodCategory(String foodCategory) 
    {
        this.foodCategory = foodCategory;
    }

    public String getFoodCategory() 
    {
        return foodCategory;
    }
    public void setFoodSrc(String foodSrc) 
    {
        this.foodSrc = foodSrc;
    }

    public String getFoodSrc() 
    {
        return foodSrc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("foodId", getFoodId())
            .append("foodName", getFoodName())
            .append("foodStar", getFoodStar())
            .append("foodVote", getFoodVote())
            .append("foodPrice", getFoodPrice())
            .append("foodDiscount", getFoodDiscount())
            .append("foodDesc", getFoodDesc())
            .append("foodStatus", getFoodStatus())
            .append("foodType", getFoodType())
            .append("foodCategory", getFoodCategory())
            .append("foodSrc", getFoodSrc())
            .toString();
    }
}
