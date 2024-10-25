import request from '@/utils/request'

// 查询项目档案列表
export function listProject_archives(query) {
  return request({
    url: '/project/project_archives/list',
    method: 'get',
    params: query
  })
}

// 查询项目档案详细
export function getProject_archives(pkProjectArchives) {
  return request({
    url: '/project/project_archives/' + pkProjectArchives,
    method: 'get'
  })
}

// 新增项目档案
export function addProject_archives(data) {
  return request({
    url: '/project/project_archives',
    method: 'post',
    data: data
  })
}

// 修改项目档案
export function updateProject_archives(data) {
  return request({
    url: '/project/project_archives',
    method: 'put',
    data: data
  })
}

// 删除项目档案
export function delProject_archives(pkProjectArchives) {
  return request({
    url: '/project/project_archives/' + pkProjectArchives,
    method: 'delete'
  })
}
