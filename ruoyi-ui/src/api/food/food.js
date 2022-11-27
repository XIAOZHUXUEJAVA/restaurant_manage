import request from '@/utils/request'

// 查询菜品管理列表
export function listFood(query) {
  return request({
    url: '/food/food/list',
    method: 'get',
    params: query
  })
}

// 查询菜品管理详细
export function getFood(foodId) {
  return request({
    url: '/food/food/' + foodId,
    method: 'get'
  })
}

// 新增菜品管理
export function addFood(data) {
  return request({
    url: '/food/food',
    method: 'post',
    data: data
  })
}

// 修改菜品管理
export function updateFood(data) {
  return request({
    url: '/food/food',
    method: 'put',
    data: data
  })
}

// 删除菜品管理
export function delFood(foodId) {
  return request({
    url: '/food/food/' + foodId,
    method: 'delete'
  })
}
