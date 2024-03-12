FROM gradle:8.6.0-jdk17 as builder
WORKDIR /usr/app
COPY ./app .
RUN gradle war

FROM payara/server-full:6.2023.12-jdk17

LABEL contactmail="schumann.lukas@gmx.de"
COPY ./config/resources/mysql-connector-j-8.1.0.jar /opt/payara/appserver/glassfish/lib/mysql-connector-j-8.1.0.jar

COPY ./config/payara/docker/pre-boot-commands.asadmin ${PREBOOT_COMMANDS}
COPY ./config/payara/docker/post-boot-commands.asadmin ${POSTBOOT_COMMANDS}
COPY ./config/payara/docker/restClientConfig.properties ${CONFIG_DIR}/client.properties
COPY --from=builder /usr/app/build/libs/winderleben.war ${DEPLOY_DIR}