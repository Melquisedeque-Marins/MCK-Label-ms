FROM openjdk:17
WORKDIR /app
COPY ./target/label-0.0.1-SNAPSHOT.jar ./label.jar
EXPOSE 8080

ENTRYPOINT java -jar label.jar
