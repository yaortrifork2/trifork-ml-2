FROM gradle:8.3-jdk20 AS build
LABEL maintainer="yaor@trifork.com"

WORKDIR /app

COPY --chown=gradle:gradle build.gradle .
COPY --chown=gradle:gradle settings.gradle .
COPY --chown=gradle:gradle src src
COPY --chown=gradle:gradle .git .git
COPY --chown=gradle:gradle .gitignore .gitignore

RUN gradle clean
RUN gradle build  --info --stacktrace

FROM openjdk:20-jdk-slim
EXPOSE 80

COPY --from=build /app/build/libs /app/libs
WORKDIR /app/libs

ENTRYPOINT java -XshowSettings:system -XX:+PreferContainerQuotaForCPUCount -XX:MaxRAMPercentage=85 \
                -jar nedgia-ml-api-1.0-SNAPSHOT.jar
