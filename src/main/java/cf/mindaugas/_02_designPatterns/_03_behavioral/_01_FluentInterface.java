package cf.mindaugas._02_designPatterns._03_behavioral;

public class _01_FluentInterface {
    public static void main(String[] args) {
        var h = new HibernateConfig()
                .server("127.0.0.1")
                .port("80");
    }
}

class HibernateConfig {
    private String server;
    private String port;
    public HibernateConfig() {}

    public HibernateConfig server(String server){
        this.server = server;
        return this;
    }

    public HibernateConfig port(String port){
        this.port = port;
        return this;
    }
}
