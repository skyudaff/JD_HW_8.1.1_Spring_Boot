FROM openjdk:20-jdk-oracle
EXPOSE 8081
ADD target/JD_HW_8_1_1_Spring_Boot-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]