package rentServer.user;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	private UserDao() {
		setConnection();
	}
	

	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private void setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/board_server_db";		
			String user = "root";		
			String password = "root";		
			
			this.conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("[DB 연동 성공]");
		} catch (Exception e) {
			System.err.println("[DB 연동 실패]");
			e.printStackTrace();
		}
	}
	
	public List<UserResponseDto> findUserAll() {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();
		
		try {

			String sql = "SELECT id, email, name, birth, gender, country, telecom, phone, agree FROM users";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String telecom = rs.getString(6);
				String phone = rs.getString(7);
				
				UserResponseDto user = new UserResponseDto(id, email, name, birth, gender,  telecom, phone);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;
		
		try {
			String sql = "SELECT id, email, name, birth, gender, country, telecom, phone, agree FROM users WHERE id=? AND password=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String telecom = rs.getString(6);
				String phone = rs.getString(7);
				
				user = new UserResponseDto(id, email, name, birth, gender,  telecom, phone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserResponseDto createUser(UserRequestDto userDto) {

		try {
			String sql = "INSERT INTO users(id, password, email, name, birth, gender, telecom, phone) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			
			String email = userDto.getEmail().equals("") ? null : userDto.getEmail();
			pstmt.setString(3, email);
			
			pstmt.setString(4, userDto.getName());
			pstmt.setString(5, userDto.getBirth());
			pstmt.setString(6, userDto.getGender());
			pstmt.setString(7, userDto.getTelecom());
			pstmt.setString(8, userDto.getPhone());

			
			pstmt.execute();
			
			return findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public UserResponseDto updateUserPassword(UserRequestDto userDto, String newPassword) {
		UserResponseDto user = null;
		
		if(newPassword == null || newPassword.equals("")) {
			return user;
		}
		
		try {
			String sql = "UPDATE users SET password=? WHERE id=? AND password=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, userDto.getId());
			pstmt.setString(3, userDto.getPassword());
			
			pstmt.execute();
			
			User userVo = findUserById(userDto.getId());
			user = new UserResponseDto(userVo);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserResponseDto updateUserEmail(UserRequestDto userDto) {
		UserResponseDto user = null;
		try {
			String sql = "UPDATE users SET email=? WHERE id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getEmail());
			pstmt.setString(2, userDto.getId());
			pstmt.setString(3, userDto.getPassword());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserResponseDto updateUserPhone(UserRequestDto userDto) {
		UserResponseDto user = null;
		try {
			String sql = "UPDATE users SET telecom=?, phone=? WHERE id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getTelecom());
			pstmt.setString(2, userDto.getPhone());
			pstmt.setString(3, userDto.getId());
			pstmt.setString(4, userDto.getPassword());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean deleteUser(UserRequestDto userDto) {
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return false;
		
		try {
			String sql = "DELETE FROM users WHERE id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	private User findUserById(String id) {
		User user = null;
		
		try {
			String sql = "SELECT id, email, name, birth, gender, telecom, phone,, reg_date, mod_date FROM users WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String telecom = rs.getString(7);
				String phone = rs.getString(8);
				Timestamp regDate = rs.getTimestamp(10);
				Timestamp modDate = rs.getTimestamp(11);
				
				user = new User(id, email, name, birth, gender, telecom, phone, regDate, modDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}