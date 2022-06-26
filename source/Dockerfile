# syntax=docker/dockerfile:1
FROM ubuntu:20.04
ADD target/sasha-1.0-jar-with-dependencies.jar sasha.jar
ADD https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb jdk-17.deb
RUN apt-get -y update
RUN apt install -y libxi6 libfreetype6 libpng16-16 libc6-i386 libc6-x32 libasound2-data libasound2 libxrender1 libxtst6
RUN dpkg -i jdk-17.deb
ARG JAVA_HOME="/usr/lib/jvm/jdk-17"
CMD lib/jvm/jdk-17/bin/java -jar sasha.jar