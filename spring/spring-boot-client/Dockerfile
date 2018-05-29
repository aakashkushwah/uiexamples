FROM maven:3.5-jdk-8-alpine as build
MAINTAINER Aakash Kushwah <aakashkushwah@yahoo.co.in>
WORKDIR /app
ADD . /app/
RUN mvn install

FROM java:8-jre
WORKDIR /app
COPY --from=build /app/target/spring-boot-client-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "spring-boot-client-0.0.1-SNAPSHOT.jar"]

EXPOSE 8889