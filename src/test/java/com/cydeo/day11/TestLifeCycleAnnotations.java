package com.cydeo.day11;

import org.junit.jupiter.api.*;

public class TestLifeCycleAnnotations {

    @BeforeAll
    public static void init(){
        System.out.println("Before all is running");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("\tBefore each is running");
    }

    @AfterEach
    public void closeEach(){
        System.out.println("\tAfter Each is running");
    }


    @Test
    public void test1(){
        System.out.println("Test 1 is running");
    }

    @Disabled
    @Test
    public void test2(){
        System.out.println("Test 2 s running");
    }

    @AfterAll
    public static void close(){
        System.out.println("After all is running");
    }

}
