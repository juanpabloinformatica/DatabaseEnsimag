package db;
import java.sql.Connection;
import java.sql.DriverManager;

import org.w3c.dom.UserDataHandler;

class ConnectDatabase(){
    private Connection connection;
    // private Driver connection;
    public ConnectDatabase(String dbHost,String userName, String pwd , String dbName){
        connect(dbHost, pwd, dbName);
    }
    private void connect(String dbHost, String userName,String pwd , String dbName){
        // this.url = “jdbc:oracle:thin:tiger/scott@dbHost:1521:productDB”;
        String url = getUrl(dbHost,dbName);
        this.connection = null;
        // this.connection = DriverManager.getConnection(this.url);
        try {
           connection =  DriverManager.getConnection (url, userName, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.connection = connection;
    }
    private String getUrl (String dbHost, String dbName){
        return "jdbc:oracle:thin:@"+dbHost+":1521:"+dbName;
    }
    public Connection getConnection(){
        if (this.connection!=null)
            return this.connection;
        return null ;
    }
    private void executeQuery(String query){
        if (this.connection==null)
            return;
        //execute query
        
    }
}