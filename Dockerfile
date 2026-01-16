FROM amazoncorretto:21
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Xmx200m","-jar","app.jar"]
