package com.alex.mongo_boot.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@Slf4j
public class MongoConfig
{
    @Autowired
    private MongoSettingProperties settingProperties;

    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    public MongoSettingProperties mongoSettingProperties()
    {
        return new MongoSettingProperties();
    }

    // 覆盖默认的MongoDbFactory
    @Bean
    public MongoDbFactory mongoDbFactory()
    {
        //客户端配置（连接数、副本集群验证）
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(settingProperties.getConnectionsPerHost());
        builder.minConnectionsPerHost(settingProperties.getMinConnectionsPerHost());
        MongoClientOptions mongoClientOptions = builder.build();

        // MongoDB地址
        ServerAddress address = new ServerAddress(settingProperties.getHost(), settingProperties.getPort());
        log.info("mongo address: " + address);

        // 连接认证
        MongoCredential credential = MongoCredential.createScramSha1Credential(settingProperties.getUsername(), settingProperties.getAuthenticationDatabase(), settingProperties.getPassword().toCharArray());

        //创建客户端和Factory
        MongoClient mongoClient = new MongoClient(address, credential, mongoClientOptions);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, "shop");
        log.info("connect database " + mongoDbFactory.getDb().getName() + " successfully!");

        return mongoDbFactory;
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory factory)
    {
        return new MongoTemplate(factory);
    }
}
