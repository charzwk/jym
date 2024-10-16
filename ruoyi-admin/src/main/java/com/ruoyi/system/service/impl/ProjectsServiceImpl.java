package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProjectsMapper;
import com.ruoyi.system.domain.Projects;
import com.ruoyi.system.service.IProjectsService;

/**
 * projectService业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-16
 */
@Service
public class ProjectsServiceImpl implements IProjectsService 
{
    @Autowired
    private ProjectsMapper projectsMapper;

    /**
     * 查询project
     * 
     * @param projectId project主键
     * @return project
     */
    @Override
    public Projects selectProjectsByProjectId(Long projectId)
    {
        return projectsMapper.selectProjectsByProjectId(projectId);
    }

    /**
     * 查询project列表
     * 
     * @param projects project
     * @return project
     */
    @Override
    public List<Projects> selectProjectsList(Projects projects)
    {
        return projectsMapper.selectProjectsList(projects);
    }

    /**
     * 新增project
     * 
     * @param projects project
     * @return 结果
     */
    @Override
    public int insertProjects(Projects projects)
    {
        return projectsMapper.insertProjects(projects);
    }

    /**
     * 修改project
     * 
     * @param projects project
     * @return 结果
     */
    @Override
    public int updateProjects(Projects projects)
    {
        return projectsMapper.updateProjects(projects);
    }

    /**
     * 批量删除project
     * 
     * @param projectIds 需要删除的project主键
     * @return 结果
     */
    @Override
    public int deleteProjectsByProjectIds(Long[] projectIds)
    {
        return projectsMapper.deleteProjectsByProjectIds(projectIds);
    }

    /**
     * 删除project信息
     * 
     * @param projectId project主键
     * @return 结果
     */
    @Override
    public int deleteProjectsByProjectId(Long projectId)
    {
        return projectsMapper.deleteProjectsByProjectId(projectId);
    }
}
