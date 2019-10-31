package com.lean.ssm.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 凌风的MI
 * 使用反射创建对象
 */
public class ReflectDemo1 {

    public static void main(String[] args) {
        try {

            /**
             * 无参构造
             */
            User user = (User) Class.forName("com.lean.ssm.reflect.User").newInstance();
            user.sayHello("小李");
            System.err.println("======================");

            /**
             * 有参构造
             */
            User user1 = (User) Class.forName("com.lean.ssm.reflect.User")
                    .getConstructor(String.class,Integer.class)
                    .newInstance("小李",21);
            user1.sayHello("小李对小何说");
            System.err.println(user1);
            System.err.println("======================");

            /**
             * 通过反射调用类中的方法一
             * 注:如果已有具体对象user2,可以使用user2.getClass().getMethod("sayHello",String.class)来调用,反之可以使用如下:
             */
            User user2 = new User();
            Method method = user2.getClass().getMethod("sayHello",String.class);
            Object object = method.invoke(user2, "小何");
            System.err.println("=======================");

            /**
             * 通过反射调用类中的方法二
             * 注:在不明确具体对象时,可以使用User.class.getMethod("sayHello", String.class)来调用
             */
            Class aClass = Class.forName("com.lean.ssm.reflect.User");
            Method method1 = User.class.getMethod("sayHello", String.class);
            Object object1 = method1.invoke(aClass.newInstance(), "小何和小李");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class User{

    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void sayHello(String name){
        System.err.println("Hello:" + name);
    }
}
