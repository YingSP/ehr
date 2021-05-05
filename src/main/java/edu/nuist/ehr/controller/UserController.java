package edu.nuist.ehr.controller;

import edu.nuist.ehr.bean.User;
import edu.nuist.ehr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/user/find")
    public List<User> findList(@RequestBody User cond){
        return userService.findList(cond);
    }

    @PostMapping("/user")
    public String insert(@RequestBody User user){
        userService.insert(user);
        return "insert success";
    }

    @DeleteMapping("/user/{id}")//花括号内的就是id
    //@PathVariable
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return"delete success";
    }

    @PostMapping("/user/update")
    public String update(@RequestBody User user){
        userService.update(user);
        return "update success";
    }
    @GetMapping("/user/find/{id}")
    public List<User> findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }
    @PostMapping("/login")
    //前台传来一个login的命令
    public User login(@RequestBody User user, HttpServletResponse response) {
        User user1 = userService.find(user);
        if (user1 != null) {
            return user1;
        }
        //设置响应状态码为403
        response.setStatus(403);
        return null;
    }

}
