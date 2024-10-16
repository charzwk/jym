import request from '@/utils/request'

// 查询project列表
export function listProjects(query) {
  return request({
    url: '/system/projects/list',
    method: 'get',
    params: query
  })
}

// 查询project详细
export function getProjects(projectId) {
  return request({
    url: '/system/projects/' + projectId,
    method: 'get'
  })
}

// 新增project
export function addProjects(data) {
  return request({
    url: '/system/projects',
    method: 'post',
    data: data
  })
}

// 修改project
export function updateProjects(data) {
  return request({
    url: '/system/projects',
    method: 'put',
    data: data
  })
}

// 删除project
export function delProjects(projectId) {
  return request({
    url: '/system/projects/' + projectId,
    method: 'delete'
  })
}
