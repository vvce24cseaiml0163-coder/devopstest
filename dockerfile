
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/mobile-recharge-app-1.0.jar app.jar

CMD ["java", "-jar", "app.jar"]
