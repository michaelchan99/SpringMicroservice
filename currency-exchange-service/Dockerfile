FROM openjdk:11
ENV SPRING_PROFILES_ACTIVE dockerdev 
ADD ./target/currency-exchange-service-0.0.1-SNAPSHOT.jar currency-exchange-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "currency-exchange-service-0.0.1-SNAPSHOT.jar"]
