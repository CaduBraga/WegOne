package com.wegone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://switchback.proxy.rlwy.net:35334/railway";
    private static final String USUARIO = "root";
    private static final String SENHA = "IMkPGvjwAGUxAGJmeVBLzgqIGqNZtgkD";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}