package DAO;

import java.util.List;

import US.User;

public interface UserDAO {
	public User login(String email,String password);
	public List<User> getGiangVienSinhVienList(int MaHP);
	public boolean deleteSV(int MaHP);
}
