FROM openjdk:17
ADD target/przyklad1-0.0.1-SNAPSHOT.jar  przyklad1-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "przyklad1-0.0.1-SNAPSHOT.jar"]

