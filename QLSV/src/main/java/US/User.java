package US;

public class User {
	private int MaHP;
	private int id; 
	private String TenGV;
	private String TenHP;
	private String email;
	private String password;
	private String TenSV;
	
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaHP() {
		return MaHP;
	}
	public void setMaHP(int maHP) {
		this.MaHP = maHP;
	}
	public String getTenGV() {
		return TenGV;
	}
	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}
	public String getTenHP() {
		return TenHP;
	}
	public void setTenHP(String tenHP) {
		TenHP = tenHP;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [MaHP=" + MaHP + ", TenGV=" + TenGV + ", TenHP=" + TenHP + ", email=" + email
				+ ", password=" + password + ", TenSV=" + TenSV + ", id=" + id + "]";
	}
	
	
}
