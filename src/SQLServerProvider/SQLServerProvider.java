
package SQLServerProvider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ACER
 */
public class SQLServerProvider {
    private Connection conn;
    private static SQLServerProvider instance;

    public static SQLServerProvider getInstance() {
        if (instance == null) {
            instance = new SQLServerProvider();
        }
        return instance;
    }

    public SQLServerProvider() {

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void open()
    {
            try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://LAPTOP-85VQT4K5\\SQLEXPRESS05:1433;databaseName=QLNS;"
                                    + "encrypt=false;trustServerCertificate=false;"
                                + "hostNameInCertificate=LAPTOP-85VQT4K5\\SQLEXPRESS05";

                    String user = "sa";
                    String passwword ="123";

                    conn = DriverManager.getConnection(url,user,passwword);
                    System.out.println("Kết nối thành công");
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public void close()
    {
        try {
                conn.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql)
    {
        ResultSet rs = null;
        try {
                Statement sm = conn.createStatement();
                rs = sm.executeQuery(sql);
        } catch (Exception e) {
                e.printStackTrace();
        }

        return rs;
    }

    public int executeUpdate(String sql)
    {
        int n = -1;
        try {
                Statement sm = conn.createStatement();
                n = sm.executeUpdate(sql);
        } catch (Exception e) {
                e.printStackTrace();
        }
        return n;
    }
    public CallableStatement prepareCall(String sql) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cs;
    }

    public PreparedStatement prepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
                ps = conn.prepareStatement(sql);
        } catch (Exception e) {
                e.printStackTrace();
        }
        return ps;
    }
}

