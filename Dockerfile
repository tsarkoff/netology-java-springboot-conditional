FROM openjdk:21
#EXPOSE 8080
EXPOSE 8081
ADD target/ConditionalSpringApp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]