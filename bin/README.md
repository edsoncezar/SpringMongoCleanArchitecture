[![Build status](http://napjenkins01.cvc.com.br:8080/job/TI-MS-users-credentials/badge/icon)] (http://napjenkins01.cvc.com.br:8080/job/TI-MS-users-credentials/)
[![Quality Gate](http://sonar.services.cvc.com.br/api/project_badges/measure?project=users-credentials&metric=alert_status)](http://sonar.services.cvc.com.br/dashboard?id=users-credentials)
[![Coverage](http://sonar.services.cvc.com.br/api/project_badges/measure?project=users-credentials&metric=coverage)](http://sonar.services.cvc.com.br/component_measures?id=users-credentials&metric=Coverage)
[![Maintainnability](http://sonar.services.cvc.com.br/api/project_badges/measure?project=users-credentials&metric=sqale_rating)] (http://sonar.services.cvc.com.br/component_measures?id=users-credentials&metric=Maintainability)
[![Security](http://sonar.services.cvc.com.br/api/project_badges/measure?project=users-credentials&metric=security_rating)] (http://sonar.services.cvc.com.br/component_measures?id=users-credentials&metric=Security)

# {NOME DA APLICAÇÃO}
{DESCRIÇÃO DA APLICAÇÃO}

## {ARQUITETURA}
{DESENHO DA ARQUITETURA}

## {INTEGRAÇÕES DA APLICAÇÃO(LISTAR TODAS AS INTEGRAÇÕES DA APLICAÇÃO)}
### {INTEGRAÇÃO1}
{EXPLICAR SOBRE INTEGRAÇÃO}

### {INTEGRAÇÃO2}
{EXPLICAR SOBRE INTEGRAÇÃO}


## {BUILD DO PROJETO}
Execute a linha de comando maven:
```sh
mvn clean package
```

## Coverage
Execute a linha de comando maven:
```sh
mvn clean verify
```

## Teste Unitário
Execute a linha de comando maven:
```sh
mvn test
```

## Swagger
- {URL DA APLICAÇÃO}

## {ENDPOINTS}
- TI: {ENDPOINT DE TI}
- QA: {ENDPOINT DE QA}
- PROD: {ENDPOINT DE PROD}

Contexto: {NOME DA APLICAÇÃO}

## {RODAR A APLICAÇÃO}
Execute a linha de comando maven:
```sh
mvn spring-boot:run
```

## Query para logs no Kibana
https://kibana.services.cvc.com.br/app/kibana#/discover?_g=()&_a=(columns:!(message),index:'5725b180-ba9d-11e8-be0f-396272e87c50',interval:auto,query:(language:kuery,query:'kubernetes.namespace_name:%20%22users-credentials%22%20'),sort:!('@timestamp',desc))

## {MATRIZ DE RESILIÊNCIA}
{COLOCAR O DESENHO DA MATRIZ DE RESILIÊNCIA (Ex essa abaixo)}
http://git.cvc.com.br/desenvolvimento-java/notify/blob/master/README.md
