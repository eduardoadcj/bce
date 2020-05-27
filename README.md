# bce-api
Uma API simples para ter acesso as cidades e estados do Brasil.

A API garante acesso a informações convencionais para o pre preenchimento de formulários de endereço, sem a necessidade de armazenar os
dados internamente na aplicação ou lidar com APIs que possuem uma estrutura de dados de saída mais complexa.

A base de dados foi alimentada usando como fonte de dados a [API de localidades do IBGE](https://servicodados.ibge.gov.br/api/docs/localidades?versao=1)

## Como utilizar
A ferramenta esta disponível atualmente no endereço:
```
http://eacjserver.ddns.net:8450/bce
```
### Estados

Para obter todos os estados do Brasil, acesse **GET**:
```
http://eacjserver.ddns.net:8450/bce/estados
```
Em status 200, a estrutura de dados retornada é uma lista de estados:
```json
[
  {
    "id": 0,
    "nome": "",
    "uf": ""
  }
]
```


Para ober os estados e suas respectivas cidades, acesse **GET**:
```
http://eacjserver.ddns.net:8450/bce/estados/cidades
```
Em status 200, a estrutura de dados retornada é uma lista de estados onde cada estado contem uma lista de cidades:
```json
[
  {
    "id": 0,
    "nome": "",
    "uf": "",
    "cidades": [
      {
        "id": 0,
        "nome": ""
      }
    ]
  }
]
```

### Cidades
Para obter todas as cidades do Brasil, acesse **GET**:
```
http://eacjserver.ddns.net:8450/bce/cidades
```
Em status 200, uma lista é retornada com a estrutura de dados a seguir:
```json
[
  {
    "id": 0,
    "nome": "",
    "estado": {
       "id": 0,
        "nome": "",
        "uf": ""
    }
  }
]
```
Para obter as cidades de um estado em específico, acesse **GET**:
```
http://eacjserver.ddns.net:8450/bce/cidades/{UF}
```
Onde {UF} refere-se ao UF do estado a qual as cidades listadas pertencem.

Em status 200, retorna uma lista na estrutura de dados a seguir:
```json
[
  {
    "id": 0,
    "nome": "",
    "estado": {
       "id": 0,
        "nome": "",
        "uf": ""
    }
  }
]
```

## Tecnologias

Desenvolvido utilizando a linguagem Java e a base de dados MySQL. Foram utilizadas para desenvolvimento as bibliotecas e frameworks:

- Spring Boot
- Spring Data JPA
- Spring Web
- FlywayDB
- Model Mapper
