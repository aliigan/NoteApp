package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/iskur";
    private final String username = "root";
    private final String password = "";

    //Connection class
    private Connection conn = null;

    public DB(){

        this.url = this.url;
    }

    public DB(String dbName){

        this.url = this.url + dbName;
    }

    public Connection connect(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Success");
        }catch (Exception ex){
            System.err.println("Connection error: " + ex);
        }
        return conn;
    }

    public void close(){
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        }catch (Exception ex){
            System.err.println("close error: " + ex);
        }
    }
}
