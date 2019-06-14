FROM openjdk:11
EXPOSE 8602
ENV SERVER_PORT 8602
ADD ./target/spring-admin-server-0.0.1-SNAPSHOT.jar spring-admin-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-admin-server-0.0.1-SNAPSHOT.jar"]
