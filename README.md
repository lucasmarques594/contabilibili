<h1 align="center">🧾 Contabilibili</h1>

<p align="center">
  <em>Sistema de contabilidade financeira para cartórios com arquitetura DDD e interface Desktop.</em>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=openjdk&logoColor=white" alt="Java 21"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=flat&logo=spring&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/PostgreSQL-14+-336791?style=flat&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
  <img src="https://img.shields.io/badge/JavaFX-21-007396?style=flat&logo=oracle&logoColor=white" alt="JavaFX"/>
  <img src="https://img.shields.io/badge/Maven-4+-C71A36?style=flat&logo=apache-maven&logoColor=white" alt="Maven"/>
</p>

---

## 📖 Sobre o Projeto

**Contabilibili** é uma aplicação Desktop robusta para a gestão financeira e de processos em cartórios. O projeto foi construído seguindo os princípios do **Domain-Driven Design (DDD)** para garantir um código limpo, escalável e focado nas regras de negócio.

- 🏛️ **Arquitetura DDD**: Clara separação de responsabilidades entre as camadas de Domínio, Aplicação e Infraestrutura.
- 🖥️ **Interface Desktop**: Desenvolvido com **JavaFX**, oferecendo uma experiência de usuário nativa e responsiva.
- 🐘 **Banco de Dados Robusto**: Utiliza **PostgreSQL** com migrações gerenciadas pelo **Flyway**, garantindo consistência e versionamento do schema do banco.

> **✅ Foco Atual:** A aplicação está funcional, com o módulo de **Cadastro de Cartórios** 100% implementado como exemplo da arquitetura. Os demais módulos podem ser desenvolvidos seguindo o mesmo padrão.

---

## ✨ Tecnologias Utilizadas

<details>
  <summary><strong>⚙️ Backend & Core</strong></summary>
  
- ☕ **Java 21**: Versão mais recente da linguagem, aproveitando seus novos recursos e performance.
- 🌱 **Spring Boot 3.x**: Framework para inicialização rápida e configuração simplificada da aplicação.
- 🏗️ **Maven**: Ferramenta para gerenciamento de dependências e automação do build do projeto.
- 🗂️ **Domain-Driven Design (DDD)**: Arquitetura focada nas regras de negócio complexas.
</details>

<details>
  <summary><strong>🖥️ Interface Gráfica</strong></summary>

- 🎨 **JavaFX 21**: Framework moderno para a criação de interfaces de usuário ricas e performáticas em Java.
- 📄 **FXML**: Linguagem baseada em XML para definir a estrutura da interface, separando a lógica da apresentação.
</details>

<details>
  <summary><strong>💾 Banco de Dados & Persistência</strong></summary>

- 🐘 **PostgreSQL**: Banco de dados relacional poderoso e confiável.
- 🛏️ **JPA/Hibernate**: Framework para mapeamento objeto-relacional (ORM) e persistência de dados.
- 🦋 **Flyway**: Ferramenta para controle de versão e migração do schema do banco de dados.
</details>

---

## 🏛️ Arquitetura do Projeto

O sistema é dividido em camadas, seguindo os princípios do DDD, para garantir baixo acoplamento e alta coesão.

```mermaid
flowchart TD
    A[Usuário] -->|Interage com| B[UI (JavaFX)]
    B -->|Chama| C[Application (Use Cases/Services)]
    C -->|Usa Interfaces do| D{Domain (Models & Repositories)}
    D -->|E implementado por| E[Infrastructure (JPA/Hibernate)]
    E -->|Persiste em| F[(PostgreSQL DB)]
```

---

## 🚀 Como Executar

### ✅ Pré-requisitos

- **Java Development Kit (JDK) 21** ou superior.
- **Apache Maven** (opcional, pois o projeto usa o Maven Wrapper).
- Servidor **PostgreSQL** instalado e rodando.

### 🔧 Passos de Instalação

**1. Clonar o Repositório**

```bash
git clone https://github.com/lucasmarques594/contabilibili.git
cd contabilibili
```

**2. Configurar o Banco de Dados**

Garanta que seu servidor PostgreSQL esteja rodando. Depois, crie o banco de dados e configure o usuário conforme definido em `application.properties`.

a. Crie o banco de dados:
```bash
# Este comando pode variar dependendo do seu usuário do Postgres
createdb contabilibili_db
```

b. Acesse o `psql` e defina a senha para o seu usuário (o exemplo assume que seu usuário é `lucasmarques594`):
```sql
-- Conecte-se ao psql
psql postgres

-- Dentro do psql, execute:
\password usuario_postgres
-- Digite a senha 'senha_postgres' (ou a que estiver no application.properties)
```
> **Atenção:** O arquivo `src/main/resources/application.properties` está configurado para o usuário `usuario_postgres` e senha `senha_postgres`. Ajuste-o se o seu usuário for diferente.

**3. Compilar o Projeto**

O Maven Wrapper (`mvnw`) cuidará de baixar a versão correta do Maven e compilar o projeto.
```bash
./mvnw clean install
```
Este comando irá compilar o código, rodar os testes e criar um arquivo `.jar` executável na pasta `target/`.

---

## 💻 Como Usar

**1. Executar a Aplicação**

Após o build bem-sucedido, execute o seguinte comando no terminal:

```bash
java -jar target/contabilibili-0.0.1-SNAPSHOT.jar
```

**2. Navegar na Aplicação**
- A janela principal será exibida.
- Use a barra de menus no topo para navegar entre os módulos. Por exemplo: `Cadastros > Cartórios`.

---

## 📁 Estrutura de Pacotes (DDD)

- **domain** 🧠 → Contém as entidades de negócio (Models) e as interfaces dos repositórios. É o coração do software.
- **application** 💼 → Orquestra os casos de uso (Use Cases/Services), utilizando as abstrações do domínio.
- **infrastructure** 🔌 → Implementa as interfaces do domínio com tecnologias concretas, como Spring Data JPA e PostgreSQL.
- **ui** 🖥️ → Camada de apresentação, contendo os controladores JavaFX e os arquivos FXML.

---

<h3 align="center">Feito com ❤️ por <a href="https://github.com/lucasmarques594">Lucas Marques</a></h3>