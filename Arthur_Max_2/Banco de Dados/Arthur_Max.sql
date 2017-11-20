/*create schema Arthur_Max
default character set utf8
default collate utf8_general_ci;*/

use Arthur_Max;

create table Custos_Extras (
idCustos_Extras int auto_increment not null,
Data_Compra varchar(20), 
Descrição varchar (100),
Quantidade int ,
Valor double ,
primary key (idCustos_Extras)
);

/* Criar Tabela Custos Extras */

create table Custos_Fixos (
idCusto_Fixos int auto_increment not null,
Data_Compra varchar(20),
Descricao varchar(100),
Periodo varchar(50),
Preco Double,
Custos_Extras int,
Primary Key (idCusto_Fixos)
);


/* Criar Tabale Custos Fixos */
 
create table Relatorio_Diario (
idRelatorio_Diario int auto_increment not null,
Data_Viagem varchar(20),
Quantidade_De_Viagens int,
Km_do_dia int,
Quantas_Horas_Online int,
Lucro Double,
Primary Key (idRelatorio_Diario)
);

/* Criar Tabale Relatorio_Diario */

create table Relatorio_Mensal (
idRelatorio_Mensal int auto_increment not null,
Data_Viagem varchar(20), 
Km_Inicio int,
Km_Final int,
Km_Total int,
Relatorio_Diario int,
Primary Key (idRelatorio_Mensal)
);


/* Criar Tabale Relatorio Mensal */

create table Faturamento (
idFaturamento int auto_increment not null,
Km_percorrido float,
Despesas_totais float,
Total_de_Horas int,
Lucro_Total int,
Custo_Fixo int,
Relatorio_Mensal int,
Primary Key (idFaturamento)
);


/* Criar Tabale Faturamento */

create table Manuntenção (
idManutenção int auto_increment not null,
Troca_de_Oléo int,
Troca_de_Pneus int,
Lavagem int,
Faturamento int,
Primary Key (idManutenção)
);

/* Criar Tabale Manutenção */


SELECT * FROM custos_extras;
SELECT * FROM custos_fixos;
SELECT * FROM faturamento;
SELECT * FROM relatorio_diario;
SELECT * FROM relatorio_mensal;
SELECT * FROM manuntenção;

/* Selecionar Tabelas */

INSERT INTO custos_extras (`idCustos_Extras`, `Descrição`, `Valor`, `Data_Compra`, `Quantidade`) VALUES ('1', 'Balinha', '0.5' , '2017-09-19', '100');
INSERT INTO custos_extras (`idCustos_Extras`, `Descrição`, `Valor`, `Data_Compra`, `Quantidade`) VALUES ('2', 'Chocolate', '1.0', '2017-09-19', '20');
INSERT INTO custos_extras (`idCustos_Extras`, `Descrição`, `Valor`, `Data_Compra`, `Quantidade`) VALUES ('3', 'Água', '2.00', '2017-09-19', '20');
INSERT INTO custos_extras (`idCustos_Extras`, `Descrição`, `Valor`, `Data_Compra`, `Quantidade`) VALUES ('4', 'Internet', '50' , '2017-11-15', '30');
INSERT INTO custos_extras (`idCustos_Extras`, `Descrição`, `Valor`, `Data_Compra`, `Quantidade`) VALUES ('5', 'Água de Cocô', '2.0', '2017-11-15', '100');
INSERT INTO custos_extras (`idCustos_Extras`, `Data_Compra`, `Descrição`, `Quantidade`, `Valor`) VALUES ('6', '2017-11-15', 'Pirulito', '200', '25');

/* Insert na Tabela Custos Extras */

INSERT INTO custos_fixos (`idCusto_Fixos`, `Data_Compra`, `Descricao`, `Periodo`, `Preco`) VALUES ('1', '2017-08-11', 'Internet', '5 meses', '50');
INSERT INTO custos_fixos (`idCusto_Fixos`, `Data_Compra`, `Descricao`, `Periodo`, `Preco`) VALUES ('2', '2017-08-11', 'Limpa Ar Condicionado', 'Sempre', '10');
INSERT INTO custos_fixos (`idCusto_Fixos`, `Data_Compra`, `Descricao`, `Periodo`, `Preco`) VALUES ('3', '2017-08-11', 'Seguro', 'Sempre', '1000');
INSERT INTO custos_fixos (`idCusto_Fixos`, `Data_Compra`, `Descricao`, `Periodo`, `Preco`) VALUES ('4', '2017-08-11', 'Combustivel', 'Sempre', '4.9');
INSERT INTO custos_fixos (`idCusto_Fixos`, `Data_Compra`, `Descricao`, `Periodo`, `Preco`) VALUES ('6', '2017-08-11', 'Pneus', '2 anos', '300');
INSERT INTO custos_fixos (`idCusto_Fixos`, `Data_Compra`, `Descricao`, `Periodo`, `Preco`) VALUES ('7', '2017-08-11', 'Pintura', '5 Anos', '2000');

