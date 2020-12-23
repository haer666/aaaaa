package dao;

import vo.Staff;
import vo.User;

public interface IStaffDAO {
	public User getByStaffId(String staffId);

	public void updateStaff(Staff staff);

	public void deleteStaff(String staffId);

	public void insertStaff(Staff staff);
}
