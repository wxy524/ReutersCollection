package com.h2o.ai.reuterscollectionservices.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "com.h2o.ai.reuterscollectionservices.repository")
public class MongoConfiguration extends AbstractMongoConfiguration{

    @Autowired
    Environment env;

    @Override
    public MongoClient mongoClient() {
        List<ServerAddress> seeds = new ArrayList<>();
        seeds.add(new ServerAddress(env.getProperty("spring.data.mongo.host"), Integer.parseInt(env.getProperty("spring.data.mongo.port"))));
        MongoCredential credential = MongoCredential.createCredential(env.getProperty("spring.data.mongo.username"), getDatabaseName(),
                env.getProperty("spring.data.mongo.password").toCharArray());

        MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().build();

        return new MongoClient(seeds, credential, mongoClientOptions);

    }

    @Override
    protected String getDatabaseName() {
        return env.getProperty("spring.data.mongo.database");
    }
}