/* Insert na Tabela Custos Fixos */

INSERT INTO faturamento (`idFaturamento`, `Km_percorrido`, `Despesas_totais`, `Total_de_Horas`, `Lucro_Total`) VALUES ('1', '50', '30', '3', '100');
INSERT INTO faturamento (`idFaturamento`, `Km_percorrido`, `Despesas_totais`, `Total_de_Horas`, `Lucro_Total`) VALUES ('2', '10', '15', '1', '50');
INSERT INTO faturamento (`idFaturamento`, `Km_percorrido`, `Despesas_totais`, `Total_de_Horas`, `Lucro_Total`) VALUES ('3', '100', '50', '4', '200');
INSERT INTO faturamento (`idFaturamento`, `Km_percorrido`, `Despesas_totais`, `Total_de_Horas`, `Lucro_Total`) VALUES ('4', '150', '100', '2', '250');
INSERT INTO faturamento (`idFaturamento`, `Km_percorrido`, `Despesas_totais`, `Total_de_Horas`, `Lucro_Total`) VALUES ('5', '120', '35', '2', '200');
INSERT INTO faturamento (`idFaturamento`, `Km_percorrido`, `Despesas_totais`, `Total_de_Horas`, `Lucro_Total`) VALUES ('6', '40', '5', '1', '150');

/* Insert na Tabela Faturamento */

INSERT INTO relatorio_diario (`idRelatorio_Diario`, `Data_Viagem`, `Quantidade_De_Viagens`, `Km_do_dia`, `Quantas_Horas_Online`, `Lucro`) VALUES ('1','2017-09-19', '2', '82', '2','64.50');
INSERT INTO relatorio_diario (`idRelatorio_Diario`, `Data_Viagem`, `Quantidade_De_Viagens`, `Km_do_dia`, `Quantas_Horas_Online`,`Lucro`) VALUES ('2','2017-11-15', '10', '180', '3','101.57');
INSERT INTO relatorio_diario (`idRelatorio_Diario`, `Data_Viagem`, `Quantidade_De_Viagens`, `Km_do_dia`, `Quantas_Horas_Online`,`Lucro`) VALUES ('3', '2017-11-16', '3', '200', '5','110.2');
INSERT INTO relatorio_diario (`idRelatorio_Diario`, `Data_Viagem`, `Quantidade_De_Viagens`, `Km_do_dia`, `Quantas_Horas_Online`,`Lucro`) VALUES ('4', '2017-11-15', '2', '1500', '3','540');
INSERT INTO relatorio_diario (`idRelatorio_Diario`, `Data_Viagem`, `Quantidade_De_Viagens`, `Km_do_dia`, `Quantas_Horas_Online`,`Lucro`) VALUES ('5', '2017-08-2', '50', '1600','12','676.6');


/* Insert na Tabela Relatorio Diario */

INSERT INTO relatorio_mensal (`idRelatorio_Mensal`, `Data_Viagem`, `Km_Inicio`, `Km_Final`, `Km_Total`) VALUES ('1','2017-08-25' ,'150', '280', '130');
INSERT INTO relatorio_mensal (`idRelatorio_Mensal`, `Data_Viagem`, `Km_Inicio`, `Km_Final`, `Km_Total`) VALUES ('2', '2017-06-06','1000', '1500', '500');
INSERT INTO relatorio_mensal (`idRelatorio_Mensal`, `Data_Viagem`, `Km_Inicio`, `Km_Final`, `Km_Total`) VALUES ('3', '2017-10-18', '5000', '5100', '100');
INSERT INTO relatorio_mensal (`idRelatorio_Mensal`, `Data_Viagem`, `Km_Inicio`, `Km_Final`, `Km_Total`) VALUES ('4', '2017-09-20', '200', '250', '50');
INSERT INTO relatorio_mensal (`idRelatorio_Mensal`, `Data_Viagem`, `Km_Inicio`, `Km_Final`, `Km_Total`) VALUES ('5', '2017-05-28', '3000', '3200', '200');


