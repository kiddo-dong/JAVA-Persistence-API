import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDAO {

    public Member find(String memberId) throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3033/members", "root", "password");

        String sql = "SELECT * FROM members WHERE memberID = ?";
        // statement는 쿼리를 바로 실행하며 파라미터 바인딩이 아닌 동적 할당으로 SQLi 공격에 취약
        Member member = new Member();

        return member;
    }
}
