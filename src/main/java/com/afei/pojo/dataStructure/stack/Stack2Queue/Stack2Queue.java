package com.afei.pojo.dataStructure.stack.Stack2Queue;

import io.swagger.models.auth.In;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author gongxiangfei
 * @description:  两个栈实现一个队列
 * @Date 2019/7/10 6:21 PM
 */
public class Stack2Queue {


    static  class Stack1{

        private T[] elementDatas;

        private Integer count;

        private synchronized void push(T element){

            elementDatas[count++]=element;

        }


        private synchronized T pop(){




            return null;
        }

    }

    static class Stack2{

        private T[] element;
    }


    static class BlockingQueue{


    }



    public static void main(String[] args){









    }



}
