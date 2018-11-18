FROM openjdk:8-jdk-alpine
LABEL maintainer="dimascio@us.ibm.com"
COPY build/unpacked/dist /usr/src/
EXPOSE 8080
CMD [ "/usr/src/kotlin-swagger-spring-functional-template-1.4.0/bin/kotlin-swagger-spring-functional-template" ]

