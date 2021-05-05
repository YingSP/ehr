package edu.nuist.ehr.service;

import edu.nuist.ehr.bean.User;
import edu.nuist.ehr.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional//开启mysql数据库的本地事务
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public void insert(User user){
        userDao.insert(user);
        userDao.insertManyUserRole(user);
    }
    public void delete(Long id){

        userDao.delete(id);
        userDao.deleteUserRole(id);
    }
    public void update(User user){
        userDao.deleteUserRole(user.getId());
        userDao.insertManyUserRole(user);
        userDao.update(user);
    }
    public List<User> findById(Long id){
        return userDao.findById(id);
    }
    public User login(User user){
        return userDao.login(user);
    }
    public User find(User user){
        return userDao.find(user);
    }
    public List<User> findList(User cond){return userDao.findList(cond);}


}

