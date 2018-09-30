package com.alex.mongo_boot.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MongoSettingProperties
{
    private String database;

    private String host;

    private Integer port;

    private String username;

    private String password;

    private String authenticationDatabase;

    private Integer minConnectionsPerHost = 10;

    private Integer connectionsPerHost = 2;
}
