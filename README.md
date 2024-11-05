# Quarkus Demo Service with CRUD APIs and PostgreSQL

This is a simple **Quarkus** application that demonstrates how to build a RESTful service with **CRUD** operations and
use **PostgreSQL** for data persistence.

The demo service manages a basic `Employee` entity with fields such as `first name`, `last name`,`email`, `salary`
and `join date`, exposing the following CRUD APIs:

- **Create**: Add new records.
- **Read**: Retrieve records (all or by ID).
- **Update**: Modify existing records.
- **Delete**: Remove records.

## Features

- **CRUD operations** using Quarkus and JAX-RS.
- **PostgreSQL** as the database.
- **Panache ORM** for simplified data access and repository handling.
- Uses **Quarkus Dev Mode** for fast development and testing.

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java 17+** (Recommended)
- **Maven 3.8+**
- **PostgreSQL** (either locally or via Docker)
- **Docker** (optional, for PostgreSQL container)

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/ahmed-baz/quarkus-demo-service.git
cd quarkus-demo-service
