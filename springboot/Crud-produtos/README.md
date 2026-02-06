CRUD DE PRODUTOS – SPRING BOOT + AZURE APP SERVICE

URL EM PRODUÇÃO:
https://bootcamp-azure-e8g8btc9b6bahphz.brazilsouth-01.azurewebsites.net/

==================================================

DESCRIÇÃO DO PROJETO

Este projeto consiste em uma aplicação backend desenvolvida em Java com Spring Boot,
responsável por realizar o gerenciamento completo (CRUD) de produtos.

A aplicação foi desenvolvida para:
- Rodar localmente em ambiente de desenvolvimento
- Ser publicada em produção no Microsoft Azure App Service (Linux + Java 17)

O sistema disponibiliza uma API REST e também uma interface web simples para interação
direta pelo navegador.

==================================================

FUNCIONALIDADES

- Criar produtos
- Listar produtos
- Buscar produto por ID
- Atualizar produtos
- Remover produtos
- Validação de regras de negócio (preço válido)
- Persistência de dados
- Interface web simples para uso do CRUD
- Documentação da API via Swagger

==================================================

TECNOLOGIAS UTILIZADAS

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger)
- Maven
- Azure App Service (Linux)
- HTML + JavaScript

==================================================

ESTRUTURA DO PROJETO

src
 └── main
     ├── java/com/example/demo
     │   ├── controller
     │   │   ├── ProdutoController.java
     │   │   └── HomeController.java
     │   ├── service
     │   │   ├── ProdutoService.java
     │   │   └── impl
     │   │       ├── ProdutoServiceImpl.java
     │   │       └── ProdutoServiceComDescontoImpl.java
     │   ├── repository
     │   ├── model
     │   ├── dto
     │   └── exception
     └── resources
         ├── application.yml
         └── static
             └── index.html

==================================================

REQUISITOS PARA EXECUÇÃO LOCAL

- Java JDK 17 ou superior
- Maven 3.9 ou superior
- Git

==================================================

COMO EXECUTAR O PROJETO LOCALMENTE

1) Clonar o repositório

git clone https://github.com/seu-usuario/seu-repositorio.git
cd Crud-produtos

--------------------------------------------------

2) Gerar o JAR da aplicação

mvn clean package -DskipTests

--------------------------------------------------

3) Executar o projeto

java -jar target/Crudprodutos-0.0.1-SNAPSHOT.jar

--------------------------------------------------

4) Acessar localmente

Aplicação:
http://localhost:8080

Swagger:
http://localhost:8080/swagger-ui.html

Interface Web:
http://localhost:8080/

==================================================

ENDPOINTS DA API

GET     /produtos
GET     /produtos/{id}
POST    /produtos
PUT     /produtos/{id}
DELETE  /produtos/{id}

==================================================

BANCO DE DADOS

A aplicação utiliza o banco H2 em modo arquivo.

Local:
jdbc:h2:file:./data/produtos-db

Azure:
jdbc:h2:file:/home/data/produtos-db

O diretório /home é persistente no Azure App Service.

==================================================

REGRAS DE NEGÓCIO

- O preço do produto:
  - Não pode ser nulo
  - Deve ser maior que zero
  - É armazenado com duas casas decimais

==================================================

EXECUÇÃO EM PRODUÇÃO (AZURE)

CONFIGURAÇÃO DO AMBIENTE

- Sistema Operacional: Linux
- Runtime: Java SE
- Versão do Java: 17
- Plano: B1

--------------------------------------------------

VARIÁVEIS DE AMBIENTE NO AZURE

WEBSITES_PORT=8080

--------------------------------------------------

DEPLOY NO AZURE (USANDO AZURE CLI)

Gerar o JAR:

mvn clean package -DskipTests

Deploy:

az webapp deploy \
  --resource-group rg-bootcamp-azure \
  --name bootcamp-azure \
  --type jar \
  --src-path target/Crudprodutos-0.0.1-SNAPSHOT.jar

Reiniciar a aplicação:

az webapp restart --resource-group rg-bootcamp-azure --name bootcamp-azure

--------------------------------------------------

ACESSO EM PRODUÇÃO

Aplicação:
https://bootcamp-azure-e8g8btc9b6bahphz.brazilsouth-01.azurewebsites.net/

Swagger:
https://bootcamp-azure-e8g8btc9b6bahphz.brazilsouth-01.azurewebsites.net/swagger-ui.html

==================================================

APRENDIZADOS

- Desenvolvimento de API REST com Spring Boot
- Boas práticas de separação de camadas
- Resolução de conflitos de beans com @Primary
- Deploy de aplicações Java no Azure App Service
- Uso de variáveis de ambiente em produção
- Persistência de dados em ambiente Linux

==================================================

LICENÇA

Projeto desenvolvido para fins educacionais.

==================================================

AUTOR

Edgar Baudel
