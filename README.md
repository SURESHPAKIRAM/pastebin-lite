# Pastebin Lite

Candidate ID: Naukri0126

A lightweight Pastebin clone built with Spring Boot and Thymeleaf. This application allows users to create text pastes that can be shared via a unique URL. It supports optional constraints such as time-to-live (TTL) and maximum view limits.

## Features

* Create Paste: Post arbitrary text and receive a shareable URL.
* View Paste: View the content via a browser (HTML) or API (JSON).
* Expiration Logic:
    * TTL (Time-to-Live): Pastes expire after a set number of seconds.
    * Max Views: Pastes become unavailable after being viewed a specific number of times.
* Health Check: /api/healthz endpoint for service monitoring.

## Tech Stack

* Language: Java 21
* Framework: Spring Boot 3.2.0
* Template Engine: Thymeleaf
* Build Tool: Maven

## Persistence Layer

Choice: In-Memory Storage (ConcurrentHashMap)

Reasoning:
For the purpose of this take-home assignment, I chose an in-memory approach to ensure the application is self-contained and easy to evaluate. It requires no external database setup (like Redis or Postgres) to run locally.

Note: Data will reset if the application is restarted.

## How to Run Locally

### Prerequisites

* Java 21 or higher installed.

### Steps

1. Clone the repository or download the source code.
2. Navigate to the project root directory.
3. Run the application using the Maven wrapper:
    ./mvnw spring-boot:run
4. The server will start on port 8081.
    * Home Page: http://localhost:8081/
    * Health Check: http://localhost:8081/api/healthz

## Testing Time Travel

The application supports deterministic testing for expiry logic via the TEST_MODE environment variable.

1. Set TEST_MODE=1 in your environment.
2. Send a request with the header x-test-now-ms containing a Unix timestamp (milliseconds).
3. The application will use this header value as the "current time" to validate TTL expiry.
