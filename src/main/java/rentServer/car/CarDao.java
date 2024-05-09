package rentServer.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentServer.user.UserDao;
import rentServer.user.UserResponseDto;

public class CarDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private CarDao() {
		setConnection();
	}

	private static CarDao instance = new CarDao();

	public static CarDao getInstance() {
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

	public List<CarResponseDto> findUserAll() {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		try {

			String sql = "SELECT code, name, brand, type, fuel, seater, price FROM cars";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString(2);
				String brand = rs.getString(3);
				String type = rs.getString(4);
				String fuel = rs.getString(5);
				String seater = rs.getString(6);
				String price = rs.getString(7);

				CarResponseDto user = new CarResponseDto(code, name, brand, type, fuel, seater, price);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
