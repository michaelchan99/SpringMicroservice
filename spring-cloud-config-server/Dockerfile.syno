FROM openjdk:11
EXPOSE 8888
ENV SERVER_PORT 8888
ENV DB_HOST mysql
ENV DB_USER user_config
ENV DB_PASSWORD 123456
ADD ./target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar spring-cloud-config-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-cloud-config-server-0.0.1-SNAPSHOT.jar"]
