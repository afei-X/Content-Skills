package com.afei.pojo.algorithm;

/**
 * @author gongxiangfei
 * @description: 快排算法
 * @Date 2019/7/23 6:44 PM
 */
public class QuickSorting {


    public static void main(String[] args){

        int[] array = {6,2,7,3,8,1,9};

        quickSort(array);

        for (int a : array) {

            System.out.println(a);
        }
    }

    private static void quickSort(int[] array) {

        if(array.length>0){

            quickSort(array,0,array.length-1);
        }
    }

    private static void quickSort(int[] array, int low, int high) {

        if(low<high){
            
           int partition = partition(array,low,high);
           quickSort(array,low,partition-1);
           quickSort(array,partition+1,high);
            
        }

    }

    private static int partition(int[] array, int low, int high) {

        while(low<high){
            while(array[high]>=array[low]&&low<high){
                high--;
            }
            swap(array,low,high);

            while (array[low]<=array[high]&&low<high){
                low++;
            }
            swap(array,low,high);
        }

        return low;

    }

    private static void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high]=temp;
    }
}
