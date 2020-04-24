# Programa Estagio ZG Soluções - Fase 2
----------------------------------------------------------------------------------------------------
Como avisado sobre a repetição de codigo novamente, eu separei uma classe para a conneção com o banco.
Testes Propostos ele passou com exito e utilizei o jUnit para TDD.

Foi aplicado o modelo MVC e DAO.
O pacote *Model.dao* Tem todo o acesso e persistencia de informações no banco.

O pacote *View* que seria o local onde coloca a interface para o usuario, tentei deixar facil casa fosse fazer uma evolução do projeto e adicionar as telas ou outro tipo de interação visual.

E o pacote *Controller* Faz a ligação entre a View e a Model e armazena toda a logica do sistema.

Pacote *Connection* realiza a abertura e fechamento de toda conexão com o banco.

Pacote *Classes* usado para definir o modelo de cada classa.

Pacote *Pacotes de Teste* é onde esta os teste de unidade com o jUnix.
Nesse pacote tem as classes usadas para testes durante o desenvolvimento e a classe *TestesPropostos* que tem todos os testes propostos para a parte 1 do projeto.

----------------------------------------------------------------------------------------------------

Para resolver a promoção eu usei uma tabela no banco e para calcular o preço total eu usei o que a gente chama na maratona de estrategia gulosa ou guloso, consiste em encontrar a melhor solução local para cada problema sem pensar se existe solução melhor ou se ainda existem outras opções.

A cada item no caixa eu o iterava em uma lista de promoções (lista previamente ordenada(ordenada de modo que a promoção que me desse o menor custo por item fosse escolhida primeiro e assim por diante)), e a cada iteração/promoção eu retirava o maior numero possivel de promoção, até que todas as promoções acabavam e se ouvesse itens eu o devolvia com o valor de cada unidade na soma.

Uma estrategia melhor para encontrar quais as melhores promoções a se usar seria em cada grupo de itens seria usando programação dinamica, pois dependendo da modelagem a solução gulosa pode não devolver o melhor resultado possivel e sim algo proximo a ele.

----------------------------------------------------------------------------------------------------

IDE utilizada: NetBeansIDE 8.0.1
Banco feito com MySql no Workbench.

Segue script do banco de dados:
----------------------------------------------------------------------------------------------------

create database rocambole;
use rocambole;

CREATE TABLE distribuidora (
	codigo INT AUTO_INCREMENT, 
    nome varchar (50) NOT NULL, 
    telefone varchar(50) NOT NULL, 
    email varchar(50) NOT NULL, 
    PRIMARY KEY (codigo) 
);

CREATE TABLE estoque ( 
	codigo_produto INT AUTO_INCREMENT,
    nome_produto VARCHAR(50) NOT NULL, 
    valor_custo DOUBLE NOT NULL,
    valor_venda DOUBLE NOT NULL, 
    quantidade INT NOT NULL, 
    id_distribuidora INT NOT NULL, 
    PRIMARY KEY (codigo_produto), 
    FOREIGN KEY (id_distribuidora) REFERENCES distribuidora (codigo) 
);

CREATE TABLE caixa ( 
	codigo INT AUTO_INCREMENT, 
    codigo_produto INT NOT NULL,
    nome_produto VARCHAR(50) NOT NULL, 
    valor_unitario DOUBLE NOT NULL, 
    quantidade INT NOT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_produto) REFERENCES estoque (codigo_produto) 
);

CREATE TABLE promocao (
	codigo INT AUTO_INCREMENT,
	nome_promocao VARCHAR(50) NOT NULL, 
	produto_relacionado INT NOT NULL, 
    quantidade_leva INT NOT NULL, 
    valor_unidade DOUBLE NOT NULL,
	valor_total DOUBLE NOT NULL,
    PRIMARY KEY (codigo), 
    FOREIGN KEY (produto_relacionado) REFERENCES estoque (codigo_produto)
);

Parte 2:
----------------------------------------------------------------------------------------------------

A Parte 2 do projeto que era pra usar a interface eu não consegui concluir, eu criei a interface no pacote *Classes*.

public interface Promocao {
    Double verificaPromocao(Produto itemCaixa);
}

Criei um novo pacote *Promocoes* e cada promoção implementa a interfaçe Promocao e cada uma tem o seu mode de verificar se aquele item tem a quantidade suficiente para usar a promoção e tambem o modo de promoção, quantidade de itens ganha um desconto ou ganha outro item ou até mesmo brinde ou porcentagem de desconto.

Mais desse modo a cada nova adição de promoção eu deveria manualmente adicinar ela no metodo de preço total para que o item podese ser analizado por aquela promoção, algo que ficaria dificil de manter.

Até o momento não consegui outra solução por isso não enviei a parte 2, novamente.

----------------------------------------------------------------------------------------------------
