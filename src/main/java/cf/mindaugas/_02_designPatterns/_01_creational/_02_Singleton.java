package cf.mindaugas._02_designPatterns._01_creational;

public class _02_Singleton {
    public static void main(String[] args) {
        var s1 = NaiveSingleton.getInstance();
        var s2 = NaiveSingleton.getInstance();
        var s3 = NaiveSingleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);



        var dbm1 = DBManager.getInstance("127.0.0.1", "3306", "x");
        var dbm2 = DBManager.getInstance("127.0.0.1", "3306", "y");
        var dbm3 = DBManager.getInstance("127.0.0.1", "3306", "z");

        System.out.println(dbm1.getDatabaseName());
        System.out.println(dbm2.getDatabaseName());
        System.out.println(dbm3.getDatabaseName());
    }
}

class NaiveSingleton {
    private static NaiveSingleton instance;
    // private static NaiveSingleton instance = new NaiveSingleton(); // EAGER initialization
    private NaiveSingleton(){}

    public static NaiveSingleton getInstance() {
        if(instance == null)
            instance = new NaiveSingleton(); // LAZY initialization
        return instance;
    }
}

class DBManager {
    private static DBManager instance;
    private String server;
    private String portNumber;
    private String databaseName;

    public static DBManager getInstance() {
        return instance;
    }

    public static void setInstance(DBManager instance) {
        DBManager.instance = instance;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    private DBManager(String server, String portNumber, String databaseName){
        this.server = server;
        this.portNumber = portNumber;
        this.databaseName = databaseName;
    }

    public static DBManager getInstance(String server, String portNumber, String databaseName) {
        if(instance == null)
            instance = new DBManager(server, portNumber, databaseName);
        return instance;
    }
}