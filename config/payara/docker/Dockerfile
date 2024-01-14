FROM payara/server-full:6.2023.12-jdk17

LABEL contactmail="schumann.lukas@gmx.de"
COPY ../../resources/mysql-connector-j-8.1.0.jar /opt/payara/appserver/glassfish/lib/mysql-connector-j-8.1.0.jar
COPY ./pre-boot-commands.asadmin /opt/payara/config/pre-boot-commands.asadmin
COPY ../../../app/build/libs/winderleben.war $DEPLOY_DIR

