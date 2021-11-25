## Agência de Banco de Sangue

Projeto consiste em ler uma base de dados em `JSON` para aplicar em um sistema web as seguintes regras:

* Quantos candidatos temos nessa lista em cada estado do Brasil?
* IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso /
altura^2)
* Qual o percentual de obesos entre os homens e entre as mulheres? (É obeso quem tem IMC >30)
* Qual a média de idade para cada tipo sanguíneo?
* A quantidade de possíveis doadores para cada tipo sanguíneo receptor.
* Somente pessoas com idade de 16 a 69 anos e com peso acima de 50 Kg podem doar sangue.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
<!---Estes são apenas requisitos de exemplo. Adicionar, duplicar ou remover conforme necessário--->
* Você instalou a versão mais recente de `JDK 11 / Maven`.
* Mudar variavel APP_PROFILE em application.properties para `test` ao rodar em localhost.
* Lembre-se de conter o `lombok.jar` em seu ambiente de desenvolvimento.

## Tecnologias utilizadas

Back-end
* Java
* Spring boot

Front-end
* Thymeleaf
* HTML
* CSS
* Chart.js
* Javascript
* Bootstrap

Banco de dados
* H2
* PostgreSQL

Cloud
* Heroku
