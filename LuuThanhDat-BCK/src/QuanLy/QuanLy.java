package QuanLy;

import java.util.Scanner;

import capnhat.CapNhat;
import hienthi.HienThi;
import timkiem.TimKiem;

public class QuanLy {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String [] args) {
		System.out.println("\t\t\t\t\t_________________________________________");
		System.out.println("\t\t\t\t\t|    *****Luu y cac ki hieu*****        |");
		System.out.println("\t\t\t\t\t|--->     : yeu cau nhap thong tin      |");
		System.out.println("\t\t\t\t\t|....!!!! : Thong bao cua chuong trinh  |");
		System.out.println("\t\t\t\t\t|_______________________________________|");
		do {
			System.out.println("\n\t\t\t______________________________");
			System.out.println("\n\t\t\t*****CHUONG TRINH QUAN LI*****");
			int chon;
			System.out.println("\nNhap so de lua chon cac chuc nang sau:");
			System.out.println("\tNhan phim 1: Cap nhat thong tin");
			System.out.println("\tNhan phim 2: Hien thi thong tin");
			System.out.println("\tNhan phim 3: Tim kiem thong tin");
			System.out.println("\tNhan phim 0: Dong ung dung");
			
			System.out.print("--->Nhap lua chon cua ban:");
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:CapNhat.capNhat();break;
			case 2:HienThi.hienThi();break;
			case 3:TimKiem.timKiem();break;
			case 0:System.out.println("Dong he thong thanh cong.....!!!!");System.exit(0);
			default:System.out.println("Lua chon khong hop le.....!!!!");
			}
		}while(true);
	}
		
}
