FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=/target/tipocambio-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} tipocambio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tipocambio-0.0.1-SNAPSHOT.jar"]