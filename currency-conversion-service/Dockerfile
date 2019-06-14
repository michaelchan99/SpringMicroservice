FROM openjdk:11
EXPOSE 8100
ENV SPRING_PROFILES_ACTIVE dockerdev
ADD ./target/currency-conversion-service-0.0.1-SNAPSHOT.jar currency-conversion-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "currency-conversion-service-0.0.1-SNAPSHOT.jar"]
