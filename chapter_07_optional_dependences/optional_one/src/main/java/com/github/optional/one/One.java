package com.github.optional.one;

import com.github.optional.two.Two;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/8/1 11:03
 */
public class One {

    public static String sayHello(String name) {
        return "Hello, " + Two.sayHello(name);
    }
}
