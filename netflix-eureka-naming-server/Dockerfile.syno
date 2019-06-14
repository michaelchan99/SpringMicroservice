FROM openjdk:11
EXPOSE 8761
ENV SERVER_PORT 8761
ADD ./target/netflix-eureka-naming-server-0.0.1-SNAPSHOT.jar netflix-eureka-naming-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "netflix-eureka-naming-server-0.0.1-SNAPSHOT.jar"]