/* Insert na Tabela Relatorio Mensal */

INSERT INTO manuntenção (`idManutenção`, `Troca_de_Oléo`, `Troca_de_Pneus`, `Lavagem`) VALUES ('1', '50.0', '250', '90');
INSERT INTO manuntenção (`idManutenção`, `Troca_de_Oléo`, `Troca_de_Pneus`, `Lavagem`) VALUES ('2', '80', '300', '100');
INSERT INTO manuntenção (`idManutenção`, `Troca_de_Oléo`, `Troca_de_Pneus`, `Lavagem`) VALUES ('3', '100' , '350' , '50');
INSERT INTO manuntenção (`idManutenção`, `Troca_de_Oléo`, `Troca_de_Pneus`, `Lavagem`) VALUES ('4', '250' , '500', '60');
INSERT INTO manuntenção (`idManutenção`, `Troca_de_Oléo`, `Troca_de_Pneus`, `Lavagem`) VALUES ('5', '100' , '250' , '40');




/* Insert na Tabela Manunteção */

alter table Custos_fixos 
add foreign key (Custos_Extras)
references custos_fixos (idCusto_Fixos);

alter table Faturamento 
add foreign key (Custo_fixo)
references Faturamento (idFaturamento);

alter table Faturamento 
add foreign key (Relatorio_Mensal)
references Faturamento (idFaturamento);

alter table Manuntenção 
add foreign key (Faturamento)
references Manuntenção (idManutenção);

alter table Relatorio_Mensal
add foreign key (Relatorio_Diario)
references Relatorio_Diario (idRelatorio_Diario);

/* Adicionando Chave estrangeira */

UPDATE custos_fixos SET `Custos_Extras`='1' WHERE `idCusto_Fixos`='1';
UPDATE custos_fixos SET `Custos_Extras`='2.3' WHERE `idCusto_Fixos`='2';
UPDATE custos_fixos SET `Custos_Extras`='3' WHERE `idCusto_Fixos`='3';

/* Updates */


 SELECT Custos_fixos.Descricao, custos_fixos.idCusto_Fixos, custos_extras.Descrição
FROM custos_fixos 
inner join custos_extras
on custos_extras.idCustos_extras = custos_fixos.Custos_extras
order by custos_fixos.idCusto_fixos;


/* Relacionamento Inner Join */ 

SELECT Custos_fixos.Descricao, custos_fixos.idCusto_Fixos, custos_extras.Descrição
FROM custos_fixos 
left join custos_extras
on custos_extras.idCustos_extras = custos_fixos.Custos_extras
order by custos_fixos.Descricao;


/* Relacionamento left Join */ 

SELECT Custos_fixos.Descricao, custos_fixos.idCusto_Fixos, custos_extras.Descrição
FROM custos_fixos 
right join custos_extras
on custos_extras.idCustos_extras = custos_fixos.Custos_extras;

/* Relacionamento Rinht Join */ 
 
DELETE FROM custos_extras WHERE idCustos_Extras = '5';
DELETE FROM custos_extras WHERE idCustos_Extras = '4';
DELETE FROM custos_fixos WHERE idCusto_Fixos = '2';
DELETE FROM relatorio_diario WHERE idRelatorio_Diario = '1';
DELETE FROM relatorio_mensal WHERE idRelatorio_Mensal = '3';
DELETE FROM faturamento WHERE idFaturamento = '6';

/* DELETE */ 

create view MaximoCusto
as SELECT Custos_fixos.Descricao, custos_fixos.idCusto_Fixos, MAX(custos_fixos.Preco), custos_extras.Descrição
FROM custos_fixos 
inner join custos_extras
on custos_extras.idCustos_extras = custos_fixos.Custos_extras
order by custos_fixos.idCusto_fixos;

select * from MaximoCusto;

/* View */ 

 create view Quantidade_Itens
as SELECT Custos_fixos.Descricao, custos_fixos.idCusto_Fixos, COUNT(custos_fixos.Descricao), custos_extras.Descrição
FROM custos_fixos 
inner join custos_extras
on custos_extras.idCustos_extras = custos_fixos.Custos_extras
order by custos_fixos.idCusto_fixos;

select * from Quantidade_Itens;

/* View */ 

 create view Soma_de_Valores	
as SELECT faturamento.Despesas_totais, SUM(faturamento.Km_Percorrido), Manuntenção.Lavagem
FROM faturamento 
inner join manuntenção
on faturamento.idFaturamento = manuntenção.idManutenção;

select * from soma_de_Valores;

