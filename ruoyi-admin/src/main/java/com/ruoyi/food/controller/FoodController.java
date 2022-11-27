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
import com.ruoyi.food.domain.Food;
import com.ruoyi.food.service.IFoodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 菜品管理Controller
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
@RestController
@RequestMapping("/food/food")
public class FoodController extends BaseController
{
    @Autowired
    private IFoodService foodService;

    /**
     * 查询菜品管理列表
     */
    @PreAuthorize("@ss.hasPermi('food:food:list')")
    @GetMapping("/list")
    public TableDataInfo list(Food food)
    {
        startPage();
        List<Food> list = foodService.selectFoodList(food);
        return getDataTable(list);
    }

    /**
     * 导出菜品管理列表
     */
    @PreAuthorize("@ss.hasPermi('food:food:export')")
    @Log(title = "菜品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Food food)
    {
        List<Food> list = foodService.selectFoodList(food);
        ExcelUtil<Food> util = new ExcelUtil<Food>(Food.class);
        util.exportExcel(response, list, "菜品管理数据");
    }

    /**
     * 获取菜品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('food:food:query')")
    @GetMapping(value = "/{foodId}")
    public AjaxResult getInfo(@PathVariable("foodId") Long foodId)
    {
        return success(foodService.selectFoodByFoodId(foodId));
    }

    /**
     * 新增菜品管理
     */
    @PreAuthorize("@ss.hasPermi('food:food:add')")
    @Log(title = "菜品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Food food)
    {
        return toAjax(foodService.insertFood(food));
    }

    /**
     * 修改菜品管理
     */
    @PreAuthorize("@ss.hasPermi('food:food:edit')")
    @Log(title = "菜品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Food food)
    {
        return toAjax(foodService.updateFood(food));
    }

    /**
     * 删除菜品管理
     */
    @PreAuthorize("@ss.hasPermi('food:food:remove')")
    @Log(title = "菜品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{foodIds}")
    public AjaxResult remove(@PathVariable Long[] foodIds)
    {
        return toAjax(foodService.deleteFoodByFoodIds(foodIds));
    }
}
