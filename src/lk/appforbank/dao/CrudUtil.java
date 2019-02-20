package lk.appforbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.appforbank.db.DBConnection;




public class CrudUtil {

    public static PreparedStatement getPreparedStatement(String sql, Object... params) throws Exception {
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
        return pstm;
    }

    public static int executeUpdate(String sql, Object... params) throws Exception {
        return getPreparedStatement(sql, params).executeUpdate();
    }

    public static ResultSet executeQuery(String sql, Object... params) throws Exception {
        return getPreparedStatement(sql, params).executeQuery();
    }
}
