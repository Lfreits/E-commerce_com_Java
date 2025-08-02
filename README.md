# 🛒 E-commerce em Java

## 📌 Sobre o projeto

Este projeto foi desenvolvido como parte de um desafio no curso de Java da [Arnia](https://arnia.com.br/).  
Na etapa em que ele foi criado, ainda não havia sido apresentado o conteúdo sobre bancos de dados, por isso, utilizei `ArrayList` e `LinkedList` para simular tabelas em memória.

O objetivo é construir um e-commerce com produtos, clientes e compras, com escopo aberto para evoluir conforme o avanço do curso.  
Apesar de ser um exercício de curta duração, estou mantendo a estrutura do projeto preparada para incorporar novas tecnologias e boas práticas aprendidas futuramente.

---

## ✅ Funcionalidades atuais

- CRUD de produtos e clientes *(sem opção de editar clientes, pois só é armazenado o nome)*
- Carrinho de compras funcional com a classe `ItemCompra`
- Histórico de compras, separando produtos no carrinho dos que já foram comprados

---

## 🛠️ A fazer

- 🔗 Integrar banco de dados ao projeto  
- ➕ Adicionar controle de quantidade de itens no carrinho  *(atualmente acrescenta produtos duplicados sem dizer a quantidade)*
- Adicionar CPF ao cliente
- Consertar bug de histórico de compras

---

## 🧪 Tecnologias e conceitos utilizados

- `ArrayList` para armazenar produtos e clientes  
- `LinkedList` para o carrinho de compras (inserção/remoção eficiente)  
- Orientação a objetos com as classes:
  - `Produto`
  - `Cliente`
  - `Compra`
  - `ItemCompra`

---

## 🚀 Como executar

O projeto foi desenvolvido em **Java 6** (versão do Java utilizado na minha empresa). Para rodar, é necessário utilizar o **JDK 11** ou **JDK 8**, garantindo compatibilidade com o compilador e com o ambiente de desenvolvimento original. IDEs e JDKs modernos geralmente não oferecem suporte direto para compilar Java 6, portanto, é essencial configurar o JDK corretamente.

O arquivo `pom.xml` já está configurado para compilar o projeto com compatibilidade Java 6 (`maven.compiler.source` e `maven.compiler.target`), o que permite que ele compile na versão do Java utilizada pela empresa, desde que o ambiente esteja preparado para isso.

### Passos:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Importe o projeto em uma IDE como IntelliJ IDEA ou Eclipse  

3. Certifique-se de que o JDK do projeto seja 11 ou 8
   
5. Execute a classe principal:
   ```
   src/Principal/Ecommerce.java
   ```

6. Use o menu exibido no console para interagir com a aplicação

---


## 🧾 Proposta inicial (fornecida pelo curso)

Abaixo está a proposta original do desafio, fornecida pelos instrutores do curso.
O objetivo era seguir esse escopo como ponto de partida para o desenvolvimento:

> ### Objetivo:
> - Simular um sistema de e-commerce simples com produtos, clientes e compras.
> 
> ### Funcionalidades:
> - Cadastro de produtos e clientes
> - Adição e remoção de itens no carrinho
> - Cálculo de total da compra
> - Histórico de compras
> - Relatórios de produtos mais vendidos
> 
> ### Tecnologias utilizadas
> - ArrayList para lista de produtos e clientes
> - LinkedList para itens no carrinho (inserção/removal rápida)
> - Double e Integer para quantidade e preços
> - Classes Produto, Cliente, Compra, ItemCompra
> 
> 
> ### Observações
> Se julgar necessário, pode criar outras classes
> 
> Lembrando que o menu de opções seria um system.out.println mesmo 
> EX:
> 1 - Cadastro de cliente
> 2 - Cadastro de produtos
> 3 - Histórico de compras
