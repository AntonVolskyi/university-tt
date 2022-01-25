FROM openjdk:11
ADD target/university.jar university.jar
ENTRYPOINT ["java", "-jar","university.jar"]
EXPOSE 8080