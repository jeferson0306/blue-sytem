package com.sistemablue.sistemablue.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@Configuration
public class DatabaseConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private int mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    @Override
    protected String getDatabaseName() {
        return mongoDatabase;
    }

    @Override
    public MongoClient mongoClient() {
        try {
            log.info("Iniciando conexão com o MongoDB...");
            final var client = MongoClients.create("mongodb://" + mongoHost + ":" + mongoPort);
            log.info("Conexão com o MongoDB estabelecida com sucesso para o banco '{}'", getDatabaseName());
            return client;
        } catch (Exception e) {
            log.error("Erro ao conectar ao MongoDB: {}", e.getMessage());
            throw e;
        }
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Bean
    public MongoTransactionManager transactionManager(final MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

}
