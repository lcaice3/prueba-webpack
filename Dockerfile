FROM 070073855891.dkr.ecr.us-east-1.amazonaws.com/bdb-java8-oracle-alpine:1.0
MAINTAINER BdB <jparr17@bancodebogota.com.co>
#ARG JAR_VERSION
VOLUME /tmp
ADD target/app.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]