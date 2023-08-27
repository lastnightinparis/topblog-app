# Кейс по сбору аналитических данных блога

Сервер предоставляет функционал по загрузке изображения, передачи в AI модель, получению ответа от модели, сохранения в .xlsx таблицу

Стэк: Java, SpringBoot, PostgreSQL, Maven

Для локального запуска необходимо клонировать проект, а также запустить следующие команды (необходимо наличие базы PostgreSQL):
```
    git clone https://github.com/lastnightinparis/topblog-app.git
    mvn clean install
    java -Dspring.profiles.active=default -DDB_USER='YOUR_USER' -DDB_PASSWORD='YOUR_PASSWORD' -jar target/topblog-app-0.0.1.jar
```

Также приложение развёрнуто на сервере:
http://51.250.22.177:8080/swagger-ui/index.html - Swagger UI

