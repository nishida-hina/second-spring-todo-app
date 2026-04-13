FROM eclipse-temurin:21-jdk
WORKDIR /app
# Gradleの実行に必要なファイルをコピー
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
# 実行権限を付与
RUN chmod +x ./gradlew
# ソースコードをコピー
COPY src src
# Spring Bootアプリをビルドして実行
CMD ["./gradlew", "bootRun"]