package cn.rzpt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private String DBDriver = "com.mysql.jdbc.Driver";
    private String DBUrl = "jdbc:mysql:///ssm_zhangxiaonuo";
    private String DBUsername = "root";
    private String DBPassword = "root";

    
}
