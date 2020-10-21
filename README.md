# API rest para retornar registros de Unidades basicas de saude, JAVA 12, Spring, JPA, MySQL, Maven

Projeto para aplicar os conceitos de desenvolvimento de código utilizando java e spring rest, retornar as Unidades de Saude mais próximas de acordo com a latitude e longitude, informada na requisição





---


![sdsd](https://i.imgur.com/47GRMbC.png)
Diagrama de classe do modelo da aplicação 




## Prerequisites

- JDK 12 or later
- Maven 3 or later
- MySQL 5.6 or later

## Stack
- Spring Data JPA
- Spring Boot
- MySQL

## Run 

```
mvn spring-boot:run
```

## Observações 
- O parametro solitado no desafio se encontra fora do padrão REST 
- o nome do parametro de itens por pagina ficou definido como size
- Utilizado lombok 

## Todo
- [x] Importar os dados csv para o banco de dados
- [X] Desenvolver end-point de consulta para retornar as unidades de saude mais proximas de acordo com os parametros enviador
- [ ] Execução do Projeto com Docker
- [ ] Executar o deploy da aplicação em um server (heroku/aws/azure)