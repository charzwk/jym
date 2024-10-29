import request from '@/utils/request'

// 查询项目工时头信息列表
export function listHour(query) {
  return request({
    url: '/hour/hour/list',
    method: 'get',
    params: query
  })
}

// 查询项目工时头信息详细
export function getHour(id) {
  return request({
    url: '/hour/hour/' + id,
    method: 'get'
  })
}

// 新增项目工时头信息
export function addHour(data) {
  return request({
    url: '/hour/hour',
    method: 'post',
    data: data
  })
}

// 修改项目工时头信息
export function updateHour(data) {
  return request({
    url: '/hour/hour',
    method: 'put',
    data: data
  })
}

// 删除项目工时头信息
export function delHour(id) {
  return request({
    url: '/hour/hour/' + id,
    method: 'delete'
  })
}
