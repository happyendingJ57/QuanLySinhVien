package capnhat;

public class BangDiem  {
	private String maSV;
	private String maMH;
	private double diemSo;
	public BangDiem() {
		super();
	}
	public void display1() {
		System.out.printf("   %-8.2f %n",diemSo);
	}
	
	public void display() {
		capnhat.MonHoc mh = CapNhatDanhSachMonHoc.monhoc(maMH);
		System.out.printf("   %-12s %-30s %-8.2f %n",maMH,mh.getTenMH(),diemSo);
	}
	public void hienThi() {
		System.out.printf("   %-12s %-12s %-8.2f %n",maSV,maMH,diemSo);
	}
	public BangDiem(String maSV, String maMH, double diemSo) {
		super();
		this.maSV = maSV;
		this.maMH = maMH;
		this.diemSo = diemSo;
	}
	public String getMaSV() {
		return maSV;
	}
	public String getMaMH() {
		return maMH;
	}
	public double getDiemSo() {
		return diemSo;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public void setDiemSo(double diemSo) {
		this.diemSo = diemSo;
	}
	
}
