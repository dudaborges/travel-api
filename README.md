# Travel API

A Travel API é uma API RESTful desenvolvida para uma agência de viagens. Ela permite que os clientes e parceiros interajam com o sistema da agência, oferecendo funcionalidades para cadastrar, listar, pesquisar, visualizar, avaliar e excluir destinos de viagem.

## Funcionalidades

A API oferece os seguintes endpoints:

- **Cadastrar destinos de viagem**: Adicionar novos destinos à base de dados.
- **Listar destinos de viagem**: Obter a lista de todos os destinos disponíveis.
- **Pesquisar destinos**: Buscar destinos por nome ou localização.
- **Visualizar informações detalhadas sobre um destino**: Obter informações detalhadas sobre um destino específico.
- **Avaliar destinos**: Alterar a avaliação média de um destino.
- **Excluir destinos de viagem**: Remover destinos da base de dados.

## Tecnologias

- **Java**
- **Spring Boot**
- **Maven**

## Endpoints da API

### 1. Cadastrar destino de viagem

- **Método**: `POST`
- **Endpoint**: `/api/destinations`
- **Descrição**: Adiciona um novo destino.
- **Body** (JSON):
  ```json
  {
    "name": "Paris",
    "location": "França",
    "description": "Cidade das luzes, conhecida por sua arte, cultura e gastronomia.",
    "price": 1200.00,
    "rating": 8.5
  }
  ```

### 2. Listar destinos de viagem

- **Método**: `GET`
- **Endpoint**: `/api/destinations`
- **Descrição**: Retorna a lista de todos os destinos disponíveis.

### 3. Pesquisar destinos

- **Método**: `GET`
- **Endpoint**: `/api/destinations/search`
- **Descrição**: Pesquisa destinos por nome ou localização.
- **Query Parameters**:
  - `name`: Nome do destino.
  - `location`: Localização do destino.

### 4. Visualizar informações de um destino

- **Método**: `GET`
- **Endpoint**: `/api/destinations/{id}`
- **Descrição**: Retorna informações detalhadas de um destino específico.
- **Parâmetros**:
  - `id`: ID do destino.

### 5. Avaliar destino

- **Método**: `PATCH`
- **Endpoint**: `/api/destinations/{id}/rating`
- **Descrição**: Atualiza a avaliação de um destino.
- **Parâmetros**:
  - `id`: ID do destino.
- **Body** (JSON):
  ```json
  {
    "rating": 9.0
  }
  ```

### 6. Excluir destino de viagem

- **Método**: `DELETE`
- **Endpoint**: `/api/destinations/{id}`
- **Descrição**: Exclui um destino específico.
- **Parâmetros**:
  - `id`: ID do destino.

## Como rodar a aplicação

1. **Pré-requisitos**:
   - Java 17 ou superior.
   - Maven 3.6 ou superior.

2. **Clonar o repositório**:
   ```bash
   git clone https://github.com/dudaborges/travel-api
   ```

3. **Entrar na pasta do projeto**:
   ```bash
   cd travel-api
   ```

4. **Compilar e rodar o projeto**:
   ```bash
   mvn spring-boot:run
   ```

   A aplicação será iniciada e estará disponível em `http://localhost:8080`.

## Testando a API

Você pode testar a API usando ferramentas como **Postman** ou **curl**.

### Exemplo de `POST` para adicionar um destino:

```bash
curl -X POST http://localhost:8080/api/destinations \
-H "Content-Type: application/json" \
-d '{
  "name": "Paris",
  "location": "França",
  "description": "Cidade das luzes, conhecida por sua arte, cultura e gastronomia.",
  "price": 1200.00,
  "rating": 8.5
}'
```

### Exemplo de `PATCH` para atualizar a avaliação de um destino:

```bash
curl -X PATCH http://localhost:8080/api/destinations/1/rating \
-H "Content-Type: application/json" \
-d '{
  "rating": 9.0
}'
```
