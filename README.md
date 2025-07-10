# Spring Security JWT Authentication

Este projeto é uma API REST simples para demonstrar autenticação e autorização usando Spring Security e JWT (JSON Web Tokens).

## Visão Geral

O sistema permite:

- Cadastro de novos usuários
- Autenticação de usuários com geração de tokens JWT
- Acesso a rotas protegidas mediante apresentação de tokens JWT válidos

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.3
- Spring Security
- Spring Data JPA
- H2 Database (em memória)
- Auth0 Java JWT (4.4.0)
- Lombok
- Maven

## Endpoints da API

### Públicos (não requerem autenticação)

- `POST /auth/register` - Registro de novos usuários
- `POST /auth/login` - Login de usuários e obtenção de token JWT

### Protegidos (requerem autenticação via token JWT)

- Todas as outras rotas da aplicação requerem autenticação

## Como Usar

### Cadastrando um Novo Usuário

```http
POST /auth/register
Content-Type: application/json

{
  "name": "Nome do Usuário",
  "email": "usuario@exemplo.com",
  "password": "senha123"
}
```

### Autenticação e Obtenção do Token JWT

```http
POST /auth/login
Content-Type: application/json

{
  "email": "usuario@exemplo.com",
  "password": "senha123"
}
```

Resposta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Acessando Rotas Protegidas

```http
GET /api/alguma-rota-protegida
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

## Configuração do Banco de Dados

O projeto utiliza um banco de dados H2 em memória para facilitar os testes. As configurações podem ser encontradas em `application.yaml`.

## Executando o Projeto

Para executar o projeto, utilize o seguinte comando:

```bash
mvn spring-boot:run
```

O servidor estará disponível em: `http://localhost:8080`

## Segurança

- A API utiliza BCrypt para a criptografia segura de senhas
- A autenticação é stateless (sem sessão no servidor)
- Tokens JWT são utilizados para autenticar requisições subsequentes
- CSRF está desativado para facilitar as chamadas REST
