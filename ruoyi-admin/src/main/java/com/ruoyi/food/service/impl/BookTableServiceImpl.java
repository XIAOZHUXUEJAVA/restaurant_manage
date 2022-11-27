package com.ruoyi.food.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.food.mapper.BookTableMapper;
import com.ruoyi.food.domain.BookTable;
import com.ruoyi.food.service.IBookTableService;

/**
 * 预订管理Service业务层处理
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
@Service
public class BookTableServiceImpl implements IBookTableService 
{
    @Autowired
    private BookTableMapper bookTableMapper;

    /**
     * 查询预订管理
     * 
     * @param bookId 预订管理主键
     * @return 预订管理
     */
    @Override
    public BookTable selectBookTableByBookId(Long bookId)
    {
        return bookTableMapper.selectBookTableByBookId(bookId);
    }

    /**
     * 查询预订管理列表
     * 
     * @param bookTable 预订管理
     * @return 预订管理
     */
    @Override
    public List<BookTable> selectBookTableList(BookTable bookTable)
    {
        return bookTableMapper.selectBookTableList(bookTable);
    }

    /**
     * 新增预订管理
     * 
     * @param bookTable 预订管理
     * @return 结果
     */
    @Override
    public int insertBookTable(BookTable bookTable)
    {
        return bookTableMapper.insertBookTable(bookTable);
    }

    /**
     * 修改预订管理
     * 
     * @param bookTable 预订管理
     * @return 结果
     */
    @Override
    public int updateBookTable(BookTable bookTable)
    {
        return bookTableMapper.updateBookTable(bookTable);
    }

    /**
     * 批量删除预订管理
     * 
     * @param bookIds 需要删除的预订管理主键
     * @return 结果
     */
    @Override
    public int deleteBookTableByBookIds(Long[] bookIds)
    {
        return bookTableMapper.deleteBookTableByBookIds(bookIds);
    }

    /**
     * 删除预订管理信息
     * 
     * @param bookId 预订管理主键
     * @return 结果
     */
    @Override
    public int deleteBookTableByBookId(Long bookId)
    {
        return bookTableMapper.deleteBookTableByBookId(bookId);
    }
}
