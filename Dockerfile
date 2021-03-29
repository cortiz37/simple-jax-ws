FROM jboss/wildfly
ADD build/libs/ws-app.war /opt/jboss/wildfly/standalone/deployments/