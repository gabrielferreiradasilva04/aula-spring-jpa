package com.github.gabrielferreiradasilva04.librayapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
/**
 * Configuração de um pool de conexões que realiza o gerenciamento das conexões ao banco de dados da aplicação, essa classe é criada caso seja
 * necessário realizar o acesso a mais de uma base de dados na mesma aplicação, de modo em qua a configuração de acesso a dados se torna dinamica
 * Basicamente o pool de conxões realiza o gerenciamento delas criando e matando elas, e a quantidade de conexões pode interfirir 
 * diretamente no desempenho da sua aplicação
 */
@Configuration
public class DatabaseConfiguration {
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.datasource.driver-class-name}")
	String driver;

 /*   @Bean
    DataSource dataSource() {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	
    	ds.setUrl(this.url);
    	ds.setUsername(this.username);
    	ds.setPassword(this.password);
    	ds.setDriverClassName(this.driver);
    	return ds;
	}*/
    
    /**
     * O hikari é a classe indicada para gerenciar os pools de conexão
     * @return
     */
    @Bean 
    DataSource hikariDataSource() {
    	
    	HikariConfig config = new HikariConfig();
    	config.setUsername(username);
    	config.setPassword(password);
    	config.setDriverClassName(driver);
    	config.setJdbcUrl(url);
    	/*principais*/
    	config.setMaximumPoolSize(10); /*configura a quantidade de acessos simultaneos a base de dados*/
    	config.setMinimumIdle(1); /*configura o minimo de conexões que vai ser liberada*/
    	config.setPoolName("library-db-pool");
    	config.setMaxLifetime(600000); /*Configura o tempo maximo para uma conexão, depois disso ela é morta : 600000 10 minutos*/
    	config.setConnectionTimeout(100000); /*máximo de tempo para tentar obter uma conexão, se não conseguir dentro do tempo ele da erro*/
    	/*opcionais*/
    	config.setConnectionTestQuery("select 1"); /*query para testar se o banco de dados está funcionando*/
    	
    	return new HikariDataSource(config);
    }
}
