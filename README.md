# Projeto de API com Docker, RabbitMQ e MySQL

Este projeto consiste em duas APIs construídas com Spring Boot: **User** e **Notify**. A API **User** gerencia o registro, autenticação e atualização de senha de usuários, armazenando os dados em um banco de dados MySQL e garantindo segurança com autenticação JWT. A comunicação entre **User** e **notify** é feita via RabbitMQ, permitindo o envio de mensagens de criação e atualização de usuários. Ambos os serviços, bem como MySQL e RabbitMQ, são executados em contêineres Docker, facilitando a configuração e execução do ambiente.

## Índice
1. Tecnologias Utilizadas
2. Estrutura do Projeto
3. Endpoints da API
4. Guia para Execução do Docker Compose


## 1 Tecnologias Utilizadas

- Spring Boot
- Docker e Docker Compose
- RabbitMQ (mensageria)
- MySQL (mensageria)
- JWT para autenticação
- Postman (para testes de API)


## 2 Estrutura do Projeto

- ***src/main/java/com.wallace.msusers.api*** =  Contém a arquitetura de camada da aplicação, responsáveis por gerenciar as requisições HTTP.


- ***src/main/java/com.wallace.msusers.domain.entities*** = Contém as entidades de domínio, que são representações dos objetos principais do sistema.
- 
- ***src/main/java/com.wallace.msusers.dto*** = Contém os objetos de transferência de dados (DTOs)


- ***src/main/java/com.wallace.msusers.exception*** = Contém classes relacionadas ao tratamento de exceções personalizadas.


- ***src/main/java/com.wallace.msusers.infra.rabbitmq*** = Contém a configuração e a lógica de integração com o RabbitMQ.


- ***src/main/java/com.wallace.msusers.infra.security*** = Contém as classes relacionadas à uso de JWT para proteger rotas da API.


## 3 Endpoints da API

### Registrar Usuário

**EndPoint:** POST /api/users/register

**Descrição:** Registra um novo usuário

![register](../desafio-3F/img/register.png)

### Pegar Token

**EndPoint:** POST /api/users/auth

**Descrição** pegar token para atualizar senha

![register](../desafio-3F/img/token.png)


### Autenticar e Atualizar senha


**EndPoint:** POST /api/users/update-password

**Descrição** autenticar token

![register](../desafio-3F/img/tokenVali.png)


**EndPoint:** POST /api/users/update-password

**Descrição** atualizar senha

![register](../desafio-3F/img/update.png)


## 4 Guia para Execução do Docker Compose

1. Clone o repositório do projeto em sua máquina:
   ```bash
   git clone https://github.com/rodrigueswallace/Projeto-de-API-com-Docker-RabbitMQ-e-MySQL.git
    ```
   
2. Verificando o Docker e docker compose:
    ```bash
    docker --version
    docker compose --version
    ```
3. Execute o comando:
    ```bash
    docker-compose up --build
    ```

Esse comando irá:

- Criar e iniciar os contêineres para MySQL, RabbitMQ e a aplicação.
- Configurar a rede para que os serviços possam se comunicar entre si.

4. Verifique se os serviços estão em execução:

- MySQL: Porta 3307
- RabbitMQ: Porta 5672
- API: Porta 8081

## Considerações Finais

- **Ambiente de Teste:** Utilize o Postman para fazer chamadas aos endpoints conforme descrito.

