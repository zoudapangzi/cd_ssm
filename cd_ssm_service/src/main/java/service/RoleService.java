package service;

import domain.Permission;
import domain.Role;

import java.util.List;


public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
