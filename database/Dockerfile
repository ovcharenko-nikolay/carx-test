FROM postgres:11.4
RUN localedef -i en_US -c -f UTF-8 -A /usr/share/locale/locale.alias en_US.UTF-8
ENV LANG en_US.utf8
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB carx
COPY carx.sql /docker-entrypoint-initdb.d/