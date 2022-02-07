package hienthi;

import java.util.Scanner;

import capnhat.CapNhatDanhSachMonHoc;
import capnhat.CapNhatDanhSachSinhVien;

public class HienThi {
	static Scanner sc = new Scanner(System.in);
	public static void hienThi() {
		do {
			System.out.println("\n\t\t\t______________________________");
			System.out.println("\n\t\t\t=====>HIEN THI BANG DIEM<=====");
			System.out.println("\nNhan so de su dung cac chuc nang sau:");
			System.out.println("\tNhan phim 1: Hien thi bang diem cua tat ca sinh vien");
			System.out.println("\tNhan phim 2: Hien thi bang diem cua tat ca cac mon hoc");
			System.out.println("\tNhan phim 0: Quay lai");
			System.out.print("--->Nhap lua chon cua ban:");
			int chon;
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:CapNhatDanhSachSinhVien.danhSachSinhVien();break;
			case 2:CapNhatDanhSachMonHoc.hienThiMonHoc();break;
			case 0:return;
				default:System.out.println("Lua chon vua nhap khong hop le, moi thu lai....!!!");
			}
		}
		while(true);
	}
}
