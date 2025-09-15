package com.example.demo.databases;
import java.sql.*;

public class DBUserResults {
    private static final String DB_URL = "jdbc:sqlite:usersresultbase.db"; //URL который передается в метод

    public static Connection getConnection() throws SQLException { //метод открывает соединение с базой данных по указанному URL
        return DriverManager.getConnection(DB_URL);
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS notes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "content TEXT)";

        try (Connection conn = getConnection();
        Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertNote(String title, String content) {
        String sql = "INSERT INTO notes(title, content) VALUES(?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
