/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.Scanner;

/**
 *
 * @author ADI
 */
public class Main {

    static void menu() {
        System.out.println("Pilih Menu");//pilihan menu
        System.out.println("1. Enqueue");//pertama
        System.out.println("2. Dequeue");//kedua
        System.out.println("3. PRINT");//ketiga
        System.out.println("4. Exit");//keempat
    }

    public static void main(String[] args) {//method main
        Scanner scan = new Scanner(System.in);//Scanner
        int pil = 0;//menunjukkan pilihan
        System.out.println("Masukkan nilai maksimal : ");//akan ditampilkan masukkan nilai maksimal
        int m = scan.nextInt();//m sama dengan scan.nextInt
        Queue qq = new Queue(m);//objek queue yang panjangnya ditentukan oleh variable m 
        do {//perulangan do
            menu();//tampilan menu
            pil = scan.nextInt();//memasukkan pilihan
            switch (pil) {//pengecekan dengan operasi switch case
                case 1://case 1
                    System.out.println("Masukkan nilai data : ");//maka ditampilkan nilai data yang akan dimasukkan
                    int dataIn = scan.nextInt();//disimpan di variable dataIn
                    qq.enqueue(dataIn);//memanggil objek dan method
                    break;//menghentikan perulangan
                case 2://case 2, proses dequeue
                    int dataOut = qq.dequeue();//data disimpan di datOut
                    if (dataOut != 0) {//jika dataOut tidak sama dengan 0
                        System.out.println("Data yang terambil : " + dataOut);//maka ditampilkan data yang terambil 
                    }
                    break;//menghentikan perulangan
                case 3://case 3, menampilkan data queue
                    qq.print();//memanggil method print
                    break;//menghentikan perulangan
            }
        } while (pil != 4);//jika tidak sama dengan 4
        System.out.println("Data tidak ada");//maka ditampilkan data tidak ada
    }
}
