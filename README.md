# 🛒 Product Management API

API REST desenvolvida com **Spring Boot** para gerenciamento de produtos, evoluída para um **sistema seguro com autenticação e autorização via Spring Security + JWT (Stateless)**.

O projeto começou como um CRUD simples e foi **progressivamente evoluído**, refletindo decisões reais de arquitetura, separação de responsabilidades e boas práticas usadas no mercado.

Voltado para **aprendizado prático**, **organização de código**, **segurança de APIs REST** e **preparação para consumo por frontends** (React, Angular, etc).

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- Hibernate
- PostgreSQL
- Docker & Docker Compose
- Maven

---

## 🔐 Segurança & Autenticação

A aplicação utiliza **Spring Security com autenticação JWT Stateless**, ou seja:

- A API **não mantém sessão**
- Cada requisição protegida exige um **token JWT válido**
- O token carrega a identidade do usuário
- A segurança é aplicada por **filtros**, não por sessões HTTP

### 📌 Fluxo de autenticação

```
Login → Geração do Token JWT
Cliente → Envia JWT no Header Authorization
Filtro de Segurança → Valida Token
Spring Security → Libera ou bloqueia acesso
```

Header esperado:
```
Authorization: Bearer <token>
```

---

## 🧱 Arquitetura do Projeto

```
controller → service → repository → database
      ↑         ↓
     DTOs     Entities
```

---

## 📦 Estrutura de Pacotes

```
com.example.Product_Management
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── dto
 ├── infra.security
 └── exception
```

---

## 📌 Endpoints

### 🔹 Login
POST `/auth/login`

### 🔹 Produtos (Protegidos)
- POST `/products`
- GET `/products`
- GET `/products/{id}`
- PUT `/products/{id}`
- DELETE `/products/{id}`

---

## 🐳 Docker & PostgreSQL

```yaml
version: "3.8"

services:
  postgres:
    image: postgres:16
    container_name: postgres_Product-Management
    restart: always
    environment:
      POSTGRES_DB: product-manager
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

---

## ⚙️ application.properties

```properties
spring.application.name=Product-Management

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.datasource.url=jdbc:postgresql://localhost:5432/product-manager
spring.datasource.username=postgres
spring.datasource.password=postgres

api.security.token.secret=seu-segredo-jwt
```

---

## ▶️ Como Executar

```bash
docker compose up -d
./mvnw spring-boot:run
```

---

## 👨‍💻 Autor

Daniel Duarte  
Projeto para estudo e evolução em **Java + Spring Boot + Spring Security**
