# Processo Seletivo de Docentes (PSD)

## 📘 Descrição

Este projeto tem como objetivo simular o processo de seleção de docentes para uma instituição de ensino. 
O sistema permite o gerenciamento de professores e inscrições, utilizando uma estrutura de dados 
personalizada baseada em listas encadeadas simples. O projeto já possui um arquivo em formato csv com os cursos 
e disciplinas disponéveis, esses não serão criados ou atualizados.

---

## 📚 Domínio do Problema

Desenvolver um sistema para gerenciar o processo seletivo de docentes, conforme os seguintes requisitos:

- Cadastro e gerenciamento de **Professores**, **Disciplinas**, **Cursos** e **Inscrições**;
- Uma **inscrição** representa a candidatura de um professor a uma disciplina;
- O sistema deve realizar operações de **CRUD** (Criar, Ler, Atualizar e Deletar) para todas as entidades;
- As entidades devem ser armazenadas em estruturas de dados não convencionais (listas encadeadas simples, filas, etc.);
- A interface deve ser gráfica, construída com **Java Swing**.

---

## 🏗️ Arquitetura Utilizada

Este projeto segue a arquitetura MVC (Model-View-Controller), separando as responsabilidades da aplicação em três camadas principais:

- **View (Main)**:A `Main` Contém a interface gráfica construída com JPanel, é responsável por inicializar os componentes visuais e interagir com o usuário final.
- **Controller**: Camada responsável por intermediar a comunicação entre a interface (View) e a lógica do sistema;
- **Model**: Contém as classes que representam as entidades do domínio como: `Professor`, `Disciplina`, `Curso` e `Inscricao`. Essas classes armazenam os dados e encapsulam a lógica relacionada a cada entidade.
  
---

## 💻 Tecnologias

- Linguagem: **Java 17+**
- Interface: **JPanel**
- Estrutura de dados: **Listas encadeadas simples personalizadas**
- Padrão arquitetural: **MVC**
- Manipulação de arquivos: CSV (entrada e saída de dados)

---
## 🗃️ Organização do Código
```
/src
 ├── controller/
 │    └── ProfessorController.java
 │    └── DisciplinaController.java
 │    └── CursoController.java
 │    └── InscricaoController.java
 ├── model/
 │    └── Professor.java
 │    └── Disciplina.java
 │    └── Curso.java
 │    └── Inscricao.java
 ├── view/
 │    └── TelaPrincipal.java
 │    └── TelasCadastro.java
 └── main/
      └── Main.java
```
## 🛠️ Execução
1. Clone o repositório
2. Compile o projeto com sua IDE ou via terminal
3. Execute a classe `Main.java`
4. Interaja com o sistema por meio da interface gráfi

---

## 👥 Autores

- Beatriz Oliveira da Silva.
- Thiago Feitoza.
- William Freitas.
