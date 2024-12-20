package fr.insa.soa.config.ConfigClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientResource {

    @Value("${server.port}")
    private String serverPort;

    @Value("${db.connection}")
    private String typeConnectionDB;

    @Value("${db.host}")
    private String dbHost;

    @Value("${db.port}")
    private String dbPort;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriver;

    @GetMapping("/dbConnection")
    public String getDbConnection() {
        return dbConnection;
    }

    @GetMapping("/dbHost")
    public String getDbHost() {
        return dbHost;
    }

    @GetMapping("/dbPort")
    public String getDbPort() {
        return dbPort;
    }

    @GetMapping("/serverPort")
    public String getServerPort() {
        return serverPort;
    }

    @GetMapping("/dataSourceUrl")
    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    @GetMapping("/dataSourceUsername")
    public String getDataSourceUsername() {
        return dataSourceUsername;
    }

    @GetMapping("/dataSourcePassword")
    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    @GetMapping("/dataSourceDriver")
    public String getDataSourceDriver() {
        return dataSourceDriver;
    }

    
}
