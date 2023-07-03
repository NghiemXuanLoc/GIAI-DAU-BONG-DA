/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contest14.B4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class bai4 {

    public static int check(String[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                if (Character.isDigit(a[i].charAt(j))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 20;
        DoiBong[] xepHang = new DoiBong[n];

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String ans = sc.nextLine();
            String[] arr2 = ans.split("\\s+");
            xepHang[i] = new DoiBong(ma, ten, Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]), Integer.parseInt(arr2[2]));
            sc.nextLine();
        }
//        for(DoiBong x : xepHang){
//            System.out.println(x);
//        }
        int q = 10;
        while (q-- != 0) {
            String luotDau = sc.nextLine();
            StringBuilder sb = new StringBuilder(luotDau);

            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '-') {
                    sb.replace(i, i + 1, " ");
                }
            }
            luotDau = sb.toString();
            System.out.println(luotDau);
            String[] arr3 = luotDau.split("\\s+");
            String doi1 = "", doi2 = "";
            int tiSo1 = 0, tiSo2 = 0;
            int temp = check(arr3);
            for (int i = 0; i < arr3.length; i++) {
                if (i < temp) {
                    doi1 += arr3[i];
                    doi1 += " ";
                } else if (i == temp) {
                    tiSo1 = Integer.parseInt(arr3[i]);
                    tiSo2 = Integer.parseInt(arr3[i + 1]);
                    i++;
                } else {
                    doi2 += arr3[i];
                    doi2 += " ";
                }
            }
            doi1 = doi1.trim();
            doi2 = doi2.trim();
//            // tim vi tri cua doi 1 va doi 2
            int pos1 = DoiBong.findPos(xepHang, doi1);
            int pos2 = DoiBong.findPos(xepHang, doi2);
            DoiBong[] doiBong = new DoiBong[2];
            doiBong = DoiBong.tranDau(xepHang[pos1], tiSo1, tiSo2, xepHang[pos2]);
            xepHang[pos1] = doiBong[0];
            xepHang[pos2] = doiBong[1];
        }
        Arrays.sort(xepHang, new Comparator<DoiBong>() {
            @Override
            public int compare(DoiBong t, DoiBong t1) {
                if (t.getDiem() != t1.getDiem()) {
                    return t1.getDiem() - t.getDiem();
                } else if (t.getHieuSo() != t1.getHieuSo()) {
                    return t1.getHieuSo() - t.getHieuSo();
                } else if (t.getTranDau() != t1.getTranDau()) {
                    return t.getTranDau() - t1.getTranDau();
                } else {
                    return t.getMa().compareTo(t1.getMa());
                }
            }

        });

        for (int i = 1; i <= n; i++) {
            System.out.print("#" + i + " ");
            System.out.println(xepHang[i - 1]);
        }
    }
}
