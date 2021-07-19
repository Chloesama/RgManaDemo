package test1;

import java.sql.*;

/**
 * 直接使代码进行MYSQL的连接
 * 自己编写SQL查询数据
 */
public class MySqlJdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/manatest?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String userName = "root";
        String password = "1234";
        //3.连接成功,数据对象
        Connection connection = DriverManager.getConnection(url, userName, password);
        //4.执行SQL对象
//        Statement statement = connection.createStatement();

        String sql = "select * from student where id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,1);

        //5.执行SQL的对象去执行SQL,查看返回结果
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("age=" + resultSet.getObject("age"));
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }

}
