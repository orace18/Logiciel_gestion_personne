package io.artcreativity;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLTest {

    public static void main(String[] args) {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/insti","root","");
            Statement statement = connection.createStatement();
            // Recuperation des donnees dans une table
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM personnes;");
            while(resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print(", ");
                System.out.print("Nom: " + resultSet.getString("nom"));
                System.out.print(", ");
                System.out.print("Prenoms: " + resultSet.getString("prenoms"));
                System.out.print(", ");
                System.out.print("adresse: " + resultSet.getString("adresse"));
                System.out.print(", ");
                System.out.print("Tel: " + resultSet.getString("tel"));
                System.out.print(", ");
                System.out.print("age: " + resultSet.getInt("age"));
                System.out.println();
            }
            resultSet.close();

            // Insertion dans une table
            int line = statement
                    .executeUpdate("INSERT INTO personnes values(null, 'TOSSOU', 'Johnson', '', '', 22)");
            System.out.println(line);
            statement.close();

            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO personnes values(null, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, "GBEVOU");
            preparedStatement.setString(2, "Alexice");
            preparedStatement.setString(3, "Cotonou");
            preparedStatement.setString(4, "");
            preparedStatement.setInt(5, 24);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "SIGBO");
            preparedStatement.setString(2, "Codjo");
            preparedStatement.setString(3, "Cotonou");
            preparedStatement.setString(4, "90909090");
            preparedStatement.setInt(5, 25);
            preparedStatement.addBatch();
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}
