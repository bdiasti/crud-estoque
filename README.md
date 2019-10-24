Estoque de produtos Affero
=============================

Esta aplicação permite a consulta, criação, exclusão e edição de produtos de estoque.


### Pre-requisitos

* Java 8
* Maven
* Mysql
* Node versão 6.9.2

### Tecnologias utilizadas

* Dropwizard back-end
* Angularjs Material front-end
* Gulp para build do pacote front
* Docker


Obs: O front-end e back-end estão no mesmo repositório afim de facilitar o entendimento, o ideal são repositórios separados.

### Instalação banco de dados Mysql

* Instale o docker(https://www.hostinger.com.br/tutoriais/install-docker-ubuntu) na sua máquina para subirmos o banco de dados Mysql ou você pode ter um mysql instalado na sua máquina

Agora suba o container do banco de dados que vai ser usado na nossa aplicação:

	docker-compose -f mysql.yml up -d
	
Com isto foi criado o banco de dados estoque e nosso banco de dados já está rodando.


### Instalação Estoque Backend

* Entre na pasta produto-backend

* No arquivo main.yml em url coloque o ip para o banco de dados.

* Rode o comando abaixo para gerar o .jar

	mvn install
	
* Rode o comando abaixo para importar a estrutura da base e alguns registros para a base que criamos

	java -jar target/produto-backend-1.0.0.jar db migrate main.yml
	
 * Rode o comando abaixo para subir nosso backend
 
	java -jar target/produto-backend-1.0.0.jar server main.yml
	
* Veja e rode os endpoints na documentação da API

	http://localhost:9000/swagger/ui
	

![alt text](https://uploaddeimagens.com.br/images/002/445/488/full/swagger-estoque.png?1571885949)


	
### Instalação Estoque front-end

* Entre na pasta produto-front

* Rode o comando abaixo para instalar as dependencias do node

	npm install
	
* Rode o comando abaixo para subir nosso front-end

	npm start


* Veja se aplicação está no ar

	http://localhost:8080/#/produto
	

![alt text](https://uploaddeimagens.com.br/images/002/445/498/full/affero-estoque.png?1571886407)

	
Se você está vendo alguns produtos é sinal que aplicação subiu e se conectou
ao backend e você ja pode realizar as operações de estoque.


