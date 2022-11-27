package com.ruoyi.food.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.food.mapper.FoodMapper;
import com.ruoyi.food.domain.Food;
import com.ruoyi.food.service.IFoodService;

/**
 * 菜品管理Service业务层处理
 * 
 * @author xiaozhu
 * @date 2022-11-27
 */
@Service
public class FoodServiceImpl implements IFoodService 
{
    @Autowired
    private FoodMapper foodMapper;

    /**
     * 查询菜品管理
     * 
     * @param foodId 菜品管理主键
     * @return 菜品管理
     */
    @Override
    public Food selectFoodByFoodId(Long foodId)
    {
        return foodMapper.selectFoodByFoodId(foodId);
    }

    /**
     * 查询菜品管理列表
     * 
     * @param food 菜品管理
     * @return 菜品管理
     */
    @Override
    public List<Food> selectFoodList(Food food)
    {
        return foodMapper.selectFoodList(food);
    }

    /**
     * 新增菜品管理
     * 
     * @param food 菜品管理
     * @return 结果
     */
    @Override
    public int insertFood(Food food)
    {
        return foodMapper.insertFood(food);
    }

    /**
     * 修改菜品管理
     * 
     * @param food 菜品管理
     * @return 结果
     */
    @Override
    public int updateFood(Food food)
    {
        return foodMapper.updateFood(food);
    }

    /**
     * 批量删除菜品管理
     * 
     * @param foodIds 需要删除的菜品管理主键
     * @return 结果
     */
    @Override
    public int deleteFoodByFoodIds(Long[] foodIds)
    {
        return foodMapper.deleteFoodByFoodIds(foodIds);
    }

    /**
     * 删除菜品管理信息
     * 
     * @param foodId 菜品管理主键
     * @return 结果
     */
    @Override
    public int deleteFoodByFoodId(Long foodId)
    {
        return foodMapper.deleteFoodByFoodId(foodId);
    }
}
