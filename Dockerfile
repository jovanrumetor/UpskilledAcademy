FROM openjdk:17
EXPOSE 8080
COPY JAR_FILE=build/libs/**.jar alterra-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/alterra-0.0.1-SNAPSHOT.jar"]
