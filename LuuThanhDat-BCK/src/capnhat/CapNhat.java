package capnhat;

import java.util.Scanner;

public class CapNhat {

	static Scanner sc = new Scanner(System.in);
	
	public static void capNhat() {;
		do {
			int chon ;
			System.out.println("\n\t\t\t______________________________");
			System.out.println("\n\t\t\t=====>CAP NHAT THONG TIN<=====");
			System.out.println("\nNhap so de su dung cac chuc nang sau:");
			System.out.println("\tNhan phim 1: Cap nhat danh sach sinh vien");
			System.out.println("\tNhan phim 2: Cap nhat danh sach mon  hoc");
			System.out.println("\tNhan phim 3: Cap nhat bang diem");
			System.out.println("\tNhan phim 0: Quay lai");
			System.out.print("--->Nhap lua chon cua ban:");
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:CapNhatDanhSachSinhVien.capNhat();break;
			case 2:CapNhatDanhSachMonHoc.capNhat();break;
			case 3:CapNhatBangDiem.capNhat();break;
			case 0:return;
			default:System.out.println("Chon chuc nang khong hop le....!!!!");;
			}
		}
		while(true);
	}
}
