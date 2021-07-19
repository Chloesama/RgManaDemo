package test1;

import java.sql.*;

/**
 * 事务的测试
 */
public class MsqlJdbcTransactionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/manatest?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String userName = "root";
        String password = "1234";

        Connection connection = null;
        PreparedStatement st = null;
        //3.连接成功,数据对象

        try {
            connection = DriverManager.getConnection(url, userName, password);
            // 关闭数据库的自动提交

            connection.setAutoCommit(false); // 开启事务

            String sql1 = "update student set age = age - 1 where id = 1";
            String sql2 = "update student set age = age + 1 where id = 2";

            st = connection.prepareStatement(sql1);
            st.executeUpdate();

            // 模拟回滚!
//            int a = 1 / 0;

            st = connection.prepareStatement(sql2);
            st.executeUpdate();

            connection.commit();

            System.out.println("操作成功!");
        } catch (Exception e) {
            // 回滚
            System.out.println("回滚!");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            //6.释放连接
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
