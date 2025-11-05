# Spring Boot Kotlin Demo with Spring Data JPA, Spring Data REST, OpenAPI, Flyway, and Testcontainers

A demo Spring Boot project in Kotlin showcasing:
- **Spring Data JPA** and **Spring Data REST** for CRUD APIs
- **OpenAPI** documentation via SpringDoc
- **Flyway** for database migrations (which also is applied to the Testcontainers DB)
- **Testcontainers** for running the application locally and integration testing with PostgreSQL

## Database & Migrations

- Uses **PostgreSQL** (see `application.yaml` for config)
- **Flyway** manages schema migrations (`src/main/resources/db/migration`)
- Initial migration creates the `users` table

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

