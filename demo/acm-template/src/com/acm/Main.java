package com.acm;

import java.util.Scanner;

/**
 * @author 任磊
 * @version 1.0
 * @project acm-template
 * @description acm模板
 * @date 2024/11/15 17:20:09
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
