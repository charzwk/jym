import request from '@/utils/request'

// 查询项目费用统计单列表
export function listStatistics(query) {
  return request({
    url: '/cost/statistics/list',
    method: 'get',
    params: query
  })
}
// 查询项目基本信息（name，code，）
export function getName(pkProjectArchives) {
  return request({
    url: '/cost/statistics/baseInfo' +pkProjectArchives,
    method: 'get',
    params: pkProjectArchives
  })
}
// 查询项目下的人员信息
export function getPersonInfo(pkProjectArchives) {
  return request({
    url: '/cost/statistics/personnel/' +pkProjectArchives,
    method: 'get'
  })
}

// 查询项目费用统计单详细
export function getStatistics(id) {
  return request({
    url: '/cost/statistics/' + id,
    method: 'get'
  })
}

// 新增项目费用统计单
export function addStatistics(data) {
  return request({
    url: '/cost/statistics',
    method: 'post',
    data: data
  })
}

// 修改项目费用统计单
export function updateStatistics(data) {
  return request({
    url: '/cost/statistics',
    method: 'put',
    data: data
  })
}

// 删除项目费用统计单
export function delStatistics(id) {
  return request({
    url: '/cost/statistics/' + id,
    method: 'delete'
  })
}
