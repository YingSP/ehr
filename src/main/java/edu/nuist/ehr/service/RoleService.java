package edu.nuist.ehr.service;

import edu.nuist.ehr.bean.Role;
import edu.nuist.ehr.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//开启mysql数据库的本地事务
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public List<Role> findAll(){
        return roleDao.findAll();
    }
    public List<Role> findList(Role cond){
        return roleDao.findList(cond);
    }
    public void insert(Role role){
        roleDao.insert(role);
        roleDao.insertManyRoleMenu(role);
    }
    public void delete(Long id){
        roleDao.delete(id);
        roleDao.deleteRoleMenu(id);
        roleDao.deleteRoleUser(id);
    }
    public void update(Role role){
        roleDao.deleteRoleMenu(role.getId());
        roleDao.insertManyRoleMenu(role);
        roleDao.update(role);
    }
}
