# News REST API

This is a simple API to create, read, update and delete news.
It is written in Java and uses the [Spring Boot](https://spring.io/projects/spring-boot) framework.

## Used Technologies
- Java 17
- Spring Boot
- H2 Database

## Available endpoints
- `GET /news` - List all news
- `GET /news/:id` - Get a news article by id
- `POST /news` - Create a new news article
- `PUT /news/:id` - Update a news article
- `DELETE /news/:id` - Delete a news article

[Postman collection file](https://github.com/mattzahel/java-api-project/blob/d516139fd4810155a64a4d1aab44f9feea865c16/docs/News%20API.postman_collection.json) is available in the docs folder

## How to run
1. Clone this repository
2. Install Maven dependencies
3. Run the application
4. Access the endpoints
