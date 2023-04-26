#!/bin/sh

dbname="c8"
username="docker"
pass="docker"

init_db="./sql-init/init_database.sql"
grupos='./sql-init/grupos_202304250951.sql'
instituicoes='./sql-init/instituicoes_202304250951.sql'
instituicao_grupo='./sql-init/instituicao_grupo_202304250951.sql'
servicos='./sql-init/servicos_202304250951.sql'
scores='./sql-init/scores_202304250951.sql'
tarifas='./sql-init/tarifas_202304250951.sql'

scripts=($init_db $grupos $instituicoes $instituicao_grupo $servicos $tarifas $scores)

export PGPASSWORD='docker'

for i in "${scripts[@]}"; do
  echo "Running SQL script $i"
  psql -U $username -d $dbname < $i
done
