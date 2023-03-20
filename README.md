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
$ mvn test
```
