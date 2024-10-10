Este projeto é uma aplicação baseada no Spring Boot com Kafka e Oracle JDBC utilizando Gradle para construção e gerenciamento de dependências. Ele demonstra como consumir mensagens de um broker Kafka e interagir com um banco de dados Oracle.

Requisitos
Antes de começar, você precisará ter os seguintes itens instalados em sua máquina:

Java 17
Gradle 7.x ou superior
Docker (opcional, para rodar o Kafka localmente)
Oracle JDBC (ojdbc8)
IntelliJ IDEA (ou outro IDE de sua preferência)

Configuração

1. Clonando o repositório
Para começar, clone o repositório para a sua máquina local:

git clone https://github.com/Criscomph/ConsumerGradle.git
cd ConsumerGradle

2. Configuração do Kafka
Você pode utilizar o Docker para rodar o Kafka localmente para fins de desenvolvimento. Se já tiver um broker Kafka disponível, ajuste o application.yml para apontar para a instância correta.

Usando Docker Compose
Crie um arquivo docker-compose.yml com o seguinte conteúdo para rodar Kafka e Zookeeper:

version: '3'
services:
  zookeeper:
    image: wurstmeister/zookeeper:3.4.6
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka:2.12-2.1.1
    ports:
      - "9092:9092"
    environment:
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
    depends_on:
      - zookeeper

Execute o comando abaixo para subir os containers do Kafka e Zookeeper:

docker-compose up -d

3. Configuração do Oracle Database
Certifique-se de que o banco de dados Oracle está configurado e acessível. Atualize as configurações no arquivo src/main/resources/application.yml com os detalhes da conexão do banco de dados:

spring:
  datasource:
    url: jdbc:oracle:thin:@//<ORACLE_HOST>:<PORT>/<SID>
    username: <USERNAME>
    password: <PASSWORD>
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.Oracle12cDialect


4. Compilação e execução
Para compilar e executar o projeto, use os seguintes comandos:

Executando o projeto

./gradlew bootRun

Testando o projeto
O projeto inclui testes automatizados que podem ser executados com o Gradle:

./gradlew test


Testando o Kafka
Depois que o Kafka estiver em execução, você pode enviar mensagens para o tópico que a aplicação está consumindo. Aqui está um exemplo de como enviar uma mensagem:

Verifique o nome do tópico que sua aplicação está ouvindo no arquivo application.yml (ou diretamente na classe Consumer).
Use a ferramenta Kafka Console Producer para enviar mensagens para o tópico:
docker exec -it <kafka-container-id> kafka-console-producer.sh --broker-list localhost:9092 --topic <nome-do-topico>

Verifique os logs da aplicação para garantir que as mensagens estão sendo consumidas corretamente.
Estrutura do Projeto

src/main/java: Contém o código principal da aplicação.
src/test/java: Contém os testes unitários.
build.gradle: Arquivo de configuração do Gradle.
