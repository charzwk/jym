package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Projects;

/**
 * projectService接口
 * 
 * @author ruoyi
 * @date 2024-10-16
 */
public interface IProjectsService 
{
    /**
     * 查询project
     * 
     * @param projectId project主键
     * @return project
     */
    public Projects selectProjectsByProjectId(Long projectId);

    /**
     * 查询project列表
     * 
     * @param projects project
     * @return project集合
     */
    public List<Projects> selectProjectsList(Projects projects);

    /**
     * 新增project
     * 
     * @param projects project
     * @return 结果
     */
    public int insertProjects(Projects projects);

    /**
     * 修改project
     * 
     * @param projects project
     * @return 结果
     */
    public int updateProjects(Projects projects);

    /**
     * 批量删除project
     * 
     * @param projectIds 需要删除的project主键集合
     * @return 结果
     */
    public int deleteProjectsByProjectIds(Long[] projectIds);

    /**
     * 删除project信息
     * 
     * @param projectId project主键
     * @return 结果
     */
    public int deleteProjectsByProjectId(Long projectId);
}
