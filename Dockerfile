FROM openjdk

WORKDIR /app

COPY target/ubs-0.0.1-SNAPSHOT.jar /app/ubs.jar

ENTRYPOINT ["java", "-jar", "ubs.jar"]