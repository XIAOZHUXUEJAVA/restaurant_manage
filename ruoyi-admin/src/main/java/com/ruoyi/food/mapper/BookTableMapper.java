package com.ruoyi.food.mapper;

import java.util.List;
import com.ruoyi.food.domain.BookTable;

/**
 * 预订管理Mapper接口
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
public interface BookTableMapper 
{
    /**
     * 查询预订管理
     * 
     * @param bookId 预订管理主键
     * @return 预订管理
     */
    public BookTable selectBookTableByBookId(Long bookId);

    /**
     * 查询预订管理列表
     * 
     * @param bookTable 预订管理
     * @return 预订管理集合
     */
    public List<BookTable> selectBookTableList(BookTable bookTable);

    /**
     * 新增预订管理
     * 
     * @param bookTable 预订管理
     * @return 结果
     */
    public int insertBookTable(BookTable bookTable);

    /**
     * 修改预订管理
     * 
     * @param bookTable 预订管理
     * @return 结果
     */
    public int updateBookTable(BookTable bookTable);

    /**
     * 删除预订管理
     * 
     * @param bookId 预订管理主键
     * @return 结果
     */
    public int deleteBookTableByBookId(Long bookId);

    /**
     * 批量删除预订管理
     * 
     * @param bookIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBookTableByBookIds(Long[] bookIds);
}
