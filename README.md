# 🛒 Product Management API

API REST desenvolvida com **Spring Boot** para gerenciamento de produtos, implementando **CRUD completo**, utilizando **DTOs**, **Spring Data JPA**, **PostgreSQL em Docker** e boas práticas de arquitetura.

Projeto voltado para **aprendizado**, **organização de código**, **padrões REST** e **preparação para consumo por frontends** (React, Angular, etc).

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker & Docker Compose
- Maven

---

## 🧱 Arquitetura do Projeto

O projeto segue o padrão de camadas:

```
controller → service → repository → database
      ↑         ↓
     DTOs     Entities
```

### 📦 Estrutura de Pacotes

```
com.example.Product_Management
 ├── controller
 │    └── ProductController
 ├── service
 │    └── ProductService
 ├── repository
 │    └── ProductRepository
 ├── model
 │    └── Product
 ├── dto
 │    ├── ProductRequestDTO
 │    └── ProductResponseDTO
 └── exception
      └── ResourceNotFoundException
```

---

## 🔁 Uso de DTO

A API não expõe diretamente a entidade do banco de dados.

- **ProductRequestDTO** → Entrada de dados (`POST`, `PUT`)
- **ProductResponseDTO** → Saída de dados (`GET`, respostas de `POST` e `PUT`)

Fluxo de dados:

```
Cliente → RequestDTO → Service → Entity → Repository
Repository → Entity → Service → ResponseDTO → Cliente
```

---

## 📌 Endpoints da API

### 🔹 Criar produto
**POST** `/products`

Request Body:
```json
{
  "nameProduct": "Teclado",
  "descriptionProduct": "Teclado mecânico",
  "priceProduct": 199.90
}
```

Response:
```json
{
  "id": "uuid-gerado",
  "nameProduct": "Teclado",
  "descriptionProduct": "Teclado mecânico",
  "priceProduct": 199.90
}
```

Status: **201 Created**

---

### 🔹 Listar todos os produtos
**GET** `/products`

Status: **200 OK**

---

### 🔹 Buscar produto por ID
**GET** `/products/{id}`

Status:
- **200 OK**
- **404 Not Found**

---

### 🔹 Atualizar produto
**PUT** `/products/{id}`

Request Body:
```json
{
  "nameProduct": "Produto atualizado",
  "descriptionProduct": "Nova descrição",
  "priceProduct": 299.90
}
```

Status: **200 OK**

---

### 🔹 Deletar produto
**DELETE** `/products/{id}`

Status:
- **204 No Content**
- **404 Not Found**

---

## 🐳 Docker & PostgreSQL

### 📦 docker-compose.yml

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

## ⚙️ Configuração do Spring Boot

Arquivo `application.properties`:

```properties
spring.application.name=Product-Management

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.datasource.url=jdbc:postgresql://localhost:5432/product-manager
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

## ▶️ Como Executar o Projeto

### 1️⃣ Subir o PostgreSQL com Docker
```bash
docker compose up -d
```

### 2️⃣ Rodar a aplicação
```bash
./mvnw spring-boot:run
```

A aplicação ficará disponível em:
```
http://localhost:8080
```

---

## 🔍 Acesso ao Banco de Dados

- Host: localhost
- Porta: 5432
- Database: product-manager
- Usuário: postgres
- Senha: postgres

Ferramentas recomendadas:
- DBeaver
- pgAdmin
- DataGrip

---

## 📈 Próximas Evoluções

- Validações com `@Valid`
- Padronização de erros em JSON
- Paginação e ordenação
- Autenticação com Spring Security
- Testes unitários e de integração
- Integração com frontend React

---

## 👨‍💻 Autor

**Daniel Duarte**  
Projeto desenvolvido para estudo e evolução em **Java + Spring Boot**.