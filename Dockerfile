FROM openjdk:17
EXPOSE 8080
ARG JAR_FILE=build/libs/alterra-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} alterra-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/alterra-0.0.1-SNAPSHOT.jar"]
