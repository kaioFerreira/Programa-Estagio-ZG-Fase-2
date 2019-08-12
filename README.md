# ProgramaEstagioProjetoFinalParte1
----------------------------------------------------------------------------------------------------
Como avisado sobre a repetição de codigo novamente, eu separei uma classe para a conneção com o banco.
Testes Propostos ele passou com exito e utilizei o jUnit para TDD.

Foi aplicado o modelo MVC e DAO.
O pacote *Model.dao* Tem todo o acesso e persistencia de informações no banco.

O pacote *View* que seria o local onde coloca a interface para o usuario, tentei deixar facil casa fosse fazer uma evolução do projeto e adicionar as telas ou outro tipo de interação visual.

E o pacote *Controller* Faz a ligação entre a View e a Model e armazena toda a logica do sistema.

Pacote *Connection* realiza a abertura e fechamento de toda conexão com o banco.

Pacote *Classes* usado para definir o modelo de cada classa.


Pacote*Pacotes de Teste* é onde esta os teste de unidade com o jUnix.
Nesse pacote tem as classes usadas para testes durante o desenvolvimento e a classe *TestesPropostos* que tem todos os testes propostos para a parte 1 do projeto.


IDE utilizada: NetBeansIDE 8.0.1
Banco feito com MySql no Workbench.

Segue script do banco de dados.
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

----------------------------------------------------------------------------------------------------
