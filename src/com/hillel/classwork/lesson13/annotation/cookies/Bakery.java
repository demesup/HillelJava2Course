package com.hillel.classwork.lesson13.annotation.cookies;

import com.hillel.classwork.lesson2.Methods;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Bakery {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cl = Class.forName("com.hillel.classwork.lesson13.annotation.cookies.Cookie");
        if (cl.isAnnotationPresent(ControlledObject.class)) {
            System.out.println("annotation is present");

            Annotation annotation = (ControlledObject) cl.getAnnotation(ControlledObject.class);
            System.out.println(annotation);

            boolean isStart = false;
            boolean isStop = false;

            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(StartObject.class)) {
                    isStart = true;
                }
                if (method.isAnnotationPresent(StopObject.class)) {
                    isStop = true;
                }
                if (isStart && isStop) break;
            }

            System.out.println("This class can start baking:  " + isStart);
            System.out.println("This class can stop baking:  " + isStop);

            if (isStart && isStop){
                Cookie cookie = new Cookie();
                cookie.cook();
                cookie.finish();
            }

        } else System.out.println("not annotated");
    }
}
