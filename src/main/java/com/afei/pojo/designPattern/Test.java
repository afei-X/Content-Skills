package com.afei.pojo.designPattern;

/**
 * Description
 *
 * @author thinkpad
 * @version 1.0
 * Date                 Author			Version     Description
 * ------------------------------------------------------------------
 * 2018-11-7--19:19     suyin             1.0      Version
 */
public class Test extends Thread {

    private volatile static Test intance;

    public static Test getIntance() {
        if (intance == null) {
            synchronized (Test.class) {
                if (intance==null){

                    intance = new Test();
                }
            }
        }
        return intance;
    }

    @Override
    public void run() {
        System.out.println(Test.getIntance().hashCode());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Test().start();
        }
    }
}
