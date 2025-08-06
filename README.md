# Challenge forum 

Introdução ao Projeto: API de Cadastro de Usuários e Criação de topicos.<br><br>

Visão Geral <br><br>

Projeto desenvolvido para a conclusão do curso de Java e SpringBoot idezalizado por Alura e o programa Oracle One. <br>
A API conta com um sistema de CRUD para criação e gerenciamento de usuários e topicos. <br>
Para a criação de novos tópicos, o usuário precisa estar cadastrado e autenticado, informando um token fornecido pela API stateless.

## Tecnologias utilizadas

  - Java 21
  - SpringBoot 3.5.4
  - Spring Data JPA
  - Spring Security
  - Bean Validation
  - Spring Web
  - Flyway
  - Lombk
  - Java JWT 4.5.0
  - Spring Dev Tools
  - MySQL Driver

## Funcionalidades

  - Cadastro de usuários/tópicos
  - Atualização de usuários/tópicos
  - Listagem de usuários/tópicos
  - Deletar usuários/tópicos

## Endpoints

  - /hello
  - /login
  - /users
  - /users/{"id"}
  - /users/create
  - /topic
  - /topic/{"id"}

## Jsons usuários/tópicos
  
  ### Criar usuário método: POST
  
  - /users/create

Todos os campos são obrigatórios
  
```bash
  {
    "name" : "Felipe rodrigues",
    "email": "felipe@email.com",
    "password": "12345678"  
  }

```
### Login usuário método: POST
  
  - /login

Todos os campos são obrigatórios
```bash
  {
    "login" : "felipe@email.com",
    "password" : "12345678"
  }
```

### Criar topico método: POST

  - /topic

Todos os campos são obrigatórios

```bash
  {
    "title": "Error: 500 bad credentials",
    "message" : "Não consigo saber de onde o erro vem",
    "status": "Ativo",
    "response": "Não resolvido",
    "course": "NODEJS",
    "userId" : 1 // <- Id do usuario que foi criado na etapa de login
  }
```


### Listar usuários método: GET

- /users

### Listar usuários por Id método: GET

- /users/{"id"}

### Listar tópicos método: GET

  - /topic

### Listar tópicos por Id método: GET

  - /topic/{"id"}

### Atualizar usuário por Id método: PUT
  
  - /users
    
```bash
  {
    "id": 1, // <- Campo Obrigatorio
    "name": Felipe candito, // <- Campo opcional
    "password": "87654321" // <- Campo opcional
  }

```
### Atualizar tópicos por Id método: PUT
  
  - /users
    
```bash
  {
    "id": 1, // <- Campo Obrigatorio
    "message": "Erro solucionado", // <- Campo opcional
    "response": "A entidade estava retornando uma bad credentials", // <- Campo opcional
    "status" : "Respondido" // <- Campo opcional
  }

```
### Deletar usuário por id método: DELETE

  - /users/{"id"}

### Deletar topico por id método: DELETE

  - /topico/{"id"}












































