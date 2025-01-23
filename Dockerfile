FROM openjdk:11
ADD target/springboot-mongodb.jar springboot-mongodb.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springboot-mongodb.jar"]