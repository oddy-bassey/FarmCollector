
## FarmCollector API

### Description
FarmCollector is an API designed to collect information from farmers about planting and harvesting activities for different fields during various seasons.
#### With the limited time on this, the following provides some information to my solution

### Features
- **Planted Information Collection:**
    - Allows farmers to submit information about planting activities, including planting area, crop type, and expected product amount.
- **Harvested Information Collection:**
    - Enables farmers to submit information about harvesting activities, including the actual amount of harvested products.
- **Reports Generation:**
    - Provides reports for each farm and each type of crop, comparing expected vs actual product amounts for each season.

### Implementation Details
- **Technologies Used:**
    - Java
    - Spring Boot
    - Hibernate
    - JPA
    - H2 Database
- **Key Components:**
    - `FarmController`: Handles HTTP requests related to farm operations.
    - `FieldService`: Manages business logic for field-related operations.
    - `FieldRepository`: Interacts with the database for field-related CRUD operations.
    - `PlantingRequest` and `HarvestingRequest`: Record classes for receiving data in the controller.
- **Testing:**
    - Utilizes JUnit 5 and Mockito for unit testing.
    - Includes tests for adding planting and harvesting information, as well as repository tests.
- **Areas of Improvement:**
    - **Test Coverage:** Enhance test coverage to include more edge cases and scenarios.
    - **Controller Advices:** Implement controller advices for handling global exceptions and error responses uniformly.
    - **Validation:** Add input validation for request parameters to ensure data integrity and security.
    - **Documentation:** Provide comprehensive API documentation using tools like Swagger.
    - **Logging:** Incorporate logging to capture important events and errors for troubleshooting and monitoring.

### Getting Started
To run the FarmCollector API locally, follow these steps:
1. Clone the repository.
2. Navigate to the project directory.
3. Build the project using Maven
4. Run the application using your preferred IDE or the command line.
5. Access the API endpoints using an HTTP client or browser.

---

This README.md provides a concise overview of the FarmCollector API, highlighting its features, technologies used, key components, and areas for improvement. It serves as a helpful guide for anyone interested in understanding the project and contributing to its enhancement.