FROM openjdk:11
EXPOSE 8765
ENV SPRING_PROFILES_ACTIVE dockerdev
ENV SERVER_PORT 8765
ADD ./target/netflix-zuul-api-gateway-server-0.0.1-SNAPSHOT.jar netflix-zuul-api-gateway-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "netflix-zuul-api-gateway-server-0.0.1-SNAPSHOT.jar"]
