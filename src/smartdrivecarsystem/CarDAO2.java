/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartdrivecarsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
  
/**
 *
 * @author azadd
 */
public class CarDAO2 {

    private static final String DB_URL= "jdbc:mysql://localhost:3306/smartdrive_db";
    private static final String DB_USER= "root";
     private static final String DB_PASSWORD = "";
    
     public void insertCar(Car car) {

    String sql = "INSERT INTO cars (plate,brand, model, year, price) VALUES (?, ?, ?, ?,?)";

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, car.getPlate());
        stmt.setString(2, car.getBrand());
        stmt.setString(3, car.getModel());
        stmt.setInt(4, car.getYear());
        stmt.setDouble(5, car.getPrice());

        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
