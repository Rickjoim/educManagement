
---

# API Documentation

## Overview

This API allows managing a consultancy for teachers with CRUD operations for teacher, student, and class.

### Base URL
```
http://localhost:8080/
```
## Authentication
Endpoints require authentication via token. Send the token in the request header:

```
Authorization: Bearer {your_token}
```
---

## Endpoints
### 1. **Login**
**POST** `/login`

#### Request Example
```bash
curl -X POST {baseURL}/login \
-H "Content-Type: application/json" \
-d '{
    "login": "teste",
    "senha":"teste"
}'
```
#### Response Example
**HTTP 200 OK**
```json
{
  "tokenJWT": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZSIsImlzcyI6IkFQSSBlZHVjIiwiZXhwIjoxNzM1OTQxNDgwfQ.88vsGRLkJYebiZLGEhIaCHiyaF0JMObgMtXEXAqta_E"
}
```

### 2. **Create Teacher**
**POST** `/professores`

#### Request Example
```bash
curl -X POST {baseURL}/professores \
-H "Content-Type: application/json" \
-d '{
    "nome": "Ricardo",
    "email":"email8@teste.com",
    "cpf":"70982436475",
    "especialidade":"PORTUGUES",
    "telefone": "84954125768",
    "endereco":{
        "logradouro":"rua teste",
        "bairro":"potengi",
        "cep":"59120596",
        "cidade":"natal",
        "uf":"rn",
        "numero":"50",
        "complemento":"primeiro andar"
    }
}'
```

#### Response Example
**HTTP 201 Created**
```json
{
  "nome": "Ricardo",
  "email":"email8@teste.com",
  "cpf":"70982436475",
  "especialidade":"PORTUGUES",
  "telefone": "84954125768",
  "endereco":{
    "logradouro":"rua teste",
    "bairro":"potengi",
    "cep":"59120596",
    "cidade":"natal",
    "uf":"rn",
    "numero":"50",
    "complemento":"primeiro andar"
  }
}
```

---

### 3. **List Teacher**
**GET** `/professores`

#### Request Example
```bash
curl -X GET {baseURL}/professores
```

#### Response Example
**HTTP 200 OK**
```json
{
  "content": [
    {
      "id": 1,
      "nome": "Ricardo",
      "email": "email8@teste.com",
      "cpf": "70982436475",
      "especialidade": "PORTUGUES"
    },
    {
      "id": 5,
      "nome": "Ricardo",
      "email": "email10@teste.com",
      "cpf": "70982436477",
      "especialidade": "PORTUGUES"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 2,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "numberOfElements": 2,
  "first": true,
  "empty": false
}
```
---

### 4. **Find Teacher by CPF**
**GET** `/professores/{cpf}`

#### Request Example
```bash
curl -X GET {baseURL}/professores/{cpf}
```

#### Response Example
**HTTP 200 OK**
```json
{
  "id": 5,
  "nome": "Ricardo",
  "email": "email10@teste.com",
  "cpf": "70982436477",
  "especialidade": "PORTUGUES"
}   
```

---

### 5. **Update Teacher**
**PUT** `{baseURL}/Teaches`

#### Request Example
```bash
curl -X PUT {baseURL}/professores \
-H "Content-Type: application/json" \
-d '{
    "id": 5,
    "nome": "Carlos"
}'
```

#### Response Example
**HTTP 200 OK**
```json
{
  "id": 5,
  "nome": "Carlos",
  "email": "email10@teste.com",
  "cpf": "70982436477",
  "telefone": "84954125768",
  "especialidade": "PORTUGUES",
  "endereco": {
    "logradouro": "rua teste",
    "bairro": "potengi",
    "cep": "59120596",
    "numero": "50",
    "complemento": "primeiro andar",
    "cidade": "natal",
    "uf": "rn"
  }
}
```

---

### 6. **Delete Teacher**
**DELETE** `/professores/{id}`

#### Request Example
```bash
curl -X DELETE {baseurl}/professores/1
```

#### Response Example
**HTTP 204 No Content**

---

### 7. **Create student**
**POST** `/alunos`

#### Request Example
```bash
curl -X POST {baseURL}/alunos \
-H "Content-Type: application/json" \
-d '{
    "nome": "rickson",
    "email":"email3@teste.com",
    "telefone": "987063827",
    "endereco":{
        "logradouro":"rua teste",
        "bairro":"potengi",
        "cep":"59120596",
        "cidade":"natal",
        "uf":"rn",
        "numero":"50",
        "complemento":"primeiro andar"
    }
}'
```

#### Response Example
**HTTP 201 Created**
```json
{
  "nome": "rickson",
  "email":"email3@teste.com",
  "telefone": "987063827",
  "endereco":{
    "logradouro":"rua teste",
    "bairro":"potengi",
    "cep":"59120596",
    "cidade":"natal",
    "uf":"rn",
    "numero":"50",
    "complemento":"primeiro andar"
  }
}
```

---

### 8. **List Students**
**GET** `/alunos`

#### Request Example
```bash
curl -X GET {baseURL}/alunos
```

#### Response Example
**HTTP 200 OK**
```json
{
  "content": [
    {
      "id": 1,
      "nome": "rickson",
      "email": "email3@teste.com"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
```
---

### 9. **Find students by name**
**GET** `/alunos/{nome}`

#### Request Example
```bash
curl -X GET {baseURL}/alunos/{nome}
```

#### Response Example
**HTTP 200 OK**
```json
{
  "id": 1,
  "nome": "rickson",
  "email": "email3@teste.com"
}   
```

