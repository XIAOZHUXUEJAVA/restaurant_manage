package com.ruoyi.food.mapper;

import java.util.List;
import com.ruoyi.food.domain.User;

/**
 * 用户管理Mapper接口
 * 
 * @author xiaozhu
 * @date 2022-11-26
 */
public interface UserMapper 
{
    /**
     * 查询用户管理
     * 
     * @param userId 用户管理主键
     * @return 用户管理
     */
    public User selectUserByUserId(Long userId);

    /**
     * 查询用户管理列表
     * 
     * @param user 用户管理
     * @return 用户管理集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户管理
     * 
     * @param user 用户管理
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户管理
     * 
     * @param user 用户管理
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户管理
     * 
     * @param userId 用户管理主键
     * @return 结果
     */
    public int deleteUserByUserId(Long userId);

    /**
     * 批量删除用户管理
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByUserIds(Long[] userIds);
}
