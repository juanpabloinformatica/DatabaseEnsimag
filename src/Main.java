
import db.ConnectDatabase;
class Main {
    public static void main(String[] args) {
        // String dbHost,String userName, String pwd , String dbName
        String DBNAME = "oracle1";
        String USERNAME = "langleet";
        String PWD = "langleet";
        String DBHOST = "oracle1.ensimag.fr";
        ConnectDatabase connectDb = new ConnectDatabase(DBHOST, USERNAME, PWD, DBNAME);
        System.out.println(""+connectDb.connection);
    }
}