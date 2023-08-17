Aqui está o seu texto formatado em Markdown:

# Atributos em geral:

- **Aceita valor nulo ou não?** 
  - _Não, nenhum atributo aceita valor nulo_

- **Será permitido alteração futura?**
  - _Todos os atributos são permitidos de mudança_

- **Deverá ser único?**
  - _cargo (Funcionário), telefone (Cliente) e email (Funcionário)_

- **Padrão (regex)-> um formato específico com CPF, CEP, CNPJ.**
  - _Não inserido_

# Atributos do tipo texto:

- **Quantidade mínima e máxima de caracteres**
  - _nome (Cliente e Funcionário) = Mínima: 15; Máxima: 60_
  - _sobrenome (Cliente e Funcionário) = Mínima: 15; Máxima: 60_
  - _email (Funcionário) = Mínima: 10; Máxima: 60_
  - _endereco (Cliente) = Mínima: 11; Máxima: 14_
  - _bairro (Cliente) = Mínima: 11; Máxima: 14_
  - _password (Cliente e Funcionário) = Mínima: 8; Máxima: 20_
  - _telefone (Cliente) = Mínima: 9; Máxima: 16_
  - _cargo (Funcionário) = Mínima: 10; Máxima: 30_
  - _nome (Ingrediente) = Mínima: 1; Máxima: 60_
  - _sabor (Pizza) = Mínima: 1; Máxima: 60_
  - _formaDePagamento (Pedido) = Mínima: q; Máxima: 60_

- **Aceita valores espaço em branco ou não?**
  - _Todos aceitam_

# Atributos numéricos:

- **Aceita valores negativos, positivos ou indiferente?**
  - _Indiferente_

- **Faixa de valores permitidos**
  - _salário (Funcionário) = 0 até 10000_
  - _quantidadeDeEstoque (Ingrediente) = 1 até 200_
  - _preço (Pizza) = [20, 35, 45, 60]_
  - _preço (Ingrediente) = 1 até 100_
  - _quantidadeDEItens (ItemPedido) = 1 até 200_

- **Valores múltiplos de X. Ex: 10, 20, 30...**
  - _Sim_

# Atributos de coleção:

- **Mínimo ou máximo de elementos.**
  - _ _

- **Atributos de relacionamento entre classes**
  - _ _

- **Objeto A deve estar relacionado com o objeto B.**
  - _ _

- **Número mínimo ou máximo de relacionamentos.**
  - _ _

- **Objeto A deve estar relacionado com objeto B que possua em seu atributo X o valor Y.**
  - _ _

- **Restrições de Classe (que envolvem mais de 1 atributo)**
  - _ _

- **A soma do valor de atributo A com o valor do atributo B deve ser igual a X.**
  - _ _

- **Se atributo A possui o valor X, o atributo B deve estar preenchido com valor Y.**
  - _ _

# Requisitos:

1. Um cliente deve ser cadastrado no pedido.

2. Um funcionário deve estar atrelado ao pedido.

3. Um item pedido é o produto pedido que serve para armazenar a quantidade em estoque de pizzas.

4. Cada compra deve ter atrelado a sua data de criação de forma automática.

5. Cada pizza deve conter pelo menos um ingrediente.

6. Ao criar o pedido, a quantidade de itens deve ser diminuída.

7. Cada funcionário deve ter uma senha única e exclusiva para acessar o sistema.

# Restrições e regras de negócio:

1. O campo id de todas as classes deve ser único e não nulo.

2. O campo preço da classe Pizza deve ser um número decimal positivo.

3. Um cliente só pode fazer um pedido se fornecer todos os dados solicitados.

4. A quantidade de Estoque no Ingrediente deve ser um número inteiro positivo.

5. A data e hora de início de uma compra devem ser anteriores à data e hora de término.

6. Será permitida alteração futura.
![Diagrama de classes](https://user-images.githubusercontent.com/135645946/247924786-d622473b-17b7-40c3-a6df-560ef1b5694d.png)
