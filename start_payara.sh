docker compose --file mysqldb_docker.yml down
docker compose --file docker-compose2.yml down
docker compose --file mysqldb_docker.yml up -d
docker compose --file docker-compose2.yml up --build --force-recreate
