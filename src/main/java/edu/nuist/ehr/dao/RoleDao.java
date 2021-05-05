package edu.nuist.ehr.dao;

import edu.nuist.ehr.bean.Role;
import edu.nuist.ehr.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface RoleDao {
    @Select("select id, role_name roleName from roles")
    List<Role> findAll();

    List<Role> findList(Role cond);

    @Insert("insert into roles(id,role_name) values (#{id},#{roleName})")
    @SelectKey(keyProperty = "id",before = false,keyColumn = "id", statement = "select last_insert_id()", resultType = Long.class)
    void insert(Role role);

    void insertManyRoleMenu(Role role);

    @Delete("delete from roles where id = #{id}")
    void delete(Long id);

    @Delete("delete from user_role where role_id =#{roleId}")
    void deleteRoleUser(Long roleId);

    @Delete("delete from roles_menus where role_id =#{roleId}")
    void deleteRoleMenu(Long roleId);

    void update(Role role);
}
