package com.ruoyi.food.service;

import java.util.List;
import com.ruoyi.food.domain.Food;

/**
 * 菜品管理Service接口
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
public interface IFoodService 
{
    /**
     * 查询菜品管理
     * 
     * @param foodId 菜品管理主键
     * @return 菜品管理
     */
    public Food selectFoodByFoodId(Long foodId);

    /**
     * 查询菜品管理列表
     * 
     * @param food 菜品管理
     * @return 菜品管理集合
     */
    public List<Food> selectFoodList(Food food);

    /**
     * 新增菜品管理
     * 
     * @param food 菜品管理
     * @return 结果
     */
    public int insertFood(Food food);

    /**
     * 修改菜品管理
     * 
     * @param food 菜品管理
     * @return 结果
     */
    public int updateFood(Food food);

    /**
     * 批量删除菜品管理
     * 
     * @param foodIds 需要删除的菜品管理主键集合
     * @return 结果
     */
    public int deleteFoodByFoodIds(Long[] foodIds);

    /**
     * 删除菜品管理信息
     * 
     * @param foodId 菜品管理主键
     * @return 结果
     */
    public int deleteFoodByFoodId(Long foodId);
}
