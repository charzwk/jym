-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('project', '3', '1', 'projects', 'system/projects/index', 1, 0, 'C', '0', '0', 'system:projects:list', '#', 'admin', sysdate(), '', null, 'project菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('project查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:projects:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('project新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:projects:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('project修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:projects:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('project删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:projects:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('project导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:projects:export',       '#', 'admin', sysdate(), '', null, '');