FROM openjdk:11
EXPOSE 8502
ENV SERVER_PORT 8502
ENV DB_HOST mysql
ENV DB_USER user_config
ENV DB_PASSWORD 123456
ADD ./target/authentication-center-0.0.1-SNAPSHOT.jar authentication-center-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "authentication-center-0.0.1-SNAPSHOT.jar"]
