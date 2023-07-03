/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contest14.B4;

/**
 *
 * @author PC
 */
public class DoiBong {

    private String ma, ten;
    private int[] doiBong;

    public DoiBong(String ma, String ten, int soTran, int hieuSo, int diemSo) {
        doiBong = new int[3];
        this.ma = ma;
        this.ten = ten;
        this.doiBong[0] = soTran;
        this.doiBong[1] = hieuSo;
        this.doiBong[2] = diemSo;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public int getDiem(){
        return this.doiBong[2];
    }
    
    public int getHieuSo(){
        return this.doiBong[1];
    }
    
    public int getTranDau(){
        return this.doiBong[0];
    }
    // 0 so tran
    // 1 hieu so
    // 2 diem so
    public static DoiBong[] tranDau(DoiBong doi1, int tiSo1, int tiSo2, DoiBong doi2) {
        doi1.doiBong[0] += 1;
        doi2.doiBong[0] += 1;
        // doi1 thang
        if (tiSo1 > tiSo2) {
            doi1.doiBong[2] += 3;
            doi1.doiBong[1] += tiSo1 - tiSo2;
            doi2.doiBong[1] -= tiSo1 - tiSo2;
        } else if (tiSo1 < tiSo2) {
            doi2.doiBong[2] += 3;
            doi2.doiBong[1] += tiSo2 - tiSo1;
            doi1.doiBong[1] -= tiSo2 - tiSo1;
        } else {
            doi1.doiBong[2] += 1;
            doi2.doiBong[2] += 1;
        }
        DoiBong[] x = new DoiBong[2];
        x[0] = doi1;
        x[1] = doi2;
        return x;
    }
    
    public static int findPos(DoiBong[] x, String ten) {
        for (int i = 0; i < x.length; i++) {
            if (x[i].getTen().equals(ten)) {
                return i;
            }
        }
        return -1;
    }
    
    public String toString(){
        return this.ma + " " + this.ten + " " + this.doiBong[0] + " " + this.doiBong[1] + " " + this.doiBong[2] + "\n------------------";
    }
}