---

### 10. **Update Students**
**PUT** `{baseURL}/alunos`

#### Request Example
```bash
curl -X PUT {baseURL}/alunos \
-H "Content-Type: application/json" \
-d '{
    "id": 1,
    "nome": "Rickson"
}'
```

#### Response Example
**HTTP 200 OK**
```json
{
  "id": 1,
  "nome": "Rickson",
  "email": "email3@teste.com",
  "telefone": "987063827",
  "endereco": {
    "logradouro": "rua teste",
    "bairro": "potengi",
    "cep": "59120596",
    "numero": "50",
    "complemento": "primeiro andar",
    "cidade": "natal",
    "uf": "rn"
  }
}
```

---

### 11. **Delete Students**
**DELETE** `/alunos/{id}`

#### Request Example
```bash
curl -X DELETE {baseurl}/alunos/1
```

#### Response Example
**HTTP 204 No Content**

---

### 12. **Create Class**
**POST** `/aula`

#### Request Example
```bash
curl -X POST {baseURL}/aula \
-H "Content-Type: application/json" \
-d '{
  "data": "2024-12-27T11:30:00",
  "observacao": "Aula teste.",
  "endereco": {
    "logradouro":"rua teste",
    "numero": "508",
    "bairro": "Petropolis",
    "cidade": "Natal",
    "uf": "RN",
    "cep": "59000-000",
    "complemento": "Próximo ao hospital central"
  },
  "professorId": 5,
  "alunoId": 1
}'
```

#### Response Example
**HTTP 201 Created**
```json
{
  "id": 1,
  "data": "2024-12-27T11:30:00.000+00:00",
  "endereco": {
    "logradouro": "rua teste",
    "bairro": "Petropolis",
    "cep": "59000-000",
    "numero": "508",
    "complemento": "Próximo ao hospital central",
    "cidade": "Natal",
    "uf": "RN"
  },
  "observacao": "Aula teste.",
  "ativo": true,
  "professor": {
    "id": 5,
    "nome": "Carlos",
    "telefone": "84954125768",
    "email": "email10@teste.com",
    "cpf": "70982436477",
    "ativo": true,
    "especialidade": "PORTUGUES",
    "endereco": {
      "logradouro": "rua teste",
      "bairro": "potengi",
      "cep": "59120596",
      "numero": "50",
      "complemento": "primeiro andar",
      "cidade": "natal",
      "uf": "rn"
    }
  },
  "aluno": {
    "id": 1,
    "nome": "Rickson",
    "telefone": "987063827",
    "email": "email3@teste.com",
    "ativo": true,
    "endereco": {
      "logradouro": "rua teste",
      "bairro": "potengi",
      "cep": "59120596",
      "numero": "50",
      "complemento": "primeiro andar",
      "cidade": "natal",
      "uf": "rn"
    }
  }
}
```

---

### 13. **List Class**
**GET** `/aula`

#### Request Example
```bash
curl -X GET {baseURL}/aula
```

#### Response Example
**HTTP 200 OK**
```json
{
  "content": [
    {
      "id": 1,
      "data": "2024-12-27T11:30:00.000+00:00",
      "observacao": "Aula teste.",
      "professor": {
        "id": 5,
        "nome": "Carlos",
        "email": "email10@teste.com",
        "cpf": "70982436477",
        "especialidade": "PORTUGUES"
      },
      "aluno": {
        "id": 1,
        "nome": "Rickson",
        "email": "email3@teste.com"
      },
      "endereco": {
        "logradouro": "rua teste",
        "bairro": "Petropolis",
        "cep": "59000-000",
        "cidade": "Natal",
        "uf": "RN",
        "complemento": "Próximo ao hospital central",
        "numero": "508"
      }
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalElements": 1,
  "totalPages": 1,
  "first": true,
  "numberOfElements": 1,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "empty": false
}
```
---

### 14. **Find Class by id**
**GET** `/aula/{id}`

#### Request Example
```bash
curl -X GET {baseURL}/aula/{id}
```

#### Response Example
**HTTP 200 OK**
```json
{
  "id": 1,
  "data": "2024-12-27T11:30:00.000+00:00",
  "observacao": "Aula teste.",
  "professor": {
    "id": 5,
    "nome": "Carlos",
    "email": "email10@teste.com",
    "cpf": "70982436477",
    "especialidade": "PORTUGUES"
  },
  "aluno": {
    "id": 1,
    "nome": "Rickson",
    "email": "email3@teste.com"
  },
  "endereco": {
    "logradouro": "rua teste",
    "bairro": "Petropolis",
    "cep": "59000-000",
    "cidade": "Natal",
    "uf": "RN",
    "complemento": "Próximo ao hospital central",
    "numero": "508"
  }
}   
```

---

### 15. **Update Class**
**PUT** `{baseURL}/aula`

#### Request Example
```bash
curl -X PUT {baseURL}/aula \
-H "Content-Type: application/json" \
-d '{
  "id": 1,
  "data": "2024-12-30T11:30:00",
  "observacao": "teste de edicao da aula."
}'
```

#### Response Example
**HTTP 200 OK**
```json
{
  "id": 1,
  "data": "2024-12-30T11:30:00.000+00:00",
  "observacao": "teste de edicao da aula.",
  "endereco": null
}
```

---

### 16. **Delete Class**
**DELETE** `/aula/{id}`

#### Request Example
```bash
curl -X DELETE {baseurl}/aula/1
```

#### Response Example
**HTTP 204 No Content**

---

