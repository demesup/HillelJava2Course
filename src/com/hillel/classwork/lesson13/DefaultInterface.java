package com.hillel.classwork.lesson13;

import java.util.ArrayList;
import java.util.List;

public class DefaultInterface {

    public static void main(String[] args) {
        List<RemoteControllable> remotes = new ArrayList<>();

        remotes.add(new RemoteControlTV());
        remotes.add(new RemoteControlRadio());

        for (RemoteControllable remote: remotes) {
            remote.switchChannel();
            remote.switchVolume();
            remote.turnOn();
        }
    }
    public interface RemoteControllable{
        default void turnOn(){
            System.out.println("Turning on...");
        }
        void switchChannel();
        void switchVolume();
    }

    private static class RemoteControlTV implements RemoteControllable {
        @Override
        public void turnOn() {
            System.out.println("натискаємо кнопку вкл");
        }

        @Override
        public void switchChannel() {
            System.out.println("Натискаємо вверх/вниз");
        }

        @Override
        public void switchVolume() {
            System.out.println("Натискаємо вверх/вниз");
        }
    }

    private static class RemoteControlRadio implements RemoteControllable {
        @Override
        public void switchChannel() {
            System.out.println("Крутимо ручку");
        }

        @Override
        public void switchVolume() {
            System.out.println("Крутимо ручку");
        }
    }
}
