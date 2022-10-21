FROM maven:3.6.0-jdk-11
MAINTAINER Nikola
EXPOSE 5000
RUN mkdir /app
COPY pom.xml /app
COPY /target/mvn-app-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
ENTRYPOINT ["java","-jar","/app/mvn-app-0.0.1-SNAPSHOT.jar"]