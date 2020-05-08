package com.gerson.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author gezz
 * @description
 * @date 2020/5/3.
 */
public class Stream {

    private static int[] ints = {10,21,242,1,2,3,4,5,6,7};

    public static void main(String[] args) {
        List<User> users=new ArrayList<User>();
        for(int i=1;i<10;i++){
            users.add(new User(i,"billy" + i, i));
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
        private int score;

        public User(int id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
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

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    /**
     * 过滤stream中的数据
     */
    @Test
    public void test1() {
        Long biggerCount = Arrays.stream(ints).filter(value -> value > 2).count();
        System.out.println(biggerCount);

        System.out.println("---------------------------");
        //并行流
        Long paraBiggerCount = IntStream.range(0, Integer.MAX_VALUE).parallel().filter(value -> value > 2).count();
        System.out.println(paraBiggerCount);

        System.out.println("---------------------------");
        int userCount = 100000;
        List<User> users = new ArrayList<>(userCount);
        for (int i = 0; i < userCount; i++) {
            users.add(new User(i,"gezz", i));
        }

        //从Object集合中得到一个基本数据流
        Double average = users.stream().mapToInt(user -> user.getScore()).average().getAsDouble();
        System.out.println(average);

        System.out.println("---------------------------");
        //并行排序
        Arrays.parallelSort(ints);
        Arrays.stream(ints).forEach(System.out::println);


        System.out.println("---------------------------");
        //给数组赋值
        Random random = new Random();
        Arrays.setAll(ints, value -> {return random.nextInt();});
        Arrays.stream(ints).forEach(System.out::println);
    }


}
