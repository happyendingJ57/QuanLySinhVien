package capnhat;

public class MonHoc {
	private String maMH;
	private String tenMH;
	private float heSoMH;
	public MonHoc() {
		super();
	}
	public void display() {
		System.out.printf("   %-12s %-30s %n",maMH,tenMH);
	}
	public void hienThi() {
		System.out.printf("   %-12s %-30s %-8.1f %n",maMH,tenMH,heSoMH);
	}
	public MonHoc(String maMH, String tenMH, float heSoMH) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSoMH = heSoMH;
	}
	public String getMaMH() {
		return maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public float getHeSoMH() {
		return heSoMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public void setHeSoMH(float heSoMH) {
		this.heSoMH = heSoMH;
	}
	
	
}
