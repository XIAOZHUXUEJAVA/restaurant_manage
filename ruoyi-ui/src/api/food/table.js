import request from '@/utils/request'

// 查询预订管理列表
export function listTable(query) {
  return request({
    url: '/food/table/list',
    method: 'get',
    params: query
  })
}

// 查询预订管理详细
export function getTable(bookId) {
  return request({
    url: '/food/table/' + bookId,
    method: 'get'
  })
}

// 新增预订管理
export function addTable(data) {
  return request({
    url: '/food/table',
    method: 'post',
    data: data
  })
}

// 修改预订管理
export function updateTable(data) {
  return request({
    url: '/food/table',
    method: 'put',
    data: data
  })
}

// 删除预订管理
export function delTable(bookId) {
  return request({
    url: '/food/table/' + bookId,
    method: 'delete'
  })
}
