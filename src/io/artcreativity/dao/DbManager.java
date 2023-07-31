package io.artcreativity.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DbManager {

    private static DbManager dbManager;

    private Connection connection;

    private DbManager() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/insti","root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DbManager getInstance() {
        if(dbManager==null) {
            dbManager = new DbManager();
        }
        return dbManager;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void ajouterPersonne(Personne personne) {

    }

    public List<Personne> getPersonnes() {
        List<Personne> personnes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM personnes;");
            while (resultSet.next()) {
                Personne personne = new Personne();
                // TODO: 28/03/2023


                personnes.add(personne);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personnes;
    }

    public void close() {
        if(connection!=null) {
            try {
                connection.close();
                dbManager = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
