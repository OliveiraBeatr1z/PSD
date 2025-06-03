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
- A interface deve ser gráfica, construída com **JPanel**.

Regras de negócio e diagramas.
https://drive.google.com/file/d/14OSxt5nRDj7MXXo9I2Augt55FZU8OXMU/view?usp=sharing
---

## 🏗️ Arquitetura Utilizada

O projeto segue o padrão de arquitetura **DDD (Domain-Driven Design)**, dividido nas seguintes camadas:

- **View (Main)**: Contém a interface gráfica construída com JPanel;
- **Controller**: Camada responsável por intermediar a comunicação entre a interface (View) e a lógica do sistema;
- **Service**: Responsável pelas regras de negócio e validações;
- **Repository**: Responsável pelo armazenamento e recuperação de dados usando listas encadeadas personalizadas;
- **Model**: Define as entidades do sistema, como `Professor`, `Disciplina`, `Curso` e `Inscricao`.

### 🧹 Por que isso é melhor?
- O Controller só lida com a UI.
- A Service lida com regras de negócio e pode ser testada separadamente.
- O Repository lida com persistência.
- O Model é só o dado e suas regras básicas.

---

## 💻 Tecnologias

- Linguagem: **Java**
- Interface: **JPanel**
- Estrutura de dados: **Listas encadeadas simples personalizadas**
- Padrão arquitetural: **DDD**

---

## 🛠️ Execução

1. Compile todas as classes com `javac`.
2. Execute a classe principal (`Main`) para iniciar a interface gráfica.

---

## 👥 Autores

- Nome do integrante 1
- Nome do integrante 2
