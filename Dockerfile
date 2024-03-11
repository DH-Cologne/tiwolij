FROM maven:3-jdk-8-alpine as maven
COPY / /tmp/tiwolij/
RUN mvn --file /tmp/tiwolij package war:war

FROM jetty:9-jre8-alpine
EXPOSE 8080
VOLUME /data
ENV LD_LIBRARY_PATH=/var/lib/jetty/lib
COPY --from=maven /tmp/tiwolij/target/*.war /srv/tiwolij.war
RUN apk --no-cache fetch -qs libgcc | tar xz --strip-components 1
CMD java -jar /usr/local/jetty/start.jar --module=deploy --module=http
