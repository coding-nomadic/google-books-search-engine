package com.google.books.configs;

import com.google.books.models.ElasticSearchDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "config")
/**
 *
 * @author Tenzin Dawa
 *
 */ public class AppConfig {
    @Value("${config.elastic.elastic-url}")
    private String elasticUrl;
    @Value("${config.elastic.elastic-port}")
    private String elasticPort;
    @Value("${config.elastic.elastic-protocol}")
    private String elasticProtocol;
    @Value("${config.elastic.index-name}")
    private String indexName;
    @Value("${config.elastic.type-name}")
    private String typeName;

    @Bean
    public WebClient.Builder webClientBuilder() {
        Integer CODEC_20_MB_SIZE = 1000 * 1024 * 1024;
        return WebClient.builder().codecs(clientCodecConfigurer -> {
            var codec = new Jackson2JsonDecoder();
            codec.setMaxInMemorySize(CODEC_20_MB_SIZE);
            clientCodecConfigurer.customCodecs().register(codec);
            clientCodecConfigurer.customCodecs().register(new Jackson2JsonEncoder());
        });
    }
    @Bean
    public ElasticSearchDetails elasticSearchDetails() {
        ElasticSearchDetails elasticSearchDetails = new ElasticSearchDetails();
        elasticSearchDetails.setElasticPort(elasticPort);
        elasticSearchDetails.setElasticProtocol(elasticProtocol);
        elasticSearchDetails.setElasticUrl(elasticUrl);
        elasticSearchDetails.setIndexName(indexName);
        elasticSearchDetails.setTypeName(typeName);
        return elasticSearchDetails;
    }
}