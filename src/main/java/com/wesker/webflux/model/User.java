package com.wesker.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 测试实体，这里引入了lombok来简化生成get set等常用方法
 *  IDEA使用需要安装“lombok plugin”这个插件
 *  1. 在Settings-Plugins里搜索安装
 *  2. 在Build,Exception,Deployment-Compiler-Annotation Processors里把Enable annotation processing开关打开
 *
 *
 * @author MR.ZHANG
 * @create 2018-08-25 10:46
 */

@Data   // 生成无参构造方法/getter/setter/hashCode/equals/toString
@AllArgsConstructor // 生成所有参数构造方法
// @AllArgsConstructor会导致@Data不生成无参构造方法，需要手动添加@NoArgsConstructor，
// 如果没有无参构造方法，可能会导致比如com.fasterxml.jackson在序列化处理时报错
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String phone;
    private String email;
    private String name;
    private Date birthday;
}
