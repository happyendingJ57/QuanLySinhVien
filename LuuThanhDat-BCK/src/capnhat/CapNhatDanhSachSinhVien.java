package capnhat;

import java.util.ArrayList;
import java.util.Scanner;

public class CapNhatDanhSachSinhVien {
	
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<SinhVien> list = new ArrayList<SinhVien>();
	
	public static void capNhat() {
		do {
			int chon;
			System.out.println("\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\n\t\t\t----->CAP NHAT DANH SACH SINH VIEN<-----");
			System.out.println("\nNhap so de lua chon cac chuc nang sau:");
			System.out.println("\tNhan phim 1: Them moi mot sinh vien");
			System.out.println("\tNhan phim 2: Sua thong tin 1 sinh vien");
			System.out.println("\tNhan phim 3: Xoa thong tin 1 sinh vien");
			System.out.println("\tNhan phim 4: Hien thi danh sach sinh vien");
			System.out.println("\tNhan phim 0: Quay lai");
			System.out.print("--->Nhap lua chon cua ban:");
			chon = Integer.parseInt(sc.nextLine());
				switch(chon) {
				case 1:themMoiSinhVien();break;
				case 2:suaThongTinSinhVien();break;
				case 3:xoaThongTinSinhVien();break;
				case 4:hienThiSinhVien();break;
				case 0:return;
				default:System.out.println("Lua chon khong hop le....!!!!");
				}
		}
		while(true);
		
	}
	private static void themMoiSinhVien() {
		System.out.println("\n\t\t.....Them moi sinh vien.....");
		//Nhap ma cua sinh vien
		String maSV;
		do {
			System.out.print("--->Nhap ma sinh vien moi:");maSV = sc.nextLine();
			
			if(maSV.length() == 0) {
				System.out.println("Thong tin khong duoc de trong,moi nhap lai....!!!!");
			}
		}while(maSV.length() == 0);
		
		//Kiem tra dieu kien  ma sinh vien
		int index = indexOfmaSV(maSV);
		if(index != -1) {
			System.out.println("Ma sinh vien nay da ton tai....!!!!");
			return ;
		}
		
		//Nhap ho dem cua sinh vien
		String hoDem;
		do{
			System.out.print("--->Nhap ho dem:");hoDem = sc.nextLine();
			
			if(hoDem.length() == 0) {
				System.out.println("Thong tin khong duoc de trong,Moi nhap lai....!!!!");
			}
		}
		while(hoDem.length() == 0);
		
		//Nhap ten cua sinh vien
		String ten;
		do {
			System.out.print("--->Nhap ten:"); ten = sc.nextLine();
			
			if(ten.length() == 0) {
				System.out.println("Thong tin khong duoc de trong, moi nhap lai....!!!!");
			}
		}while(ten.length()==0);
		
		//Nhap nam sinh cua sinh vien 
		String namSinh;
		do {
			System.out.print("--->Nhap nam sinh(dd/mm/yyyy):");namSinh = sc.nextLine();
				 
			if(namSinh.length() == 0) 
				System.out.println("Thong tin khong duoc de trong,moi nhap lai....!!!");
		}while(namSinh.length() == 0);
			
		//Nhap gioi tinh
		String gioiTinh;
			do {
				
				System.out.print("--->Nhap gioi tinh:");gioiTinh = sc.nextLine();
			if(gioiTinh.length() == 0) 
				
				System.out.println("Thong tin khong duoc de trong,moi nhap lai....!!!!");
			}
			while(gioiTinh.length() == 0);
		
		//Them vao list
			
		SinhVien sv = new SinhVien(maSV, hoDem, ten, namSinh, gioiTinh);
		list.add(sv);
		System.out.println("Them moi sinh vien thanh cong....!!!!");	
	}
	private static void suaThongTinSinhVien() {
		System.out.println("\n\t\t....Sua thong tin sinh vien....");
		
		//Nhap ma sinh vien can sua
		
		String maSV;
		do {
			System.out.print("--->Nhap ma sinh vien can sua:");maSV = sc.nextLine();
			
			if(maSV.length()==0) {
				System.out.println("Thong tin khong duoc de trong,moi nhap lai....!!!");
			}
		}while(maSV.length() ==0);
		
		//Kiem tra ma sinh vien co trong danh sach hay khoong ??
		int index = indexOfmaSV(maSV);
		if(index == -1) {
			System.out.println("Khong ton tai sinh vien trong danh sach....!!!!");
			return;
		}
		int chon;
		do {
			System.out.println("\n\t\t~~Chon thong tin can sua~~");
			System.out.println("\nNhap so de chon thong tin can sua");
			System.out.println("\tNhan phim 1: Sua ho dem");
			System.out.println("\tNhan phim 2: Sua ten");
			System.out.println("\tNhan phim 3: Sua ngay sinh");
			System.out.println("\tNhan phim 4: Sua gioi tinh");
			System.out.println("\tNhan phim 0: Luu thong tin");
			System.out.print("--->Nhap lua chon cua ban:");
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:
				//Nhap ho dem moi
				String hoDem;
				do {
					System.out.print("--->Nhap ho dem moi:");hoDem = sc.nextLine();
					 
				if(hoDem.length() == 0)
					System.out.println("Ho Dem Khong duoc de trong,moi nhap lai....!!!! ");
				}while(hoDem.length() == 0);
				
				//sua ho dem
				list.get(index).setHoDem(hoDem);
				System.out.println("Sua ho dem thanh cong....!!!!");
				break;
			case 2:
				//Nhap ten moi
				String ten;
				do {
					System.out.print("--->Nhap ten moi :");ten = sc.nextLine();
					 
				if(ten.length() == 0) {
						System.out.println("Ten Khong duoc de trong,moi nhap lai....!!!! ");
				}
				}while(ten.length() == 0);
				
				//sua ten
				list.get(index).setTen(ten);
				System.out.print("Sua ten thanh cong....!!!!");
				break;
			case 3:
				//Nhap nam sinh moi
				String namSinh;
				do {
					System.out.print("--->Nhap nam sinh(dd/mm/yyyy):");namSinh = sc.nextLine();
					
				if(namSinh.length() == 0) {
					System.out.println("Nam Sinh Khong duoc de trong....!!!! ");
				}
				}while(namSinh.length() == 0);
				
				//sua nam sinh
				list.get(index).setNamSinh(namSinh);
				break;
			case 4:
				//Nhap gioi tinh moi
				String gioiTinh;
				do {
					System.out.print("--->Nhap gioi tinh:"); gioiTinh = sc.nextLine();
					
				if(gioiTinh.length() == 0) {
					System.out.println("Gioi Tinh Khong duoc de trong....!!!! ");
				}
				}while(gioiTinh.length() == 0);
				
				//sua gioi tinh
				list.get(index).setGioiTinh(gioiTinh);
				System.out.println("Sua gioi tinh thanh cong....!!!!");
				break;
			case 0:return ;
			default:System.out.println("Lua chon cua ban khong hop le....!!!!");
			}
		}
		while(true);
	}

	private static void xoaThongTinSinhVien() {
		System.out.println("\n\t\t......Xoa thong tin sinh vien.....");
		
		//Nhap ma sinh vien can xoa
		String maSV;
		do {
			System.out.print("--->Nhap ma sinh vien can xoa:");maSV = sc.nextLine();
			
			if(maSV.length()==0) {
				System.out.println("Thong tin khong duoc de trong,moi nhap lai....!!!!");
			}
		}while(maSV.length() ==0);
		
		//Kiem tra co trong danh sach hay khong ??
		int index = indexOfmaSV(maSV);
		if(index == -1) {
			System.out.println("Sinh vien nay khong co trong danh sach....!!!!");
			return;
		}
		//kiem tra sinh vien da co hoc mon hoc do chua 
		int check2 =CapNhatBangDiem.checkDiemOfBangDiem(maSV);
		if(check2 != -1) {
			System.out.println("Sinh vien da hoc ,khong the xoa....!!!!");
			return;
		}
		//Xoa sinh vien khoi list
		list.remove(index);
		System.out.println("Xoa sinh vien thanh cong....!!!!");
	}
	
	private static void hienThiSinhVien() {
		System.out.println("\n\t\t\tHien thi danh sach sinh vien");
		System.out.println();
		System.out.printf("   %-15s %-20s %-10s %-12s %-10s %n","Ma SV","Ho Dem","Ten","Nam Sinh","Gioi Tinh");
		for( SinhVien sv : list) {
			sv.hienThi();
		}
	}
	
	
	public static int indexOfmaSV(String maSV) {
		for(int i = 0 ;i < list.size() ; i ++) {
			if(list.get(i).getMaSV().compareToIgnoreCase(maSV) == 0) {
				return i;
			}	
		}
		return -1;
	}
	
	
	public static void danhSachSinhVien() {
		
		for(int i = 0  ;  i  < list.size() ; i++ ) {
		System.out.println("\n\t\t**Thong  tin sinh vien "+(i+1));
		System.out.println();
		System.out.printf("   %-15s %-20s %-10s %n","Ma sinh vien","Ho Dem","Ten");
				list.get(i).display();
			if (CapNhatBangDiem.checkSVOfBangDiem(list.get(i).getMaSV())  == true ){
				System.out.println("\n**Danh sach cac mon sinh vien "+(i+1)+" dang hoc");
				System.out.println();
				CapNhatBangDiem.hienThiBangDiemSV(list.get(i).getMaSV());
			 }
			else
				System.out.println("Sinh vien nay chua co bang diem....!!!!");
		}
	}
	public static void dsSinhVien(String maSV) {
		for(int i = 0 ; i< list.size();i++) {
			if(list.get(i).getMaSV().compareToIgnoreCase(maSV) == 0) {
				System.out.printf("   %-15s %-20s %-10s %n","Ma sinh vien","Ho Dem","Ten");
				list.get(i).display();
			}
		}
	}
	public static void timKiemdanhSachSinhVien(String maSV) {
		for(int i = 0  ;  i  < list.size() ; i++ ) {
			if(list.get(i).getMaSV().compareToIgnoreCase(maSV) == 0) {
				System.out.println("\n*Thong tin sinh vien thu "+(i+1)+"*");
				System.out.println();
				System.out.printf("   %-15s %-20s %-10s %n","Ma sinh vien","Ho Dem","Ten");
				list.get(i).display();
			
			if (CapNhatBangDiem.checkSVOfBangDiem(list.get(i).getMaSV())  == true ){
				System.out.println("\n**Danh sach cac mon hoc cua sinh vien thu "+(i+1));
				System.out.println();
				CapNhatBangDiem.hienThiBangDiemSV(list.get(i).getMaSV());
			 }
			else
				System.out.println("Sinh vien nay chua co bang diem....!!!!");
			}
			
		}
	}
}


