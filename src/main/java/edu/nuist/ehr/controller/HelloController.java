package edu.nuist.ehr.controller;

import edu.nuist.ehr.bean.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController//springmvc能通过这个注解识别这个类，从而加载类中的代码逻辑
public class HelloController {

    @RequestMapping("/hello")//映射前台发送的请求
    public String hello(){
        return "hello World";
    }
    @RequestMapping("/employee")
    public List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三","男",18,"工人"));
        list.add(new Employee("李四","女",20,"工人"));
        list.add(new Employee("王八","男",35,"经理"));
        list.add(new Employee("阿峰","男",24,"学生"));
        return list;
    }
}
