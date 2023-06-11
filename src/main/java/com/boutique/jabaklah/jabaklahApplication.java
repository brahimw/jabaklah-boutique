
package com.boutique.jabaklah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;


@SpringBootApplication
public class jabaklahApplication {

    public static void main(String[] args) {
        SpringApplication.run(jabaklahApplication.class, args);

        String sourceDbUrl = "jdbc:mysql://localhost:3307/ensapay";
        String sourceDbUser = "root";
        String sourceDbPassword = "root";

        String destinationDbUrl = "jdbc:mysql://localhost:3307/online_shopping_db";
        String destinationDbUser = "root";
        String destinationDbPassword = "root";

        Connection sourceConnection = null;
        Connection destinationConnection = null;

        try {
            // Connect to the source database
            sourceConnection = DriverManager.getConnection(sourceDbUrl, sourceDbUser, sourceDbPassword);

            // Connect to the destination database
            destinationConnection = DriverManager.getConnection(destinationDbUrl, destinationDbUser, destinationDbPassword);

            // Retrieve data from the source table
            String selectQuery = "SELECT email, password, prenom, nom, role FROM user_app";
            Statement selectStatement = sourceConnection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

            // Insert data into the destination table
            String insertQuery = "INSERT INTO user_detail (email, password, first_name, last_name, role) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = destinationConnection.prepareStatement(insertQuery);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String role = resultSet.getString("role");

                insertStatement.setString(1, email);
                insertStatement.setString(2, password);
                insertStatement.setString(3, firstName);
                insertStatement.setString(4, lastName);
                insertStatement.setString(5, role);


                insertStatement.executeUpdate();
            }

            System.out.println("La migration des données s'est terminée avec succès!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connections
            if (sourceConnection != null) {
                try {
                    sourceConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (destinationConnection != null) {
                try {
                    destinationConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
