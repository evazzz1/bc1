# Используем базовый образ с Java 11
FROM openjdk:11-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/BackupFiles-1.0-SNAPSHOT.jar /app/BackupFiles-1.0-SNAPSHOT.jar

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "BackupFiles-1.0-SNAPSHOT.jar"]