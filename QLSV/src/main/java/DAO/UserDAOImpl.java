package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import US.SinhVien;
import US.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public User login(String email, String password) {
	    User us = null;

	    try {
	        String sql = "SELECT * FROM giangvien WHERE email=? and password=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            us = new User();
	            us.setMaHP(rs.getInt("MaHP"));  
	            us.setTenGV(rs.getString("TenGV"));
	            us.setTenHP(rs.getString("TenHP"));
	            us.setEmail(rs.getString("email"));
	            us.setPassword(rs.getString("password"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return us;
	}

	
	public List<User> getGiangVienSinhVienList(int maHP) {
	    List<User> list = new ArrayList<>();
	    try {
	        String sql = "SELECT g.MaHP, g.TenGV, g.TenHP, g.email, g.password, s.TenSV "
	                   + "FROM giangvien g "
	                   + "JOIN sinhvien s ON g.MaHP = s.MaHP "
	                   + "WHERE g.MaHP = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, maHP);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            User us = new User();
	            us.setMaHP(rs.getInt("MaHP"));
	            us.setTenGV(rs.getString("TenGV"));
	            us.setTenHP(rs.getString("TenHP"));
	            us.setEmail(rs.getString("email"));
	            us.setPassword(rs.getString("password"));
	            us.setTenSV(rs.getString("TenSV"));
	            list.add(us);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	public boolean deleteSV(int MaHP) {
	    boolean f = false;
	    try {
	        String sql = "DELETE FROM sinhvien WHERE MaHP = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, MaHP);
	        int i = ps.executeUpdate();
	        if (i == 1) {
	            f = true; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

}
