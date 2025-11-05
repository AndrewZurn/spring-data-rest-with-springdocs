# Spring Boot Kotlin Demo with Spring Data JPA, Spring Data REST, OpenAPI, Flyway, and Testcontainers

A demo Spring Boot project in Kotlin showcasing:
- **Spring Data JPA** and **Spring Data REST** for CRUD APIs
- **OpenAPI** documentation via SpringDoc
- **Flyway** for database migrations (which also is applied to the Testcontainers DB)
- **Testcontainers** for running the application locally and integration testing with PostgreSQL
- **Querydsl** for flexible, type-safe query support on REST endpoints

## Database & Migrations

- Uses **PostgreSQL** (see `application.yaml` for config)
- **Flyway** manages schema migrations (`src/main/resources/db/migration`)
- Initial migration creates the `users` table

## Querydsl: Flexible Query Engine

This project integrates **Querydsl** to provide advanced, type-safe, and flexible querying capabilities for your REST 
endpoints. Querydsl enables clients to filter and search entities using query parameters, supporting complex predicates 
and case-insensitive matching.

- The `UserRepository` extends `QuerydslPredicateExecutor` and customizes bindings for flexible search.
- Example: To search for users with a first name containing "john" (case-insensitive):

  ```
  GET /users?firstName=john
  ```

- You can combine multiple parameters for more advanced queries:

  ```
  GET /users?firstName=john&lastName=doe
  ```

- All string fields support `containsIgnoreCase` matching by default.

**How it works:**  
Querydsl generates Kotlin/Java classes (Q-types) for your entities at build time. Spring Data REST automatically 
exposes predicate-based search endpoints using these Q-types, allowing for expressive and type-safe queries via 
HTTP parameters.

## Running Locally (with Testcontainers)

For local development and testing, you can use **Testcontainers** to spin up a PostgreSQL instance automatically during tests.

### Prerequisites

- Java 21+
- Docker (for Testcontainers)
- Gradle

### Start the Application Locally

1. To run the application
   ```bash
   ./gradlew bootTestRun
   ```
   (Ensure a local PostgreSQL instance is running, or adjust `application.yaml` for your environment.)

You should now be able to open the application and use the HAL browser to explore the REST 
endpoints at `http://localhost:8080/`.

### Run the Tests

1. To run the tests
   ```bash
   ./gradlew test
   ```
   This will automatically start a PostgreSQL container for integration tests.

## API Documentation

- OpenAPI docs are generated automatically.
- Visit `/swagger-ui.html` or `/v3/api-docs` when the app is running.

## Migrations

- Flyway migration scripts are in `src/main/resources/db/migration/`
- On startup, Flyway applies any pending migrations.

## Testing

- Unit and integration tests use JUnit 5 and Testcontainers.
- See `src/test/kotlin` for test examples.
