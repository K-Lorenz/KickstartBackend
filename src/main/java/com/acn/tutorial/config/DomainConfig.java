package com.acn.tutorial.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.acn.tutorial.domain")
@EnableJpaRepositories("com.acn.tutorial.repos")
@EnableTransactionManagement
public class DomainConfig {
}
