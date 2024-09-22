/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cashcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class CashControl {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/cash_control";
        String user = "postgres"; // Definir el usuario
        String password = "admin"; // Definir la contraseña

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) { // Asegúrate de que la tabla se llama "users"
             
            while (rs.next()) {
                String username = rs.getString("username"); 
                int userid = rs.getInt("userid");
                System.out.println(userid + " : " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }
}
