FROM maven:3.8.6-openjdk-8 AS build
VOLUME /tmp
COPY target/*.war prettyjson.war
ENTRYPOINT ["java","-jar","/prettyjson.war"]
EXPOSE 8080
