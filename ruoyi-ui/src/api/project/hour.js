import request from '@/utils/request'

// 查询项目工时列表
export function listHour(query) {
  return request({
    url: '/charges/hour/list',
    method: 'get',
    params: query
  })
}

// 查询项目工时详细
export function getHour(id) {
  return request({
    url: '/charges/hour/' + id,
    method: 'get'
  })
}

// 新增项目工时
export function addHour(data) {
  return request({
    url: '/charges/hour',
    method: 'post',
    data: data
  })
}

// 修改项目工时
export function updateHour(data) {
  return request({
    url: '/charges/hour',
    method: 'put',
    data: data
  })
}

// 删除项目工时
export function delHour(id) {
  return request({
    url: '/charges/hour/' + id,
    method: 'delete'
  })
}
