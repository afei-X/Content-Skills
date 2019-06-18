package com.afei.formula.avitor;

import com.googlecode.aviator.AviatorEvaluator;

public class Avitor {



    public  static void main(String[] args){

        AviatorEvaluator.execute("math.sqrt(4)");


        Object execute = AviatorEvaluator.execute("math.min(4,7)");
        System.out.println(execute);


    }
}
