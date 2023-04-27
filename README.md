# api-6-back

## Pre Running

```bash
git update-index --assume-unchanged .vscode/thunder-tests/thunderEnvironment.json

docker-compose up -d

cp .env.example .env
```

## Running the app

```bash
# development
$ mvn spring-boot:run
```

## Test

```bash
# development
$ mvn test\
```

## Populate database

Linux:
```bash
bash start-database.sh
```

Windows:

```
docker exec -it c8-pg bash

# inside container bash terminal

psql -U docker -d c8 < ./sql-init/init_database.sql

psql -U docker -d c8 < ./sql-init/grupos_202304250951.sql

psql -U docker -d c8 < ./sql-init/instituicoes_202304250951.sql

psql -U docker -d c8 < ./sql-init/instituicao_grupo_202304250951.sql

psql -U docker -d c8 < ./sql-init/servicos_202304250951.sql

psql -U docker -d c8 < ./sql-init/scores_202304250951.sql

psql -U docker -d c8 < ./sql-init/tarifas_202304250951.sql
```