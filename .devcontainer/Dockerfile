ARG BASE_IMAGE_VERSION_CODENAME=bullseye
FROM mcr.microsoft.com/vscode/devcontainers/base:${BASE_IMAGE_VERSION_CODENAME}

# OS Setting
RUN \
    # Locale setting for JPN
    rm /bin/sh && ln -s /bin/bash /bin/sh \
    && apt-get update \
    && apt-get install -y task-japanese \
    && sed -i -E 's/# (ja_JP.UTF-8)/\1/' /etc/locale.gen \
    && locale-gen ja_JP.UTF-8 

# SDK setting
USER vscode
ENV SDKMAN_DIR /home/vscode/.sdkman
ARG JAVA_VERSION=11.0.17-sem
ARG TOMCAT_VERSION="9.0.56"
ARG MAVEN_VERSION=""


RUN \
    curl -s "https://get.sdkman.io" | bash \
    && source "$SDKMAN_DIR/bin/sdkman-init.sh" \
    && sdk install java ${JAVA_VERSION} \
    && sdk install tomcat ${TOMCAT_VERSION} \
    && sdk install maven ${MAVEN_VERSION}