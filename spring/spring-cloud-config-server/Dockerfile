FROM maven:3.5-jdk-8-alpine as build
MAINTAINER Aakash Kushwah <aakashkushwah@yahoo.co.in>
WORKDIR /app
ADD . /app/
RUN mvn install

FROM java:8-jre
WORKDIR /app
COPY --from=build /app/target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "spring-cloud-config-server-0.0.1-SNAPSHOT.jar"]
HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/admin/health || exit 1
EXPOSE 8888