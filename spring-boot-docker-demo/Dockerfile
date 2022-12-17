# define base docker image
FROM openjdk:18
LABEL maintainer="sahil.sharma"
ADD target/spring-boot-docker-demo-0.0.1-SNAPSHOT.jar spring-boot-docker-demo.jar
ENTRYPOINT ["java","-jar","spring-boot-docker-demo.jar"]