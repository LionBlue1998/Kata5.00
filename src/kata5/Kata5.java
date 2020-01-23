package kata5;

import java.sql.SQLException;

public class Kata5 {

   public static void main(String[] args) throws SQLException {
       String URL = new String("jdbc:sqlite:C:\\Users\\LionBlue98\\Documents\\NetBeansProjects\\DB_SQLite\\Practica5.db");
       DataBase database = new DataBase(URL);
       
       database.open();
       People people = new People("Fefo","Hernandez","Taller");
       database.insertPEOPLE(people);
       
       System.out.println("* * * * *");
       
       database.selectPEOPLE();
       
       database.close();
       
       
       
   }
    
}
