CREATE USER 'user_config'@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'user_config'@'%';
FLUSH PRIVILEGES;

USE config;

CREATE TABLE `oauth_access_token` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oauth_refresh_token` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `properties` (
  `id` int(11) NOT NULL,
  `key` varchar(50) DEFAULT NULL,
  `value` varchar(500) DEFAULT NULL,
  `application` varchar(50) DEFAULT NULL,
  `label` varchar(50) DEFAULT NULL,
  `profile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `age`, `password`, `salary`, `username`)
VALUES
	(1,33,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',3456,'Alex123'),
	(2,23,'$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK',7823,'Tom234'),
	(3,45,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',4234,'Adam');

INSERT INTO `properties` (`id`, `key`, `value`, `application`, `label`, `profile`)
VALUES
			 (1,'minimum','1','limits-service','master','dev'),
			 (2,'eureka.client.serviceUrl.defaultZone','http://eureka:8762/eureka','currency-conversion-service','master','dev'),
			 (3,'eureka.client.serviceUrl.defaultZone','http://eureka:8762/eureka','currency-exchange-service','master','dev'),
			 (4,'spring.jpa.show-sql','true','currency-exchange-service','master','dev'),
			 (5,'spring.h2.console.enabled','true','currency-exchange-service','master','dev'),
			 (6,'eureka.client.serviceUrl.defaultZone','http://eureka:8761/eureka','currency-conversion-service','master','dockerdev'),
			 (7,'eureka.client.serviceUrl.defaultZone','http://eureka:8761/eureka','currency-exchange-service','master','dockerdev'),
			 (8,'spring.jpa.show-sql','true','currency-exchange-service','master','dockerdev'),
			 (9,'spring.h2.console.enabled','true','currency-exchange-service','master','dockerdev'),
			 (10,'eureka.client.serviceUrl.defaultZone','http://eureka:8761/eureka','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (11,'eureka.client.serviceUrl.defaultZone','http://eureka:8762/eureka','netflix-zuul-api-gateway-server','master','dev'),
			 (12,'spring.datasource.url','jdbc:mysql://mysql-server:3306/config','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (13,'spring.datasource.username','user_config','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (14,'spring.datasource.password','123456','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (15,'spring.datasource.driver-class-name','com.mysql.jdbc.Driver','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (16,'spring.jpa.hibernate.ddl-auto','update','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (17,'spring.jpa.show-sql','true','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (18,'zuul.debug.request','true','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (19,'logging.level.org.springframework.web','DEBUG','netflix-zuul-api-gateway-server','master','dockerdev'),
			 (20,'spring.datasource.url','jdbc:mysql://localhost:3306/config','netflix-zuul-api-gateway-server','master','dev'),
			 (21,'spring.datasource.username','user_config','netflix-zuul-api-gateway-server','master','dev'),
			 (22,'spring.datasource.password','123456','netflix-zuul-api-gateway-server','master','dev'),
			 (23,'spring.jpa.hibernate.ddl-auto','update','netflix-zuul-api-gateway-server','master','dev'),
			 (24,'spring.jpa.show-sql','true','netflix-zuul-api-gateway-server','master','dev'),
			 (25,'logging.level.org.springframework.web','DEBUG','netflix-zuul-api-gateway-server','master','dev'),
			 (26,'spring.datasource.jdbc-url','jdbc:mysql://localhost:3306/config','authentication-center','master','dev'),
			 (27,'spring.datasource.username','user_config','authentication-center','master','dev'),
			 (28,'spring.datasource.password','123456','authentication-center','master','dev'),
			 (29,'spring.jpa.hibernate.ddl-auto','update','authentication-center','master','dev'),
			 (30,'spring.jpa.show-sql','true','authentication-center','master','dev'),
			 (31,'logging.level.org.springframework.web','DEBUG','authentication-center','master','dev'),
			 (32,'eureka.client.serviceUrl.defaultZone','http://eureka:8762/eureka','authentication-center','master','dev'),
			 (33,'eureka.client.serviceUrl.defaultZone','http://eureka:8761/eureka','authentication-center','master','dockerdev'),
			 (34,'spring.datasource.jdbc-url','jdbc:mysql://mysql-server:3306/config','authentication-center','master','dockerdev'),
			 (35,'spring.datasource.username','user_config','authentication-center','master','dockerdev'),
			 (36,'spring.datasource.driver-class-name','com.mysql.jdbc.Driver','authentication-center','master','dockerdev'),
			 (37,'spring.jpa.hibernate.ddl-auto','update','authentication-center','master','dockerdev'),
			 (38,'spring.jpa.show-sql','true','authentication-center','master','dockerdev'),
			 (39,'logging.level.org.springframework.web','DEBUG','authentication-center','master','dockerdev'),
			 (40,'spring.datasource.password','123456','authentication-center','master','dockerdev'),
			 (41,'eureka.client.serviceUrl.defaultZone','http://eureka:8761/eureka','spring-admin-server','master','dockerdev'),
			 (42,'eureka.client.serviceUrl.defaultZone','http://eureka:8762/eureka','spring-admin-server','master','dev'),
			 (43,'eureka.client.serviceUrl.defaultZone','http://eureka:8762/eureka','currency-display-service','master','dev'),
			 (44,'eureka.client.serviceUrl.defaultZone','http://eureka:8761/eureka','currency-display-service','master','dockerdev'),
			 (1000,'minimum','2','limits-service','master','qa'),
			 (10000,'minimum','3','limits-service','master','prod');