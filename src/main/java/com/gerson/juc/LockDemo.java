package com.gerson.juc;

/**
 * @author gezz gezhizheng@xiaomi.com
 * @description
 * @date 2020/9/7.
 */
public class LockDemo {

    static class Account {
        public String accountId;

    }

    public void fun(Account account1, Account account2) {
        synchronized (account1) {
            synchronized (account2) {
                //此处省略了业务代码
                //....
            }
        }
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        Account account1 = new Account();
        Account account2 = new Account();
        new Thread(() -> {
            while (true) {
                lockDemo.fun(account1, account2);
            }
        }).start();


        new Thread(() -> {
            while (true) {
                lockDemo.fun(account2, account1);
            }
        }).start();

    }
}
