package capnhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class CapNhatDanhSachMonHoc {
	
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<MonHoc> list = new ArrayList<MonHoc>();
	
	public static void capNhat() {
		int chon ;
		do {
			System.out.println("\n\t\t\t_____________________________________");
			System.out.println("\n\t\t\t----->CAP NHAT DANH SACH MON HOC<----");
			System.out.println("\nNhap so de su dung cac chuc nang sau:");
			System.out.println("\tNhan phim 1: Them mon hoc moi");
			System.out.println("\tNhan phim 2: Sua thong tin mon hoc");
			System.out.println("\tNhan phim 3: Xoa thong tin mon hoc");
			System.out.println("\tNhan phim 4: Hien thi danh sach mon hoc");
			System.out.println("\tNhan phim 0: Quay lai");
			System.out.print("--->Nhap lua chon cua ban:");
			 chon = Integer.parseInt(sc.nextLine());
			 switch(chon) {
			 case 1:themMonHoc();break;
			 case 2:suaTTMonHoc();break;
			 case 3:xoaTTMonHoc();break;
			 case 4:sapXepdsMH();;break;
			 case 0:return;
			default:System.out.println("Lua chon khong hop le....!!!!");
			 }
		}
		while(true);
	}
	private static void themMonHoc() {
		System.out.println("\n\t\t.....Them moi mon hoc.....");
		//Nhap ma mon hoc
		String maMH;
		do {
			System.out.print("--->Nhap ma mon hoc can them moi : ");maMH = sc.nextLine();
			if(maMH.length()==0) {
				System.out.println("Ma mon hoc khong duoc de trong,moi nhap lai....!!!!");
			}
		}while(maMH.length()==0);
		
		//Kiem tra co trong danh sach hay chua ??
		if(indexOfMonHoc(maMH) != -1) {
			System.out.println("Mon hoc da co trong danh sach , khong the them moi....!!!!");
			return;
		}
		
		//Nhap ten mon hoc
		String tenMH ;
		do {
			System.out.print("--->Nhap ten mon hoc : ");
			tenMH = sc.nextLine();
			if(tenMH.length() == 0) {
				System.out.println("Ten mon hoc khong duoc de trong, moi nhap lai....!!!!");
			}
		}while(tenMH.length() == 0);
		
		//Nhap he so mon hoc
		float heSoMH;
		do {
			System.out.print("--->Nhap he so mon hoc: ");
			heSoMH = Float.parseFloat(sc.nextLine());
			if(heSoMH <= 0) {
				System.out.println("He so mon hoc phai lon hon 0,moi nhap lai....!!!!");
			}
		}while(heSoMH <=0);
		
		//Them mon hoc moi vao list
		MonHoc mh = new MonHoc(maMH, tenMH, heSoMH);
		list.add(mh);
		System.out.println("Them moi mon hoc thanh cong....!!!!");
	}
	private static void suaTTMonHoc() {
		System.out.println("\n\t\t.....Sua  thong tin mon hoc.....");
		
		//Nhap ma mon hoc can sua
		String maMH;
		do {
			System.out.print("--->Nhap ma mon hoc can sua:");maMH = sc.nextLine();
			if(maMH.length()==0) {
				System.out.println("Ma mon hoc khong duoc de trong,moi nhap lai....!!!!");
			}
		}while(maMH.length()==0);
		
		//kiem tra xem ma mon hoc co trong danh sach hay chua ??
		int index =indexOfMonHoc(maMH);
		if(index == -1) {
			System.out.println("Mon hoc chua co trong danh sach , khong the sua...!");
			return;
		}
		
		do {
			System.out.println("\nChon thong tin mon hoc de sua:");
			System.out.println("\tNhan phim 1: De sua ten mon hoc");
			System.out.println("\tNhan phim 2: De sua he so mon hoc");
			System.out.println("\tNhan phim 0: Luu thong tin");
			int chon ;
			System.out.print("--->Nhap lua chon cua ban:");
			chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1:
				//Nhap ten mon hoc thay the
				String tenMH;
				do {
					System.out.print("--->Nhap ten mon hoc thay the:");tenMH = sc.nextLine();
				
				if(tenMH.length() == 0)
					
					System.out.println("Ten mon hoc khong duoc de trong, yeu cau nhap lai....!!!");
				}while(tenMH.length() == 0);
				
				//sua trong list
				list.get(index).setTenMH(tenMH);
				break;
			case 2:
				
				//Nhap he so mon hoc thay the
				float heSoMH;
				do {
					System.out.print("--->Nhap he so mon hoc thay the:");
					heSoMH = Float.parseFloat(sc.nextLine());
					if(heSoMH <=0)
						System.out.println("He so mon hoc la so duong , nhap lai....!!");

				}while(heSoMH <=0);
				
				//Sua trong list
				list.get(index).setHeSoMH(heSoMH);
				break;
			case 0:return;
			default:System.out.println("Ban nhap sai , vui long nhap lai....!!!");
			}
		}
		while(true);
	}
	private static void xoaTTMonHoc() {
		System.out.println("\n\t\t.....Chuc nang xoa mon hoc.....");
		//Nhap ma mon hoc muon xoa
		String maMH;
		do {
			System.out.print("--->Nhap ma mon hoc can xoa:") ; maMH = sc.nextLine();
			if(maMH.length() == 0) {
				System.out.println("Ma mon hoc khong duoc de trong,moi nhap lai....!!!!");
			}
		}while(maMH.length()==0);
		//Kiem tra mon hoc co trong danh sach mo hoc khonng ??
		int index = indexOfMonHoc(maMH);
		if(index == -1) {
			System.out.print("Mon hoc khong co trong danh sach,khong the xoa....!!!!");
			return;
		}
		//Kiem tra mon hoc co sinh vien hoc chua ??
		boolean check = CapNhatBangDiem.checkMHOfBangDiem(maMH);
		if(check == true ) {
			System.out.println("Da co sinh vien hoc, khong the xoa....!!");
			return;
		}
		//xoa mon hoc trong list
		list.remove(index);
	}
	private static void sapXepdsMH(){
		Collections.sort(list,new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1,MonHoc o2) {
				return o1.getMaMH().compareToIgnoreCase(o2.getMaMH());
			}
		});
		System.out.printf("   %-12s %-30s %-8s %n","Ma Mon Hoc","Ten Mon Hoc","He So Mon");
		for(MonHoc mh : list) {
			mh.hienThi();
		}
	}
	
	public static int indexOfMonHoc(String maMH){
		for(int i = 0; i< list.size() ; i++ ){
			if(list.get(i).getMaMH().compareToIgnoreCase(maMH) == 0){
				return i;
			}
		}
		return -1;
	}
	
	public static void hienThiMonHoc(){
		
		 for(int i = 0 ; i < list.size() ; i ++ ) {
			 System.out.println("\n\t\tTHONG TIN MON HOC THU "+(i+1));
			 System.out.println();
			 System.out.printf("   %-12s %-30s %n","Ma Mon Hoc","Ten Mon Hoc");
			 	list.get(i).display();
			 	if(CapNhatBangDiem.checkMHOfBangDiem(list.get(i).getMaMH()) == true ) {
			 		CapNhatBangDiem.hienThiBangDiem(list.get(i).getMaMH());
			 	}
			 	else {
			 		System.out.println("Mon hoc chua co bang diem....!!!1");
			 		return;
			 	}
			 //Hien thi danh sach sinh vien 
			 	System.out.println("**Danh sach cac sinh vien da hoc mon :"+list.get(i).getTenMH());
			 	System.out.println();
			 		CapNhatBangDiem.hienThiSinhVienMon(list.get(i).getMaMH()); 	
		 }
	}
	public static void timKiemhienThiMonHoc(String maMH){
		
		 for(int i = 0 ; i < list.size() ; i ++ ) {
			 if(list.get(i).getMaMH().compareToIgnoreCase(maMH) == 0) {
				 System.out.println("\n\t\t*THONG TIN MON THU "+(i+1)+"*");
				 System.out.println();
				 System.out.printf("   %-12s %-30s %n","Ma Mon Hoc","Ten Mon Hoc");
			 	list.get(i).display();
			 	if(CapNhatBangDiem.checkMHOfBangDiem(list.get(i).getMaMH()) == true ) {
			 		CapNhatBangDiem.hienThiBangDiem(list.get(i).getMaMH());
			 	}
			 	else {
			 		System.out.println("Mon hoc chua co bang diem....!!!!");
			 		return;
			 	}
			 	//Hien thi danh sach sinh vien 
			 	System.out.println();
			 	System.out.println("\n**Danh sach cac sinh vien da hoc mon :"+list.get(i).getTenMH());
			 	System.out.println();
			 	CapNhatBangDiem.hienThiSinhVienMon(list.get(i).getMaMH());
			 }	
		 }
	}
	public static MonHoc monhoc(String maMH) {
		for(MonHoc mh :list) {
			if(mh.getMaMH().compareToIgnoreCase(maMH) == 0) {
				return mh;
			}
		}
		return null;
	}
}
