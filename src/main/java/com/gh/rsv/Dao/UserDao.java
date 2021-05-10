package com.gh.rsv.Dao;
import com.gh.rsv.bean.Student;
import com.gh.rsv.bean.Teacher;
import com.gh.rsv.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart,@Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int updateState(@Param("id") Integer id,@Param("state") boolean state);
    public int addUser(User user);
    public int deleteUser(Integer id);
    public User getUserById(int id);
    public int updateUser(@Param("id") Integer id,@Param("password") String password,@Param("email") String email);
    public void insertStudent(@Param("student") Student student);
    public void insertTeacher(@Param("teacher")Teacher teacher);
}
