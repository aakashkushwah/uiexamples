FROM java:8-jre
MAINTAINER Aakash Kushwah <aakashkushwah@yahoo.co.in>

ADD ./target/account-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/spring-boot-client-0.0.1-SNAPSHOT.jar"]

EXPOSE 8889