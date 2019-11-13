package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory.Result;

class DataBase {
    private String URL;
    private Connection connection = null;
    
    DataBase(String URL) {
        this.URL = URL;
    }

    void open() throws SQLException {
        try{
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Base de Datos abierta...");
        }catch(SQLException sqlException){
            System.out.println("ERROR DataBase::open (SQLException) " 
                    + sqlException.getLocalizedMessage());
        }
    }

    void close() throws SQLException{
        try{
            if(this.connection != null){
                this.connection.close();
                System.out.println("Base de datos cerrada.");
            }
        }catch(SQLException sqlException){
            System.out.println("ERROR DataBase::close (SQLException) " 
                    + sqlException.getLocalizedMessage());
        }
    }

    void selectPEOPLE() throws SQLException{
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t NOMBRE \t APELLIDOS \t DEPARTAMENTO");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + " \t " +
                                   resultset.getString("NOMBRE") + " \t " +
                                   resultset.getString("APELLIDOS") + " \t " +
                                   resultset.getString("DEPARTAMENTO") + " \t ");
            }
        }catch(SQLException sqlException){
            System.out.println("ERROR DataBase::select (SQLException) " 
                    + sqlException.getLocalizedMessage());
        }
    }
    
    void insertPEOPLE(People people){
        String SQL = "INSERT INTO PEOPLE(NOMBRE, APELLIDOS, DEPARTAMENTO) VALUES(?,?,?)";
        try{
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1,people.getName());
            preparedstatement.setString(2,people.getApellido());
            preparedstatement.setString(3,people.getDepartamento());
            preparedstatement.executeUpdate();
        }catch(SQLException sqlException){
            System.out.println("ERROR DataBase::insert (SQLException) " 
                    + sqlException.getLocalizedMessage());
        }
    }
}
