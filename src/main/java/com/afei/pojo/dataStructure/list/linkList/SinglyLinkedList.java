package com.afei.pojo.dataStructure.list.linkList;


/**
 * @author gongxiangfei
 * @describe 单向链表
 * @dataTime 2019-03-11
 */
public class SinglyLinkedList {


    private static Node head;

    /**
     * node 类
     */
    private static class Node{

        int   data;

         Node next;

        Node(int data){

            this.data=data;
        }
    }


    /**
     * 初始化链表
     */
    public static void main(String[] args){

        /*first node*/
        head = new Node(3);
        /*讲head和next进行链接*/
        head.next = new Node(5);

        Node temp = head.next;


        temp.next = new Node(1);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(9);



        /*链表逆序前输出*/
        temp= head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

        reverseLinkList();

        temp= head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

    }

    /*逆序*/
    private static void reverseLinkList() {

        if(head==null || head.next==null){

            throw new RuntimeException("你是xx");
        }

        Node first= head;
        Node second=head.next;
        Node third=null;

        while (second!=null){
            third = second.next;
            second.next=first;
            first=second;
            second=third;
        }

        head.next=null;
        head=first;
    }


}
