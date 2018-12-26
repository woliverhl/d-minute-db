FROM openjdk:8-jdk-alpine

RUN apk update

# Install maven
RUN apk add maven
# Fix zona horaria de Chile
RUN apk add tzdata

# Add Maintainer Info
LABEL maintainer="ohidalgoleal@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# add app
COPY . .

# Make port 8003 available to the world outside this container
EXPOSE 8003

# Fix zona horaria de Chile
#RUN apk update && apk install -y tzdata
#ENV TZ America/Santiago

ENV CONFIG_SERVER_DMINUTE=http://172.17.0.6:8888
ENV EUREKA_ENDPOINT=http://172.17.0.5:1111/eureka
ENV DOMAIN_NAME=huelen.diinf.usach.cl
ENV TZ America/Santiago

#Compila app
RUN mvn clean install

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/target/d-minute-ms-2.0.0.jar"]
