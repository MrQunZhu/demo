package com.example.demo.liaotian;

/**
 * author: lixq
 * date: 2019/2/21
 * 描述:
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {10,2,6,3,4,8,1,7,9,5};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int a:arr){
            System.out.println(a);
        }
    }
}
