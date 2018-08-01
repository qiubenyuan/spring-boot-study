package com.github.optional.one;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/8/1 11:06
 */
public class OneTest {

    /**
     * 这个单元测试会失败， 因为 one --> two -> three(optional=true)
     * <p>
     * one 中需要显示依赖 three 才可以
     *
     * @throws Exception
     */
    @Test
    public void sayHello() throws Exception {

        System.out.println(One.sayHello("Arvin"));

    }

}