# Course API

Этот проект представляет собой RESTful API для управления курсами. Он разработан с использованием Spring Boot и предоставляет возможности аутентификации через JWT, работу с базой данных PostgreSQL и отправку электронной почты.

## Технологии

- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **PostgreSQL**
- **JWT (JSON Web Tokens)**
- **Spring Security**
- **Java Mail Sender**
- **Swagger (OpenAPI 3.0)**

## Требования

- Java 22
- PostgreSQL
- Maven

## Установка и запуск

1. **Клонируйте репозиторий:**

   ```bash
   git clone https://github.com/your-username/course-api.git
   cd course-api

    Настройте базу данных:

    Создайте базу данных course_db в PostgreSQL и обновите настройки в application.yml:
    yaml
    Copy

    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/course_db
        username: postgres
        password: root

    Установите переменные окружения:

    Убедитесь, что переменные окружения заданы:

        JWT_SECRET: Секретный ключ для JWT.

        EMAIL_USERNAME: Ваш email для отправки писем.

        EMAIL_PASSWORD: Пароль от email.

    Пример для Linux/MacOS:
    bash
    Copy

    export JWT_SECRET=your-secret-key
    export EMAIL_USERNAME=your-email@gmail.com
    export EMAIL_PASSWORD=your-email-password

    Соберите и запустите приложение:
    bash
    Copy

    mvn clean install
    mvn spring-boot:run

    Приложение будет доступно по адресу: http://localhost:9797.

Использование API
Аутентификация

    Регистрация пользователя:

        Эндпоинт: POST /api/auth/register

        Тело запроса:
        json
        Copy

        {
          "username": "user",
          "password": "password",
          "email": "user@example.com"
        }

    Аутентификация:

        Эндпоинт: POST /api/auth/login

        Тело запроса:
        json
        Copy

        {
          "username": "user",
          "password": "password"
        }

        Ответ:
        json
        Copy

        {
          "token": "your-jwt-token"
        }

    Используйте полученный токен для доступа к защищённым эндпоинтам, добавляя его в заголовок Authorization: Bearer <token>.

Курсы

    Получить список курсов:

        Эндпоинт: GET /api/courses

        Ответ:
        json
        Copy

        [
          {
            "id": 1,
            "title": "Spring Boot Basics",
            "description": "Learn Spring Boot from scratch."
          }
        ]

    Создать курс:

        Эндпоинт: POST /api/courses

        Тело запроса:
        json
        Copy

        {
          "title": "Advanced Java",
          "description": "Deep dive into Java programming."
        }

    Обновить курс:

        Эндпоинт: PUT /api/courses/{id}

        Тело запроса:
        json
        Copy

        {
          "title": "Updated Title",
          "description": "Updated Description"
        }

    Удалить курс:

        Эндпоинт: DELETE /api/courses/{id}
	
	обнова v2
	
	удаление редактирование курсов доступно только для Администратора
	все методы в /api/v1/admin/
	
	admin-controller
	PUT
		/api/v1/admin/courses/{id} добавить курс
	DELETE
		/api/v1/admin/courses/{id} удалить курс
	POST
		/api/v1/admin/testAdmin
	GET
		/api/v1/admin/students просмотр всех студентов
	GET
		/api/v1/admin/students/{id}  просмотр студента по ID
	DELETE
		/api/v1/admin/students/{id}  удалить студента по указанному ID
	GET
		/api/v1/admin/students/search искать студента по ключевым словам


Документация API

Документация API доступна через Swagger UI:

    Swagger UI: http://localhost:9797/swagger-ui.html

    OpenAPI JSON: http://localhost:9797/v3/api-docs

Лицензия