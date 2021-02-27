FROM openjdk:11 as build
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11
VOLUME /tmp
ARG DEPENDENCY=/app/target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/OT-INF/classes /app
EXPOSE 8080
#ENTRYPOINT ["java","-cp","app:app/lib/*","springboot_project.Application"]
ENTRYPOINT ["java", "-jar", "/app/target/dependency/springboot_project-0.0.1-SNAPSHOT.jar"]