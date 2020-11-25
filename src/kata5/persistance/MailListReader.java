package kata5.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;

public class MailListReader {
        public static List<Mail> read(String url, String sql) throws SQLException, ClassNotFoundException {
        List<Mail> list = new ArrayList<>();
        Class.forName(url);
        Connection connection = DriverManager.getConnection("jdbc:sqlite:data/prueba.db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String email = resultSet.getString("email");
            if (Mail.isMail(email)){
                list.add(new Mail(email));
            }
        }
        statement.close();
        return list;
    }
}
