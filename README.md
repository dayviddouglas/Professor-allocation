# Professor-allocation-API
## Sobre o Projeto:
Projeto desenvolvido como parte da pós-graduação em Engenharia de Software na Faculdade Fafire. O sistema Professor Allocation gerencia a alocação de professores às disciplinas em uma instituição de ensino. Permite cadastro, edição e exclusão de professores, disciplinas e alocações, buscando organizar e evitar conflitos de horários.

## Tecnologias Utilizadas:
Java: 17+
Spring Boot: 3.0.3
MySQL: 8.0

### Principais Funcionalidades
- Cadastro de professores
- Cadastro de Cursos
- Cadastro de Departamentos
- Registro de alocações entre professores e cursos
- Garantia de ausência de conflitos nas alocações.

## Pré-requisitos:
- Java 17 instalado.
- Banco de dados MySQL 8.0 configurado.
- Maven ou Gradle instalado.

## Instalação

### Clone este repositório:
  ```bash
  git clone https://github.com/dayviddouglas/Professor-allocation.git
  ```

 ### Configure o **application.properties** com os dados do MySQL:

```bash
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/db_allocation?useTimezone=true&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=[seu_login]
spring.datasource.password=[sua_senha]

spring.jpa.show-sql=true
spring.jpa.generate-ddl=true

spring.mvc.pathmatch.matching-strategy=ant_path_matcher
  ```
### Execute o projeto:

```bash
mvnw spring-boot:run
 ```
## Documentação e Testes
A API pode ser explorada com Swagger ou Postman.

- Endpoint do Swagger:
```bash
http://localhost:8080/swagger-ui/index.html#/
 ```
## Contribuição:

- Fork este repositório.

- Crie um branch com sua feature: git checkout -b minha-feature

- Faça commit de suas alterações.

- Envie um pull request.
