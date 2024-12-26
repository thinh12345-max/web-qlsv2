package US;

public class SinhVien {
	private int id;
	private String MaHP;
	private String TenSV;
	
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaHP() {
		return MaHP;
	}
	public void setMaHP(String maHP) {
		MaHP = maHP;
	}
	public String getTenSV() {
		return TenSV;
	}
	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}
	
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", MaHP=" + MaHP + ", TenSV=" + TenSV + "]";
	}

	
}
