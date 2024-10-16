package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Projects;
import com.ruoyi.system.service.IProjectsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * projectController
 * 
 * @author ruoyi
 * @date 2024-10-16
 */
@RestController
@RequestMapping("/system/projects")
public class ProjectsController extends BaseController
{
    @Autowired
    private IProjectsService projectsService;

    /**
     * 查询project列表
     */
    @PreAuthorize("@ss.hasPermi('system:projects:list')")
    @GetMapping("/list")
    public TableDataInfo list(Projects projects)
    {
        startPage();
        List<Projects> list = projectsService.selectProjectsList(projects);
        return getDataTable(list);
    }

    /**
     * 导出project列表
     */
    @PreAuthorize("@ss.hasPermi('system:projects:export')")
    @Log(title = "project", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Projects projects)
    {
        List<Projects> list = projectsService.selectProjectsList(projects);
        ExcelUtil<Projects> util = new ExcelUtil<Projects>(Projects.class);
        util.exportExcel(response, list, "project数据");
    }

    /**
     * 获取project详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:projects:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return success(projectsService.selectProjectsByProjectId(projectId));
    }

    /**
     * 新增project
     */
    @PreAuthorize("@ss.hasPermi('system:projects:add')")
    @Log(title = "project", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Projects projects)
    {
        return toAjax(projectsService.insertProjects(projects));
    }

    /**
     * 修改project
     */
    @PreAuthorize("@ss.hasPermi('system:projects:edit')")
    @Log(title = "project", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Projects projects)
    {
        return toAjax(projectsService.updateProjects(projects));
    }

    /**
     * 删除project
     */
    @PreAuthorize("@ss.hasPermi('system:projects:remove')")
    @Log(title = "project", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(projectsService.deleteProjectsByProjectIds(projectIds));
    }
}
