FROM openjdk:17-jdk-alpine
COPY target/spring-boot-mongodb-k8s-0.0.1-SNAPSHOT.jar spring-boot-mongodb-k8s-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-mongodb-k8s-0.0.1-SNAPSHOT.jar"]