package com.marlonviado.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.marlonviado.repository")
public class GitHubSearchJpaRepositoryConfiguration {

}
