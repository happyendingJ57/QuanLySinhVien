package capnhat;

public class SinhVien {
		private String maSV;
		private String hoDem;
		private String ten;
		private String namSinh;
		private String gioiTinh;
		public void display() {
			System.out.printf("   %-15s %-20s %-10s %n",maSV,hoDem,ten);
		}
		public void hienThi() {
			System.out.printf("   %-15s %-20s %-10s %-12s %-10s %n",maSV,hoDem,ten,namSinh,gioiTinh);
		}
		public SinhVien() {
			super();
		}
		public SinhVien(String maSV, String hoDem, String ten, String namSinh, String gioiTinh) {
			super();
			this.maSV = maSV;
			this.hoDem = hoDem;
			this.ten = ten;
			this.namSinh = namSinh;
			this.gioiTinh = gioiTinh;
		}
		public String getMaSV() {
			return maSV;
		}
		public String getHoDem() {
			return hoDem;
		}
		public String getTen() {
			return ten;
		}
		public String getNamSinh() {
			return namSinh;
		}
		public String getGioiTinh() {
			return gioiTinh;
		}
		public void setMaSV(String maSV) {
			this.maSV = maSV;
		}
		public void setHoDem(String hoDem) {
			this.hoDem = hoDem;
		}
		public void setTen(String ten) {
			this.ten = ten;
		}
		public void setNamSinh(String namSinh) {
			this.namSinh = namSinh;
		}
		public void setGioiTinh(String gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
		
}
