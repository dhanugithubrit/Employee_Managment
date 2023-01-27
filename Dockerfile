#create a workspace Employee
#install mysql also
#EMS
FROM adoptopenjdk/openjdk11
RUN rm /var/lib/dpkg/lock
RUN apt-get update && apt-get install -y procps
RUN mkdir employee
RUN chmod 777 employee
WORKDIR employee
RUN apt-get install -y htop
RUN apt-get install -y sysstat
RUN apt-get install -y net-tools
RUN apt-get install -y tcpdump ngrep iproute2 libcap2-bin
RUN mkdir EMS
RUN chmod 777 EMS
RUN cd EMS
COPY target/EmployeeManagement-*.jar employee.jar
COPY src/main/resources/application.properties app.properties


EXPOSE 8080/tcp
#CMD ["JAVA","-JAR","employee.jar","-SERVER","app.properties"]




