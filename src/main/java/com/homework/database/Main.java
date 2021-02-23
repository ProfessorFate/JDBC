package com.homework.database;
import java.sql.*;


public class Main {
    static final String JDBC_Driver ="com.mysql.cj.jdbc.Driver";
    static final String DataBase_URL="jdbc:mysql://localhost:3306/mydbtest";
    static final String User="root";
    static final String Password="Bnm765iop765";

    public static void main(String[] args)  {

        try {
            Class.forName(JDBC_Driver);
            System.out.println("Драйвер подключен");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не подключен");
        }

       try {
               Connection connection=  DriverManager.getConnection(DataBase_URL,User,Password);
        Statement statement= connection.createStatement();
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS Book (id MEDIUMINT NOT NULL, " +
                   "AutorName CHAR(30) NOT NULL, PRIMARY KEY (id), AutorLastName CHAR(30) NOT NULL, " +
                   "BookName CHAR (30) NOT NULL);");

           statement.executeUpdate("insert into book (id,AutorName,AutorLastName, BookName)" +
                   " values('1','Лев','Толстой','Война и мир')");

           statement.executeUpdate("insert into book (id,AutorName,AutorLastName, BookName)" +
                   " values('2','Николай','Гоголь','Ревизор')");

           statement.executeUpdate("insert into book (id,AutorName,AutorLastName, BookName)" +
                   " values('3','Виктор','Гюго','Отверженные')");

           statement.executeUpdate(" update book set  AutorName='Федор',AutorLastName='Достоевский'," +
                   "BookName='Бесы' where id=1");

           statement.executeUpdate("delete from book where id=2");

           ResultSet resultSet= statement.executeQuery("SELECT * FROM Book ");
           while (resultSet.next()) {
               System.out.println(resultSet.getInt("id"));
               System.out.println(resultSet.getString("AutorName"));
               System.out.println(resultSet.getString("AutorLastName"));
               System.out.println(resultSet.getString("BookName"));
               System.out.println("------------");
           }
           resultSet.close();
           statement.close();
           connection.close();

       }    catch(SQLException e){
                   e.printStackTrace();
       }

       }
}


