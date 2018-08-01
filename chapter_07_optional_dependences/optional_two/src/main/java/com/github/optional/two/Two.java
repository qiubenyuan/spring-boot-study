package com.github.optional.two;

import com.github.optional.three.Three;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/8/1 11:02
 */
public class Two {

    public static String sayHello(String name) {
        return "Hello, " + Three.sayHello(name);
    }

    public static void main(String[] args) {
        // 可以执行成功
        System.out.println(sayHello("Arvin"));
    }
}
