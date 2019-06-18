package com.afei.formula.fel;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;

public class Fel {




    public static void main(String[] args){

        FelEngine fel = new FelEngineImpl();

        Object eval = fel.eval("4√");

        System.out.println(eval);

        Object o = FelEngine.instance.eval("$('Math').min(-1,(2+1),-2)");
        System.out.println(o);


    }
}
