
# E-commerce com Java

## O que é o projeto
Esse projeto foi um desafio proposto no curso de Java da Arnia.
Em uma etapa do curso onde ainda não foi introduzido o conhecimento para realizar a integração com banco de dados.
Por esse motivo, criei listas (ArrayList e LinkedList) para simular tabelas na aplicação.

A intenção do projeto, como descrito na "Proposta inicial" abaixo, é criar um e-commerce com produtos, clientes e compras, mas com um escopo aberto para inovar e acrescentar novas funcionalidades.
Apesar de ser um projeto feito em um curto espaço de tempo para servir como um exercício, estou desenvolvendo-o para que o projeto acompanhe a evolução das tecnologias utilizadas no curso.


## Funcionalidades

- CRUD de clientes (sem opção de editar, por ter só o nome) e produtos
- Carrinho de compras funcional (Classe ItemCompra)
- Histórico de compras (com diferenciação entre produtos no carrinho e produtos comprados)
- 

## A fazer
- Integrar banco de dados no projeto
- Colocar quantidade de itens no carrinho (atualmente acrescenta produtos duplicados sem dizer a quantidade)
- Remover itens do carrinho ao comprá-los


> ## Proposta inicial
> 
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
