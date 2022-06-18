package com.hillel.classwork.lesson13;

public class TwoInterfaces {
    public static void main(String[] args) {
        AB ab = new AB();
        ab.fooA();
        ab.fooB();
    }

    private static class AB implements A,B {
        public void fooA() {
            A.super.foo();
        }

        public void fooB() {
            B.super.foo();
        }

        @Override
        public void foo() {
            A.super.foo();
        }
    }

    private interface A{
        default void foo(){
            System.out.println("Foo A");
        }
    }

    private interface B{
        default void foo(){
            System.out.println("Foo B");
        }
    }
}
