package edu.nuist.ehr.dao;

import edu.nuist.ehr.bean.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface MenuDao {
    @Select("select id, menu_name menuName from menus")
    List<Menu> findAll();

    List<Menu> findList(Menu cond);

    @Delete("delete from menus where id = #{id}")
    void delete(Long id);

    @Delete("delete from roles_menus where menu_id =#{menuId}")
    void deleteMenuRole(Long id);

    @Insert("insert into menus(id,menu_name) values (#{id},#{menuName})")
    @SelectKey(keyProperty = "id",before = false,keyColumn = "id", statement = "select last_insert_id()", resultType = Long.class)
    void insert(Menu menu);

    void update(Menu menu);
}
