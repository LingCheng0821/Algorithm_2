package com.lock;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Laura on 2018/3/28.
 */
public class TreadLocalTest {
    static class Student {
        private int age;
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        TestThreadLocal t = new TestThreadLocal();
        new Thread(t, "Thread A").start();
        new Thread(t, "Thread B").start();
    }

    static class TestThreadLocal implements Runnable {
        ThreadLocal<Student> studentLocal = new ThreadLocal<Student>();

        @Override
        public void run() {
            String currentThreadName = Thread.currentThread().getName();
            System.out.println(currentThreadName + " is running...");
            Random random = new Random();
            int age = random.nextInt(100);
            System.out.println(currentThreadName + " is set age: "  + age);
            Student s = getStudent(); //通过这个方法，为每个线程都独立的new一个student对象，每个线程的的student对象都可以设置不同的值
            s.setAge(age);
            System.out.println("current thread first get age "  + currentThreadName + ":" + s.getAge());

        }


        public Student getStudent() {
            Student s = (Student) studentLocal.get();
            if (s == null) {
                s = new Student();
                studentLocal.set(s);
            }
            return s;
        }
    }

}
