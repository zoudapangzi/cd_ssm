package dao;

import domain.Permission;
import domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "dao.PermissionDao.findByRoleId")),
    })
    public List<Role> findByUserId(int userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "dao.PermissionDao.findByRoleId")),
    })
    Role findById(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
