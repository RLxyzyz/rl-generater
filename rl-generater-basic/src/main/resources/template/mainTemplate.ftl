package com.acm;

import java.util.Scanner;

/**
* @author ${author}
* @version 1.0
* @project acm-template
* @description acm模板
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
<#if loop>
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            System.out.println("${output!"总和是:"}"sum);
        }
    <#else>
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }
        System.out.println(${output!"总和是:"}sum);
</#if>
    }
}
