package com.ruoyi.food.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.food.domain.BookTable;
import com.ruoyi.food.service.IBookTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预订管理Controller
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
@RestController
@RequestMapping("/food/table")
public class BookTableController extends BaseController
{
    @Autowired
    private IBookTableService bookTableService;

    /**
     * 查询预订管理列表
     */
    @PreAuthorize("@ss.hasPermi('food:table:list')")
    @GetMapping("/list")
    public TableDataInfo list(BookTable bookTable)
    {
        startPage();
        List<BookTable> list = bookTableService.selectBookTableList(bookTable);
        return getDataTable(list);
    }

    /**
     * 导出预订管理列表
     */
    @PreAuthorize("@ss.hasPermi('food:table:export')")
    @Log(title = "预订管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BookTable bookTable)
    {
        List<BookTable> list = bookTableService.selectBookTableList(bookTable);
        ExcelUtil<BookTable> util = new ExcelUtil<BookTable>(BookTable.class);
        util.exportExcel(response, list, "预订管理数据");
    }

    /**
     * 获取预订管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('food:table:query')")
    @GetMapping(value = "/{bookId}")
    public AjaxResult getInfo(@PathVariable("bookId") Long bookId)
    {
        return success(bookTableService.selectBookTableByBookId(bookId));
    }

    /**
     * 新增预订管理
     */
    @PreAuthorize("@ss.hasPermi('food:table:add')")
    @Log(title = "预订管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BookTable bookTable)
    {
        return toAjax(bookTableService.insertBookTable(bookTable));
    }

    /**
     * 修改预订管理
     */
    @PreAuthorize("@ss.hasPermi('food:table:edit')")
    @Log(title = "预订管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BookTable bookTable)
    {
        return toAjax(bookTableService.updateBookTable(bookTable));
    }

    /**
     * 删除预订管理
     */
    @PreAuthorize("@ss.hasPermi('food:table:remove')")
    @Log(title = "预订管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bookIds}")
    public AjaxResult remove(@PathVariable Long[] bookIds)
    {
        return toAjax(bookTableService.deleteBookTableByBookIds(bookIds));
    }
}
