FROM maven:3-jdk-8-alpine as maven
COPY / /tmp/tiwolij/
RUN mvn --file /tmp/tiwolij package war:war

FROM jetty:9-jre8-alpine
EXPOSE 8080
VOLUME /data
COPY --from=maven /tmp/tiwolij/target/*.war /srv/tiwolij.war
CMD java -jar /usr/local/jetty/start.jar --module=deploy --module=http
