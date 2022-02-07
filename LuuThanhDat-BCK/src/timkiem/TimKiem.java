package timkiem;

import java.util.Scanner;

import capnhat.CapNhatDanhSachMonHoc;
import capnhat.CapNhatDanhSachSinhVien;

public class TimKiem {
	static Scanner sc = new Scanner(System.in);
	public static void timKiem() {
		int chon;;
		do {
			System.out.println("\n\t\t\t______________________________");
			System.out.println("\n\t\t\t=====>CHUC NANG TIM KIEM<=====");
			System.out.println("\nNhap so de lua chon cac chuc nang sau:");
			System.out.println("\tNhan phim 1: Hien thi sinh vien va bang diem cua sinh vien");
			System.out.println("\tNhan phim 2: Hien thi danh sach sinh vien hoc dang hoc");
			System.out.println("\tNhan phim 0: Quay lai");
			System.out.print("---->Nhap lua chon cua ban:");
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:
				String maSV;
				System.out.print("--->Nhap ma sinh vien can tim:");
				maSV = sc.nextLine();
				if(CapNhatDanhSachSinhVien.indexOfmaSV(maSV) == -1) {
					System.out.println("Sinh vien nay khong co trong danh sach....!!!!");
					return ;
				}
				CapNhatDanhSachSinhVien.timKiemdanhSachSinhVien(maSV);
				break;
			case 2:
				String maMH;
				System.out.print("--->Nhap ma mon hoc can tim:");
				maMH = sc.nextLine();
				if(CapNhatDanhSachMonHoc.indexOfMonHoc(maMH) == -1) {
					System.out.print("Mon hoc khong co trong danh sach....!!!!");
					return;
				}
				CapNhatDanhSachMonHoc.timKiemhienThiMonHoc(maMH);
				break;
			case 0:return;
				default:System.out.println("Lua chon cua ban khong hop le,moi nhap lai....!!!");
			}
		}while(true);
	}
}
