# FME Backend (fme_be)

Comprehensive README for the `fme_be` Spring Boot backend application used in the FME demo project.

## Table of Contents
- **Project Overview**: What this repository contains
- **Features**: High-level features and responsibilities
- **Tech Stack**: Main libraries and tools used
- **Prerequisites**: Software and environment needed
- **Build & Run**: How to build, run, and test the application
- **Configuration**: Important properties and secrets
- **Project Structure**: Key files and where to look
- **Mapping & Generated Code**: Notes on mapper generation
- **Email**: Email service implementation notes
- **Development Tips**: Handy tips for contributors
- **Troubleshooting**: Common issues and fixes

## Project Overview

`fme_be` is a Spring Boot-based backend demo application that exposes endpoints related to "Duty Registration". It provides persistence, mapping between DTOs and entities, and an email sending component used during registration flows.

## Features

- REST controllers for duty registration flows
- JPA repository for persistence
- Mapper interface with generated implementation (MapStruct-based)
- Email service for sending notifications

## Tech Stack

- Java (11+ recommended)
- Spring Boot (Spring Web, Spring Data JPA)
- Gradle (wrapper included)
- MapStruct (mapper code is generated into `generated-sources`)

## Prerequisites

- JDK 11 or newer installed and available on `PATH`.
- Gradle is optional (the repository includes the Gradle wrapper). Use `./gradlew` to run builds.
- A running database if you change the default in `application.properties` (by default in-memory H2 may be used depending on configuration).

## Build & Run

From the repository root, you can build and run the application with the Gradle wrapper:

```bash
# Build
./gradlew clean build

# Run (from project root)
./gradlew bootRun
```

Alternatively, run the generated JAR after building:

```bash
java -jar build/libs/fme_be-*.jar
```

## Tests

Run unit tests with:

```bash
./gradlew test
```

Test results are written to `build/test-results` and `build/reports/tests`.

## Configuration

Default runtime configuration is in [src/main/resources/application.properties](src/main/resources/application.properties).

- Use environment variables or `--spring.config.location` to override properties.
- Common properties to review:
  - `spring.datasource.*` — DB connection settings
  - `spring.mail.*` — SMTP/email settings used by the email component

Sensitive values (SMTP credentials, DB passwords) must be provided via environment variables or externalized config when deploying.

## Project Structure (high level)

- **Source**: [src/main/java](src/main/java)
  - [DemoApplication.java](src/main/java/com/fme/demo/DemoApplication.java): Application entry point
  - [controller/DutyRegistrationController.java](src/main/java/com/fme/demo/controller/DutyRegistrationController.java): REST endpoints
  - [dto/dutyRegistration/DutyRegistrationRequest.java](src/main/java/com/fme/demo/dto/dutyRegistration/DutyRegistrationRequest.java): Incoming DTO
  - [dto/dutyRegistration/DutyRegistrationResponse.java](src/main/java/com/fme/demo/dto/dutyRegistration/DutyRegistrationResponse.java): Outgoing DTO
  - [entity/DutyRegistration.java](src/main/java/com/fme/demo/entity/DutyRegistration.java): JPA entity
  - [repository/DutyRegistrationRepository.java](src/main/java/com/fme/demo/repository/DutyRegistrationRepository.java): Spring Data JPA repo
  - [service/DutyRegistrationService.java](src/main/java/com/fme/demo/service/DutyRegistrationService.java): Business logic
  - [mapper/DutyRegistrationMapper.java](src/main/java/com/fme/demo/mapper/DutyRegistrationMapper.java): MapStruct mapper interface
  - [component/EmailContentBuilder.java](src/main/java/com/fme/demo/component/EmailContentBuilder.java): Helper for building email body
  - [service/email/impl/EmailServiceImpl.java](src/main/java/com/fme/demo/service/email/impl/EmailServiceImpl.java): Email sending implementation

- **Generated sources**: `generated-sources/annotations` — contains generated mapper implementation `DutyRegistrationMapperImpl.java` (MapStruct)

## Mapping & Generated Code

This project uses a mapper interface located at [src/main/java/com/fme/demo/mapper/DutyRegistrationMapper.java](src/main/java/com/fme/demo/mapper/DutyRegistrationMapper.java). The concrete mapper implementation is generated (MapStruct) and placed under `generated-sources/annotations/com/fme/demo/mapper/DutyRegistrationMapperImpl.java`.

If you modify the mapper interface, re-run the build so MapStruct can regenerate implementations:

```bash
./gradlew clean build --refresh-dependencies
```

If generated sources are not visible in your IDE, refresh/enable annotation processing so the IDE picks up `generated-sources`.

## Email Service Notes

Email sending logic lives in the `service/email` package. Configuration for SMTP should be provided in `application.properties` or via environment variables. Example properties:

```properties
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=user@example.com
spring.mail.password=secret
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

For local dev, consider using a local SMTP sink (MailHog, Papercut) to capture outgoing messages.

## Development Tips

- Use the Gradle wrapper `./gradlew` to ensure consistent builds.
- Enable annotation processing in your IDE to see MapStruct generated sources.
- When adding entity fields, verify DTOs and mapper mappings are updated.

## Troubleshooting

- Build fails due to missing MapStruct generated classes: run `./gradlew clean build` and enable annotation processing.
- Email not sent: check `spring.mail.*` properties and ensure network access to SMTP server.
- DB connection issues: verify `spring.datasource.*` settings and that the DB is reachable.

## Next Steps

- Commit the README and push to the remote repository.
- If you want, I can run the test suite or update README with example API requests.

---

File created: [README.md](README.md)
