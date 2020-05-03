package com.gerson.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gezz
 * @description
 * @date 2020/5/3.
 */
public class Stream {

    public static void main(String[] args) {
        List<User> users=new ArrayList<User>();
        for(int i=1;i<10;i++){
            users.add(new User(i,"billy" + i));
        }
        //引用方法
        users.stream().map(User::getName).filter((name) -> !"billy1".equals(name)).forEach(System.out::println);

        users.stream().map(user -> user.getName())
                .filter((name) -> !"billy1".equals(name))
                .forEach(name -> System.out.println(name));
    }

    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
