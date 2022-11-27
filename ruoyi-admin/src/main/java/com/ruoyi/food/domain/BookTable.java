package com.ruoyi.food.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预订管理对象 booktable
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
public class BookTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long bookId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String bookName;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String bookPhone;

    /** 预订人数 */
    @Excel(name = "预订人数")
    private Long bookPeople;

    /** 预订桌数 */
    @Excel(name = "预订桌数")
    private Long bookTables;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 预订时间 */
    @Excel(name = "预订时间")
    private String bookWhen;

    /** 备注 */
    @Excel(name = "备注")
    private String bookNote;

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }
    public void setBookName(String bookName) 
    {
        this.bookName = bookName;
    }

    public String getBookName() 
    {
        return bookName;
    }
    public void setBookPhone(String bookPhone) 
    {
        this.bookPhone = bookPhone;
    }

    public String getBookPhone() 
    {
        return bookPhone;
    }
    public void setBookPeople(Long bookPeople) 
    {
        this.bookPeople = bookPeople;
    }

    public Long getBookPeople() 
    {
        return bookPeople;
    }
    public void setBookTables(Long bookTables) 
    {
        this.bookTables = bookTables;
    }

    public Long getBookTables() 
    {
        return bookTables;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setBookWhen(String bookWhen) 
    {
        this.bookWhen = bookWhen;
    }

    public String getBookWhen() 
    {
        return bookWhen;
    }
    public void setBookNote(String bookNote) 
    {
        this.bookNote = bookNote;
    }

    public String getBookNote() 
    {
        return bookNote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bookId", getBookId())
            .append("bookName", getBookName())
            .append("bookPhone", getBookPhone())
            .append("bookPeople", getBookPeople())
            .append("bookTables", getBookTables())
            .append("userId", getUserId())
            .append("bookWhen", getBookWhen())
            .append("bookNote", getBookNote())
            .toString();
    }
}
