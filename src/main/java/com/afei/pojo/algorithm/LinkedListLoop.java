package com.afei.pojo.algorithm;


/**
 * @author gongxiangfei
 * @description: 检测链表是否成环
 * @Date 2019/7/29 2:38 PM
 */
public class LinkedListLoop {



    static class Node{
        private int   data;
        private Node   next;

        private Node(){}

        private Node(int data){
            this.data=data;
        }
        private Node(int data,Node node){
            this.data=data;
            this.next=node;
        }
    }

    public static void main(String[] args){

        // 构造链表 1->2->3->4->5->6-4;
        Node head = new Node();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = d;


        Boolean ba = jungleLinkendListLoop(head);
        System.out.println(ba);

    }

    /*通过两个指针进行检测，如果成环：两个指针会进行碰撞到一起*/
    private static Boolean jungleLinkendListLoop(Node head) {

        Node slow = head.next;
        Node fast = head.next.next;

        if(slow==null || fast==null){

            return false;
        }

        while(slow.next!=null){


           if(fast.next==null){

               return false;
           }

           if(slow.data==fast.data){

               return true;
           }

           slow=slow.next;
           fast=fast.next.next;


           if(fast==null){

               return false;
           }
        }

        return false;
    }
}
