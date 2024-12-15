# Event and Venue Management API

An advanced and scalable API for managing events and venues, built with modern technologies and principles. This project is designed to deliver robust performance, maintainable code, and seamless integration with existing systems.

## Features
- **Event Management**: Create, update, delete, and retrieve events with ease.
- **Venue Management**: Manage venue details, availability, and bookings.
- **Clean Architecture**: Following Clean Architecture principles for better code organization and maintainability.
- **Database Versioning**: Leveraging Flyway for consistent and traceable database migrations.
- **Containerization**: Built with Docker for simplified deployment and scalability.
- **Modern Java**: Developed with Java 17, utilizing the latest language features.

---

## Tech Stack
- **Java 17**: Modern Java features for cleaner and more efficient code.
- **Spring Framework**: Includes Spring Boot for rapid development and Spring Data for database interaction.
- **Docker**: Containerized application for easy deployment.
- **Flyway**: For managing database schema migrations.
- **PostgreSQL**: Reliable and scalable database backend.

---

## Architecture
The project follows the principles of **Clean Architecture**, ensuring:
- **Separation of Concerns**: Dividing the application into clear layers (Domain, Application, Infrastructure, and Presentation).
- **Testability**: High test coverage and easily testable components.
- **Flexibility**: Easy adaptability for new features and integrations.

### Project Structure
```plaintext
src
├── main
│   ├── java
│   │   └── com.example.eventmanagement
│   │       ├── application  # Application logic
│   │       ├── domain       # Core business rules
│   │       ├── infrastructure # External integrations and database
│   │       └── presentation  # Controllers and REST endpoints
│   └── resources
│       ├── db/migration     # Flyway migrations
│       └── application.yml  # Application configuration
└── test
    └── java                 # Unit and integration tests
```

---

## Getting Started

### Prerequisites
Ensure you have the following installed:
- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Docker](https://www.docker.com/)
- [Maven](https://maven.apache.org/) (optional, if not using Docker)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/horaciomuller/EventClean.git
   cd event-management-api
   ```

2. Start the application with Docker:
   ```bash
   docker-compose up
   ```

3. Access the API documentation (Swagger):
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## API Endpoints

### Events
- **GET /events**: Retrieve a list of events.
- **POST /events**: Create a new event.
- **PUT /events/{id}**: Update an event by ID.
- **DELETE /events/{id}**: Delete an event by ID.

### Venues
- **GET /venues**: Retrieve a list of venues.
- **POST /venues**: Create a new venue.
- **PUT /venues/{id}**: Update a venue by ID.
- **DELETE /venues/{id}**: Delete a venue by ID.

---

## Database Migrations
This project uses **Flyway** for database schema migrations. All migration scripts are located in the `src/main/resources/db/migration` folder. To run migrations manually, use:
```bash
mvn flyway:migrate
```

---

## Testing

### Unit Tests
Run unit tests with:
```bash
mvn test
```

### Integration Tests
Ensure the database is running and execute:
```bash
mvn verify
```

---

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Contact
For questions or feedback, please contact us at [your-email@example.com](mailto:contato@java10x.dev).
