# Microsserviços Java com Spring Boot e Spring Cloud

Sistema composto por vários microsserviços que comunicam entre si de forma transparente, escalável e com balanceamento de carga.

Os microsserviços são registrados em um "Discovery Server" (Eureka), de modo que a comunicação entre eles é feita pelo nome do microsserviço. Além disso, as requisições são feitas em um API Gateway (Zuul), responsável por rotear e autorizar as requisições.

## Algumas tecnologias usadas

+ Feign para requisições de API entre microsserviços
+ Ribbon para balanceamento de carga
+ Servidor Eureka para registro dos microsserviços
+ API Gateway Zuul para roteamento e autorização
+ Hystrix para tolerância a falhas
+ OAuth e JWT para autenticação e autorização
+ Servidor de configuração centralizada com dados em repositório Git
+ Geração de containers Docker para os microsserviços e bases de dados
