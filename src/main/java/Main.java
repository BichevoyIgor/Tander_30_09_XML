import javax.xml.parsers.ParserConfigurationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ParserConfigurationException {
        InitDB db = new InitDB("localhost", "root", "***");
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement("select id_art,name,code,username,guid from whs.article;");
        ResultSet resultSet = statement.executeQuery();

        CreateXML createXML = new CreateXML();
        List<Article> listResult = new ArrayList<>();
        while (resultSet.next()) {
            int id_art = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String code = resultSet.getString(3);
            String userName = resultSet.getString(4);
            String guid = resultSet.getString(5);
            listResult.add(new Article(id_art, name, code, userName, guid));
        }
        System.out.println(listResult);
        createXML.xmlWithAttribute(listResult);
    }
}
