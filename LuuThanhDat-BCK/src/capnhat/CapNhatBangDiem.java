package capnhat;

import java.util.ArrayList;
import java.util.Scanner;

public class CapNhatBangDiem {
	static Scanner sc = new Scanner(System.in); 
	
	public static ArrayList<BangDiem> list = new ArrayList<BangDiem>();
	
		public static void capNhat() {
			int chon;
			do {
				System.out.println("\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("\n\t\t\t----->CAP NHAT BANG DIEM<-----");
				System.out.println("\nNhap so de su dung cac chuc nang sau:");
				System.out.println("\tNhan phim 1: Them diem vao BANG DIEM");
				System.out.println("\tNhan phim 2: Sua diem trong BANG DIEM");
				System.out.println("\tNhan phim 3: Xoa diem trong BANG DIEM");
				System.out.println("\tNhan phim 0: Quay lai");
				System.out.print("--->Nhap lua chon cua ban:");
				chon = Integer.parseInt(sc.nextLine());
				switch(chon) {
				case 1:themDiem();break;
				case 2:suaDiem();break;
				case 3:xoaDiem();break;
				case 0:return ;
					default:System.out.println("Lua chon cua ban khong hop le....!!!!");
				}
			}
			while(true);
		}
		private static void themDiem() {
			System.out.println("\n\t\t.....Them diem vao bang diem.....");
			
			//Nhap  ma sinh vien muon them
			String maSV;
			do{
				System.out.print("--->Nhap ma sinh vien can them diem:");maSV = sc.nextLine();
			if(maSV.length()==0) {
				System.out.print("Ma sinh vien khong duoc de trong,moi nhap lai....!!!!");
			}
			}while(maSV.length()==0);
			
			//Kiem tra ma sinh vien co trong danh sach sinh vien chua
			int indexsv = CapNhatDanhSachSinhVien.indexOfmaSV(maSV);
			if(indexsv == -1) {
				System.out.println("Khong tim thay  ma sinh vien nay trong danh sach...!!!!");
				return;
			}
			//Nhap ma mon hoc muon them
			
			String maMH;
			do{
				System.out.print("--->Nhap ma mon hoc can them diem:");maMH = sc.nextLine();
			if(maMH.length()==0) {
				System.out.print("Ma mon hoc khong duoc de trong,moi nhap lai....!!!!");
			}
			}while(maMH.length()==0);
			
			
			//Kiem tra mon hoc co trong danh sach mon hoc khong ??
			int indexmh = CapNhatDanhSachMonHoc.indexOfMonHoc(maMH);
			if(indexmh == -1) {
				System.out.println("Khong tim thay ma mon hoc nay trong danh sach....!!!!");
				return ;
			}
			
			//Kiem tra sinh vien do da co diem o mon hoc do chua 
			int indexdiem = indexDiemOfBangDiem(maSV, maMH);
			if(indexdiem != -1 ) {
				System.out.println("Bang diem sinh vien nay da co , khong the them moi....!!!!");
				return;
			}
			
			//Nhap diem vao bang diem
			double diemSo;
			do {
				System.out.print("--->Nhap diem:");diemSo = Double.parseDouble(sc.nextLine());
			 if(diemSo<0||diemSo>10) {
				 System.out.println("Diem so phai >= 0 va <= 10,moi nhap lai....!!!!");
			 }
			}while(diemSo<0||diemSo>10);
			
			//Them bang diem vao list
			BangDiem bangdiem = new BangDiem(maSV, maMH, diemSo);
			list.add(bangdiem);
			System.out.println("Them bang diem moi thanh cong....!!!!");
		}
		
		private static void suaDiem() {
			System.out.println("\n\t\t.....Sua diem trong bang diem.....");
			//Nhap ma sinh vien
			String maSV;
			do{
				System.out.print("--->Nhap ma sinh vien can sua diem:");maSV = sc.nextLine();
			if(maSV.length()==0) {
				System.out.print("Ma sinh vien khong duoc de trong,moi nhap lai....!!!!");
			}
			}while(maSV.length()==0);
			
			//kiem tra ma sinh vien co trong danh sach hay khong ??
			int indexsv = CapNhatDanhSachSinhVien.indexOfmaSV(maSV);
			if(indexsv ==-1) {
				System.out.println("Khong tim thay ma sinh vien nay trong danh sach....!!!!");
				return;
			}
			
			//Nhap ma mon hoc
			String maMH;
			do{
				System.out.print("--->Nhap ma mon hoc can sua diem:");maMH = sc.nextLine();
			if(maMH.length()==0) {
				System.out.print("Ma mon hoc khong duoc de trong,moi nhap lai....!!!!");
			}
			}while(maMH.length()==0);
			
			
			//Kiem tra ma mon hoc co trong danh sach khong ??
			int indexmh = CapNhatDanhSachMonHoc.indexOfMonHoc(maMH);
			if(indexmh == -1) {
				System.out.println("Khong tim thay ma mon hoc nay trong danh sach....!!!!");
				return ;
			}
			
			//Kiem tra sinh vien da co diem mon do chua ??
			int index = indexDiemOfBangDiem(maSV, maMH);
			if(index == -1) {
				System.out.println("Khong ton tai bang diem , khong the sua ....!!!!");
				return;
			}
			
			//Sua diem 
			double diemSo;
			System.out.print("--->Nhap diem so moi:");diemSo = Double.parseDouble(sc.nextLine());
			list.get(index).setDiemSo(diemSo);
		}
		
		
		private static void xoaDiem() {
			
			System.out.println("\n\t\t.....Xoa diem trong bang diem....");
			//Nhap ma sinh vien can xoa diem
			
			String maSV;
			do{
				System.out.print("--->Nhap ma sinh vien can xoa diem:");maSV = sc.nextLine();
			if(maSV.length()==0) {
				System.out.print("Ma sinh vien khong duoc de trong,moi nhap lai....!!!!");
			}
			}while(maSV.length()==0);
			
			//Kiem tra ma sinh vien co  trong danh sach chua ???
			int indexsv = CapNhatDanhSachSinhVien.indexOfmaSV(maSV);
			if(indexsv ==-1) {
				System.out.println("Khong tim thay  ma sinh vien nay trong danh sach....!!!!");
				return;
			}
			
			//Nhap ma  mon hoc can xoa diem 
			String maMH;
			do{
				System.out.print("--->Nhap ma mon hoc can xoa diem:");maMH = sc.nextLine();
			if(maMH.length()==0) {
				System.out.print("Ma mon hoc khong duoc de trong,moi nhap lai....!!!!");
			}
			}while(maMH.length()==0);
			
			//Kiem tra mon hoc co trong danh sach chua
			int indexmh = CapNhatDanhSachMonHoc.indexOfMonHoc(maMH);
			if(indexmh == -1) {
				System.out.println("Khong tim thay ma mon hoc nay trong danh sach....!!!!");
				return ;
			}
			
			//Kiem tra co diem chua ??
			int index = indexDiemOfBangDiem(maSV, maMH);
			if(index == -1) {
				System.out.println("Khong ton tai bang diem , khong the xoa ....!!!!");
				return;
			}
			//xoa diem 
			list.remove(index);
		}
		
		
		//kiem tra xem sinh vien hoc mon hoc do co diem chua ??? tra ve vi tri
		
		public static int indexDiemOfBangDiem(String maSV, String maMH) {
			for(int i = 0; i < list.size() ; i++) {
				if(list.get(i).getMaSV().compareToIgnoreCase(maSV) == 0 && list.get(i).getMaMH().compareToIgnoreCase(maMH)==0) {
					return i;
				}
			}
			return -1;
		}
		//Kiem tra sinh vien co ten trong bang diem hay khong ??
		public static int checkDiemOfBangDiem(String maSV) {
			for(int i = 0; i < list.size() ; i++) {
				if(list.get(i).getMaSV().compareToIgnoreCase(maSV) == 0 ) {
					return i;
				}
			}
			return -1;
		}
		//kiem tra xem mon hoc nay co trong bang diem chua??? tra ve vi tri
		
		public static boolean checkMHOfBangDiem(String maMH) {
			for(int i = 0; i < list.size() ; i++) {
				if(list.get(i).getMaMH().compareToIgnoreCase(maMH) == 0) {
					return true;
				}
			}
			return false;
		}
		
		
		//Kiem tra xem sinh vien nay co trong bang diem chua ?? tra ve vi tri 
		
		public static boolean checkSVOfBangDiem(String maSV) {
			for(int i = 0; i < list.size() ; i ++) {
				if(list.get(i).getMaSV().compareToIgnoreCase(maSV)==0) {
					return true;
				}
			}
			return false;
		}
		
		 //Hien thi bang diem cua sinh vien khi biet ma sinh vien 
		public static void hienThiBangDiemSV(String maSV) {
			double diemTK = 0;
			int dem = 0;
			for( int i = 0 ; i< list.size() ; i++){
				if(list.get(i).getMaSV().compareToIgnoreCase(maSV) == 0){
					System.out.printf("   %-12s %-30s %-8s  %n","Ma Mon Hoc","Ten Mon Hoc","Diem So");
					list.get(i).display();
					diemTK += list.get(i).getDiemSo();
					dem ++;
				}
			}		
			if(dem>0){
				System.out.printf("\t\t\tDiem tong ket la:%.2f",(double)diemTK/dem);
			}	
			System.out.println();
		}
		public static void hienThiBangDiem(String maMH) {
			double dtbchung = 0;
			int demmon = 0;
			for(int i  = 0 ; i < list.size() ; i++) {
				if(list.get(i).getMaMH().compareToIgnoreCase(maMH) == 0) {
				dtbchung += list.get(i).getDiemSo();
				demmon++;
				}
			}
			System.out.println();
			System.out.printf("\t\t\tDiem trung binh chung cua mon la:%.2f",(double)dtbchung/demmon);
			System.out.println();
			System.out.println();
		}
		public static void hienThiSinhVienMon(String maMH) {
			for(int i = 0 ;i<list.size(); i++) {
				if(list.get(i).getMaMH().compareToIgnoreCase(maMH) == 0) {
				CapNhatDanhSachSinhVien.dsSinhVien(list.get(i).getMaSV());
				System.out.println();
				System.out.print("\t\tDiem So cua mon hoc:");
				list.get(i).display1();
				System.out.println();
				}
				
			}
		}
}
