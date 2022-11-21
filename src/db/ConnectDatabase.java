package db;
import java.sql.*;



/** */
public class ConnectDatabase{
    public Connection connection;
    // private Driver connection;
    public ConnectDatabase(String dbHost,String userName, String pwd , String dbName){
        connect(dbHost,userName,pwd, dbName);
    }
    private void connect(String dbHost, String userName,String pwd , String dbName){
        String url = getUrl(dbHost,dbName);
        this.connection = null;
        // this.connection = DriverManager.getConnection(this.url);
        try {
           connection =  DriverManager.getConnection (url, userName, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //this.connection = connection;
    }
    private String getUrl (String dbHost, String dbName){
        return "jdbc:oracle:thin:@"+dbHost+":1521:"+dbName;
    }
    public Connection getConnection(){
        if (this.connection!=null)
            return this.connection;
        return null ;
    }
    public void executeQuery(String query){
        if (this.connection==null)
            return;
        PreparedStatement statement = null;
        ResultSet rset= null;
        try {
            statement = this.connection.prepareStatement(query);
            rset = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("" + rset);
        //execute query
        
    }
}