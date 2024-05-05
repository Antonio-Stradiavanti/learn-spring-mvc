# Команда FROM инициализирует новый этап сборки
FROM maven:3.9.6-eclipse-temurin-21 as builder

# Устанавливает рабочий каталог $PWD для следующих за ней инструкций COPY, ENTRYPOINT, RUN, CMD
WORKDIR /opt/app

# COPY <src> <dest>, где dest -- абсолютный или относительный последней инструкции WORKDIR путь
COPY mvnw pom.xml ./
COPY ./src ./src

RUN mvn clean install -DskipTests

# Первый этап сборки становится зависимостью для второго.

FROM eclipse-temurin:21-jre-jammy
WORKDIR /opt/app
EXPOSE 8000
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]
