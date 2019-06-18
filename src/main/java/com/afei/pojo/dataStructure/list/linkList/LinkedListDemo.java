package com.afei.pojo.dataStructure.list.linkList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 双向链表
 */
public class LinkedListDemo {



    public static void main(String[] args){

        LinkedList<Object> list = new LinkedList<>();
        List<Object> synchronizedList = Collections.synchronizedList(list);



        list.add("1");
        list.addFirst(2);
        list.addLast("3");
        System.out.println(list);

        list.offer("4");
        list.offerFirst("5");
        list.offerLast(6);
        System.out.println(list);


    }
}
