Contact Manager
===============

Um sistema robusto de gerenciamento de contatos desenvolvido com Spring Boot, fornecendo uma API RESTful para armazenar, pesquisar, atualizar e excluir informações de contato.

Visão Geral
-----------

Contact Manager é uma aplicação backend que permite aos usuários gerenciar eficientemente seus contatos através de uma API RESTful. O sistema oferece funcionalidades para criar, ler, atualizar e excluir contatos, com suporte para múltiplos números de telefone por contato.

## Tecnologias Utilizadas

[![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=flat&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat&logo=hibernate&logoColor=white)](https://hibernate.org/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Bean Validation](https://img.shields.io/badge/Bean%20Validation-008080?style=flat)](https://beanvalidation.org/)
[![RESTful API](https://img.shields.io/badge/RESTful%20API-005571?style=flat&logo=rest&logoColor=white)](https://restfulapi.net/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white)](https://www.postman.com/)
[![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white)](https://git-scm.com/)


Funcionalidades
---------------

-   **Gerenciamento Completo de Contatos**: Criar, visualizar, atualizar e excluir contatos
-   **Múltiplos Telefones**: Cada contato pode ter vários números de telefone associados
-   **Validação de Dados**: Validação de e-mail, formato de telefone e campos obrigatórios
-   **Tratamento de Erros**: Sistema abrangente de tratamento de exceções
-   **Prevenção de Duplicidade**: Verificação para evitar e-mails duplicados
-   **API RESTful**: Interface de programação seguindo as melhores práticas REST


Entidades de Banco de Dados
---------------------------

### Contact

-   `id`: Identificador único do contato
-   `name`: Nome do contato (obrigatório)
-   `email`: E-mail do contato (obrigatório, único)
-   `createdAt`: Data e hora de criação
-   `updatedAt`: Data e hora da última atualização
-   `phones`: Lista de telefones associados ao contato

### Phone

-   `id`: Identificador único do telefone
-   `number`: Número do telefone (formato: (XX) XXXXX-XXXX)
-   `contact`: Referência ao contato associado

API Endpoints
-------------

| Método HTTP | Endpoint | Descrição |
| --- | --- | --- |
| GET | /api/contacts | Lista todos os contatos |
| GET | /api/contacts/{id} | Obtém um contato específico |
| POST | /api/contacts | Cria um novo contato |
| PUT | /api/contacts/{id} | Atualiza um contato existente |
| DELETE | /api/contacts/{id} | Remove um contato |



---
Formato de Requisição e Resposta
--------------------------------

### ContactRequest (para criação/atualização)


`{    "name":  "Nome Completo",    "email":  "email@exemplo.com",    "phones":  [    {    "number":  "(11) 98765-4321"    },    {    "number":  "(11) 12345-6789"    }    ]  }`

### ContactResponse (retorno da API)


`{    "id":  1,    "name":  "Nome Completo",    "email":  "email@exemplo.com",    "createdAt":  "2023-01-01T12:00:00",    "updatedAt":  "2023-01-01T12:00:00",    "phones":  [    {    "id":  1,    "number":  "(11) 98765-4321"    },    {    "id":  2,    "number":  "(11) 12345-6789"    }    ]  }`

Validações
----------

-   **Nome**: Obrigatório, máximo de 100 caracteres
-   **Email**: Obrigatório, formato válido, único no sistema
-   **Telefone**: Formato validado por regex `^\\(\\d{2}\\) \\d{4,5}-\\d{4}$`

Tratamento de Erros
-------------------

A API retorna respostas de erro padronizadas:


`{    "status":  400,    "message":  "Mensagem de erro",    "timestamp":  "2023-01-01T12:00:00"  }`

Principais códigos de erro:

-   `400 Bad Request`: Dados inválidos
-   `404 Not Found`: Recurso não encontrado
-   `409 Conflict`: E-mail já cadastrado
-   `500 Internal Server Error`: Erro interno do servidor


---
Configuração e Execução
-----------------------

### Pré-requisitos

-   Java 8 ou superior
-   Maven
-   MySQL (ou outro banco de dados compatível com JPA)

### Variáveis de Ambiente

-   `DB_URL`: URL de conexão com o banco de dados
-   `DB_USERNAME`: Nome de usuário do banco de dados
-   `DB_PASSWORD`: Senha do banco de dados

### Passos para Execução

1.  Clone o repositório



    `git clone [url-do-repositorio] cd contact-manager`

2.  Configure o arquivo `application.properties` com suas credenciais de banco de dados ou use variáveis de ambiente
3.  Compile e execute o projeto

   

    `mvn clean install mvn spring-boot:run`

---
Conhecimentos consolidados:
-----------------------

 - RESTful API com Spring Boot e tratamento de erros

 - Spring Data JPA: entidades, repositórios e relacionamentos 1:N

 - Validação de dados e DTOs com ModelMapper

 - MySQL: modelagem, constraints e migrações via data.sql

 - Clean Code: separação MVC e nomenclatura clara

 - Gestão de dependências com Maven/Gradle



