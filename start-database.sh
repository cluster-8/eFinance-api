#!/bin/sh

echo "Running docker compose up..."
docker compose up -d
sleep 30
echo "Running populate dabase..."
docker exec -it c8-pg bash ./sql-init/populate-db.sh
echo "Done!"