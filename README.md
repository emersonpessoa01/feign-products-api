# 🧪 API de Produtos com Spring Boot, Feign Client, DTOs e Validação

Este projeto é uma aplicação REST desenvolvida com **Spring Boot** que consome dados da [API pública DummyJSON](https://dummyjson.com), utilizando **Feign Client**, **DTOs** e **validações personalizadas**.

---

## Topo



## 📌 Tabela de Conteúdos

- [Testes com Insomnia](#testes-com-insomnia)
- [Objetivo](#objetivo)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Validações e Tratamento de Erros](#validações-e-tratamento-de-erros)
- [Métricas e Logs](#métricas-e-logs)
- [Critérios de Avaliação](#critérios-de-avaliação)
- [Autor](#autor)

---

## Testes com Insomnia

Esta API pode ser testada diretamente com o Insomnia. Importando a collection, você terá os endpoints `/ping` e `/products` já configurados com exemplos válidos e inválidos.

[//]: # ([⬇️ Clique aqui para baixar o arquivo insomnia-collection.json]&#40;insomnia/insomnia-collection.json&#41;)

[//]: # (<a href="insomnia/insomnia-collection.json" download>)

[//]: # (<img src="https://img.shields.io/badge/Baixar%20Insomnia%20JSON-Download-blue?style=for-the-badge&logo=insomnia" alt="Download Insomnia JSON">)

[//]: # (</a>)

[![Baixar JSON do Insomnia](https://img.shields.io/badge/Baixar%20Insomnia%20JSON-Download-blue?style=for-the-badge&logo=insomnia)](https://github.com/emersonpessoa01/feign-products-api/blob/master/insomnia/insomnia-collection.yaml)



[🔝 Voltar ao topo](#topo)




---

## Objetivo

Criar uma aplicação Java utilizando Spring Boot com os seguintes requisitos:

- Consumir um endpoint externo via **Feign Client**
- Criar e utilizar **DTOs (Data Transfer Objects)**
- Implementar **validações de entrada**
- Retornar erros adequados com mensagens claras
- Logar o **tempo de execução da requisição**

[🔝 Voltar ao topo](#topo)

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3+
- Spring Web
- Spring Validation
- OpenFeign
- Lombok
- Maven
- API externa: [https://dummyjson.com](https://dummyjson.com)

[🔝 Voltar ao topo](#topo)

---

## Estrutura do Projeto

| Item                             | Descrição                                      |
| -------------------------------- | ---------------------------------------------- |
| `ProductRequestDTO.java`         | Entrada da requisição POST com validações      |
| `ProductResponseDTO.java`        | Estrutura para a resposta vinda da API externa |
| `ResourceNotFoundException.java` | Exceção customizada para 404                   |
| `ApiExceptionHandler.java`       | Captura e responde erros com status e mensagem |
| `ProductClient.java`             | FeignClient para `dummyjson.com`               |
| `ProductService.java`            | Camada de serviço com filtragem de produtos    |
| `ProductController.java`         | Endpoint POST com `@Valid`                     |
[🔝 Voltar ao topo](#topo)

---

## Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Maven
- IDE (IntelliJ, Eclipse ou VS Code)

[🔝 Voltar ao topo](#topo)


### Passos

```bash
# Clone o repositório
git clone https://git.raroacademy.com.br/emerson.pessoa/feign-products-api.git

# Acesse a pasta do projeto
cd feign-products-api

# Execute o projeto
./mvnw spring-boot:run
```
[🔝 Voltar ao topo](#topo)

---

## Funcionalidades Implementadas

### ✅ Endpoint Implementado

```
POST /products
```

### Corpo da Requisição (ProductRequestDTO)

```json
{
  "price": 800,
  "stock": 10,
  "category": "smartphones"
}
```

### Resposta Esperada (ProductResponseDTO[])

```json
[
  {
    "id": 1,
    "title": "iPhone 9",
    "description": "An apple mobile which is nothing like apple",
    "price": 549,
    "rating": 4.69,
    "stock": 94,
    "brand": "Apple",
    "category": "smartphones"
  }
]
```
[🔝 Voltar ao topo](#topo)

---

## Validações e Tratamento de Erros

### 🔎 Regras de Validação

- `category`: obrigatório  
- `stock`: deve ser maior que 0  
- `price`: deve ser > 0 e < 2000  

### Tabela de Tratamento de Erros

| Situação                       | Código HTTP | Mensagem                                                                                       |
|-------------------------------|-------------|------------------------------------------------------------------------------------------------|
| DTO inválido                  | 400         | `"Campo 'category' é obrigatório."`                                                            |
| Nenhum produto encontrado     | 404         | `"Produtos da categoria {category} com estoque >= {stock} e preço < {price} não encontrados."` |
| Falha de comunicação com a API| 502         | `"Erro ao acessar a API externa."`                                                             |

[🔝 Voltar ao topo](#topo)

---

## Métricas e Logs

O tempo de execução da requisição ao FeignClient é registrado em log para fins de análise de desempenho.


#### Exemplo de log:

```text
[INFO ] - Tempo de resposta da API externa: 142 ms
```
[🔝 Voltar ao topo](#topo)

---

## Critérios de Avaliação

| Critério                          | Peso |
| --------------------------------- | ---- |
| Estrutura do projeto (Clean Code) | 15%  |
| Uso correto do Feign Client       | 25%  |
| Criação e uso de DTOs             | 20%  |
| Aplicação de validações           | 20%  |
| Tratamento de erros               | 20%  |

[🔝 Voltar ao topo](#topo)

---

## Autor

Desenvolvido por **Emerson Pessoa**  
📧 emersonpessoa05102008@gmail.com  
🌐 [linkedin.com/in/emersonpessoa01](https://linkedin.com/in/emersonpessoa01)

[🔝 Voltar ao topo](#topo)
