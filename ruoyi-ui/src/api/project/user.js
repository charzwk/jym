import request from '@/utils/request'

// 查询人员信息列表
export function listUser(query) {
  return request({
    url: '/data/user/list',
    method: 'get',
    params: query
  })
}

// 查询人员信息详细
export function getUser(id) {
  return request({
    url: '/data/user/' + id,
    method: 'get'
  })
}

// 新增人员信息
export function addUser(data) {
  return request({
    url: '/data/user',
    method: 'post',
    data: data
  })
}

// 修改人员信息
export function updateUser(data) {
  return request({
    url: '/data/user',
    method: 'put',
    data: data
  })
}

// 删除人员信息
export function delUser(id) {
  return request({
    url: '/data/user/' + id,
    method: 'delete'
  })
}
