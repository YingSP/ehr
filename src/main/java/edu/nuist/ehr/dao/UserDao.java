package edu.nuist.ehr.dao;

import edu.nuist.ehr.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

//用于对user表的增删改查
public interface UserDao {
    //查询user表的所有未删除数据
    @Select("select \n" +
            "  id,\n" +
            "\tusername,\n" +
            "\tpassword,\n" +
            "\tname,\n" +
            "\tphone,\n" +
            "\tdel_flag as \"delFlag\",\n" +
            "\tcreate_time as \"createTime\"\n" +
            "from users where del_flag!=1")
    List<User> findAll();



    @Insert("insert into users (" +
            " username," +
            "password," +
            "name," +
            "phone," +
            "create_time" +
            ") values(" +
            "   #{username}," +
            "   #{password}," +
            "   #{name}," +
            "   #{phone}," +
            "   #{createTime}" +
            ")")
    @SelectKey(keyProperty = "id",before = false,keyColumn = "id", statement = "select last_insert_id()", resultType = Long.class)
    void insert(User user);

    @Delete("delete from users where id = #{id}")
    void delete(Long id);

    //@Update("")
    void update(User user);

    List<User> findById(Long id);

    User login(User user);

    User find(User user);

    List<User> findList(User cond);

    //user——role的表关联
    void insertManyUserRole(User user);

    @Delete("delete from user_role where user_id =#{userId}")
    void deleteUserRole(Long userId);

}
