/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.singleton;

/**
 *
 * @author mkong
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            return new Singleton();
        }
        return instance;
    }

}
