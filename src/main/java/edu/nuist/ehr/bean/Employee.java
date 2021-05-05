package edu.nuist.ehr.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//此注解自动创建get和set方法以及覆盖toString方法
@AllArgsConstructor//构建有参构造函数
@NoArgsConstructor // 创建无参构造函数
public class Employee {

    private String name;
    private String gender;
    private Integer age;
    private String position;

}
