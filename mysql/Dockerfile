# Derived from official mysql image (our base image)
FROM mysql:5.7
# PORT TO BE EXPOSE
EXPOSE 3306/tcp
# Add a database
ENV MYSQL_ROOT_PASSWORD 123456
ENV MYSQL_DATABASE config
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/
