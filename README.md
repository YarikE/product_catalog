# product_catalog

### Приложение для отображения и администрирования каталога продуктов

## Стек технологий:

- Java 17
- Spring
- JPA/Hibernate
- Nodejs 20
- React (js)
- PostgreSQL
- MongoDB
- Swagger
- Docker

## Иструкция по запуску

Для запуска вам нужны:

- Docker
- Docker-compose
- Git

### 1. Склонируйте репозиторий: 
```
git clone https://github.com/YarikE/product_catalog.git
```

### 2. Перейдите в папку проекта:
```
cd product_catalog
```

### 3. Соберите проект проект:
```
docker-compose build
```

### 4. Запустите проект:
```
docker-compose up -d
```

## После запуска:

- Фронтенд приложение доступно по: http://localhost:4000/products
- Бэкенд приложение доступно по: http://localhost:8080
- Swagger API доступен по: http://localhost:8080/swagger-ui/index.html

