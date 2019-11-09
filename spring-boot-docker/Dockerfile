FROM openjdk:8-jdk-alpine
MAINTAINER zhangpeng <forbreak@163.com>
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","io.github.dunwu.springboot.SpringBootDockerApplication"]
