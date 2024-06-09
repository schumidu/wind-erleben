fileName="dev-compose.yml"
docker compose --file ${fileName} down
docker compose --file ${fileName} up --build --force-recreate -d