/* View */ 

create view vw_Manutenção
as SELECT manuntenção.troca_de_Oléo, manuntenção.Troca_de_Pneus, MAX(manuntenção.Lavagem)
FROM manuntenção;

select * from vw_Manutenção;

/* View */

create view vw_Valor
as SELECT custos_extras.Descrição, custos_extras.Quantidade, SUM(custos_extras.valor)
FROM custos_extras;

select * from vw_Valor;

/* View */ 

create view vw_Lucro_Total
as SELECT faturamento.Total_De_Horas , faturamento.Despesas_totais, MAX(faturamento.Lucro_Total)
from faturamento;

select * from vw_Lucro_Total;

/* View */

CREATE TRIGGER TG_Atualizar_Dados BEFORE INSERT
on Manuntenção
for each row
set new.Troca_de_Oléo = (new.Troca_de_Oléo * 0.90);

insert into  Manuntenção (idManutenção,Troca_de_Oléo)
values (default, 100.00);

select * from Manuntenção;  

/* Trigger */ 

CREATE TRIGGER TG_Atualizar_Dados1 BEFORE INSERT
on Faturamento
for each row
set new.Despesas_totais = (new.Despesas_totais  * 0.50);

insert into  Faturamento (idFaturamento,Despesas_totais )
values (default,550.00);

select * from faturamento;  


/* Trigger */ 


CREATE TRIGGER TG_Atualizar_Dados2 BEFORE INSERT
on relatorio_diario
for each row
set new.Km_do_dia = (new.Km_do_dia   + 0.50);

insert into  relatorio_Diario (idrelatorio_Diario, Km_do_dia )
values (default,10000);

select * from relatorio_diario;  


/* Trigger */ 

create procedure Motorista ( custos int)
select CONCAT(' O Plano de Internet  é ') , Preco as custo_fixos
from custos_fixos
where idCusto_Fixos = custos;

call motorista (3);
 
 /* ------------------------------------------------------------------------ */

 
create procedure Combustivel ( combustivel Decimal (5,2))
select CONCAT(' O Preço do Combustivel  é ') , Combustivel as custo_fixos
from custos_fixos
where idCusto_Fixos = combustivel;

call Combustivel (3);

 /* ------------------------------------------------------------------------ */

 
create procedure Nome ( Nome varchar (100))
select CONCAT(' A descrição  é ') , Descrição as custos_extras
from custos_extras
where idCustos_extras = nome ;

call Nome (2);

/* ------------------------------------------------------------------------ */

create procedure Total_KM ( total_KM float)
select CONCAT(' O total de km é ') , Km_Total as relatorio_mensal
from relatorio_mensal
where idRelatorio_Mensal = total_KM ;

call total_Km (2);

/* ------------------------------------------------------------------------ */


create procedure  KM_Dia ( KM_Dia float)
select CONCAT(' O KM do dia é ') , Km_do_dia as relatorio_diario
from relatorio_diario
where idRelatorio_Diario = KM_Dia ;

call KM_Dia (2);

/* ------------------------------------------------------------------------ */

create procedure  preço_pneus ( preço_pneus int)
select CONCAT(' O valor da troca de pneus é ') , Troca_de_Pneus as manuntenção
from manuntenção
where idManutenção = preço_pneus;

call preço_pneus (2);

/* Procedures */  

create table foto_motorista (
id_motorista int auto_increment,
foto MEDIUMBLOB,
primary key (id_motorista)
);

INSERT INTO foto_motorista (id_motorista,foto) VALUES ('2',LOAD_FILE("C:/wamp64/tmp/Motorista.jpg"));

SELECT foto INTO OUTFILE "C:/wamp64/tmp/Motoristaa.jpg" FROM foto_motorista WHERE id_motorista = 2;

select * from foto_motorista;

/* Blob */ 

create index ind_faturamento_id on faturamento(idFaturamento);

/* Indice para que possa consultar o faturamento de um determidado id , isso irá facilitar muito para podermos saber quem estao faturando mais com o aplicativo */

select * from faturamento where idFaturamento like '%1%' order by idFaturamento;

/* Select na tabela que foi criado o index */

create index ind_relatorio_mensal on relatorio_mensal (idRelatorio_Mensal);

/* Indice para que possa consultar o relatorio de um determidado id , isso irá facilitar muito para podermos saber dados do mês de cada motorista */

 select * from relatorio_mensal where idRelatorio_Mensal like '%1%' order by idRelatorio_Mensal;

/* Select na tabela que foi criado o index */



