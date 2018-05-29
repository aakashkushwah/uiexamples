FROM java:8-jre
MAINTAINER Aakash Kushwah <aakashkushwah@yahoo.co.in>

ADD ./target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar /app/
ADD ./properties-local/ /app/
CMD ["java", "-Xmx200m", "-jar", "/app/spring-cloud-config-server-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/admin/health || exit 1

EXPOSE 8888