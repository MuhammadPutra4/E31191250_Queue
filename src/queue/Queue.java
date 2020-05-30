/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author ADI
 */
public class Queue {

    int max, size, depan, belakang;//deklarasi atribut
    int q[];//array q bertipe integer

    Queue(int m) {//constractor parameter m
        max = m;//maksimal sama dengan m
        create();//memanggil method create
    }

    void create() {//method create
        q = new int[max];//inisialisasi array q
        size = 0;//size samadengan 0, karena data masih kosong
        depan = belakang = -1;//depan sama dengan belakang sama dengan -1
    }

    boolean isEmpty() {//method untuk mengecek queue, apakah kosong atau tidak
        if (size == 0) {//jika size sama dengan 0
            return true;//maka nilai benar
        } else {//jika tidak 
            return false;//maka akan mengembalikan nilai false/salah
        }
    }

    boolean isFull() {//method isfull untuk mengecek queue, apakah penuh atau tidak
        if (size == max) {//jika size sama dengan maksimal
            return true;//maka nilai benar
        } else {//jika tidak
            return false;//maka akan mengembalikan nilai false/salah
        }
    }

    void enqueue(int data) {//method proses enqueue atau menambah data
        if (isFull()) {//jika queue dalam keadaan penuh/full
            System.out.println("Antrian sudah penuh");//maka akan ditampilkan antrian sudah penuh
        } else {//jika tidak, akan dicek lagi apakah queue dalam keadaan kosong
            if (isEmpty()) {//jika dalam keadaan kosong
                depan = belakang = 0;// maka depan sama dengan belakang = 0
            } else {//jika tidak kosong, akan dicek lagi apakah blakang sama dengan max-1
                if (belakang == max - 1) {//jika belakang sama dengan max-1
                    belakang = 0;//maka belakang sama dengan 0
                } else {//jika tidak
                    belakang++;//maka belakang akan diincrement 
                }
            }
            q[belakang] = data;//memberikan nilai array q sama dengan data
            size++;//size incremet
        }
    }

    int dequeue() {//method dequeue atau pengambilan data
        int data = 0;//inisialisasi untuk menyimpan data yang akan diambil
        if (isEmpty()) {//pengecekan apakah queue dalam keadaan kosong, jika iya
            System.out.println("Antrian kosong");//maka akan ditampilkan antrian kosong
        } else {//jika tidak
            data = q[depan];//maka variable data akan menyimpan nilai dari array q
            size--;//size dicrement
            if (isEmpty()) {//kemudian dilakukan pengecekan lagi apakah queue dalam keadaan ksong, jika iya
                depan = belakang = -1;//maka depan sama dengan belakang = -1
            } else {//jika tidak
                if (depan == max - 1) {//maka dicek lagi apakah depan sama dengan max-1, jika iya
                    depan = 0;//depan sama dengan 0
                } else {//jika tidak
                    depan++;//depan increment
                }
            }
        }
        return data;//mengembalikan nilai data yang telah diambil
    }

    void print() {//method print untuk menampilkan data
        if (isEmpty()) {//pengecekan apakah queue dalam keadaan kosong, jika iya
            System.out.println("Antrian kosong");//akan ditampilkan antrian kosong
        } else {//jika tidak
            int i = depan;//inisalisasi i sama dengan depan/ data paling depan
            while (i != belakang) {//proses perulangan, jika i tidak sama dengan belakang
                System.out.print(q[i] + "-");//maka data akan dikurangi
                i = (i + 1) % max;//dengan menampilkan index (i + 1) modulus max
            }
            System.out.println(q[i] + "-");//akan ditampilkan array q yang memiliki index i
            System.out.println("Jumlah antrian : " + size);//dan akan ditampilkan jumlah antrian
        }
    }
}
