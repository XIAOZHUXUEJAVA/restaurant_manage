package com.ruoyi.food.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 user
 * 
 * @author xiaozhu
 * @date 2022-11-26
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String userEmail;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String userPhone;

    /** 密码 */
    @Excel(name = "密码")
    private String userPassword;

    /** 生日 */
    @Excel(name = "生日")
    private String userBirth;

    /** 性别 */
    @Excel(name = "性别")
    private String userGender;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    public String getUserEmail() 
    {
        return userEmail;
    }
    public void setUserPhone(String userPhone) 
    {
        this.userPhone = userPhone;
    }

    public String getUserPhone() 
    {
        return userPhone;
    }
    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }

    public String getUserPassword() 
    {
        return userPassword;
    }
    public void setUserBirth(String userBirth) 
    {
        this.userBirth = userBirth;
    }

    public String getUserBirth() 
    {
        return userBirth;
    }
    public void setUserGender(String userGender) 
    {
        this.userGender = userGender;
    }

    public String getUserGender() 
    {
        return userGender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userEmail", getUserEmail())
            .append("userPhone", getUserPhone())
            .append("userPassword", getUserPassword())
            .append("userBirth", getUserBirth())
            .append("userGender", getUserGender())
            .toString();
    }
}
