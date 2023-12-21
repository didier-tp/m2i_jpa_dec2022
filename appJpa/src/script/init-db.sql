CREATE DATABASE IF NOT EXISTS BaseQuiVaBien ;
use BaseQuiVaBien;

DROP TABLE IF EXISTS ligne_commande;
DROP TABLE IF EXISTS commande;

DROP TABLE IF EXISTS employe;
DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS client_compte;
DROP TABLE IF EXISTS compte;
DROP TABLE IF EXISTS adresse_de_client;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS resa_avec_version;
DROP TABLE IF EXISTS big_data;

create table commande (
numero integer not null auto_increment,
date date, 
primary key (numero));

create table ligne_commande (
num_commande integer not null,
num_ligne integer not null, 
prix_unitaire double precision, 
quantite integer, 
ref_produit varchar(255), 
primary key (num_commande, num_ligne));

ALTER TABLE ligne_commande ADD CONSTRAINT ligne_commande_avec_commande_valide
FOREIGN KEY (num_commande) REFERENCES commande(numero);

INSERT INTO commande (numero,date) VALUES (1,'2023-12-19');
INSERT INTO ligne_commande (num_commande,num_ligne,prix_unitaire,quantite,ref_produit) 
 VALUES (1,1,2.4,1,"stylo");
INSERT INTO ligne_commande (num_commande,num_ligne,prix_unitaire,quantite,ref_produit) 
 VALUES (1,2,6.1,3,"cahier");

CREATE TABLE employe(
emp_id INTEGER auto_increment,
firstname VARCHAR(64),
lastname VARCHAR(64),
phone_number VARCHAR(64),
email VARCHAR(64),
login VARCHAR(32),
password VARCHAR(64),
PRIMARY KEY(emp_id));

CREATE TABLE compte(
numero INTEGER auto_increment,
label  VARCHAR(64),
solde DOUBLE,
type_compte VARCHAR(64),
taux DOUBLE,
PRIMARY KEY(numero));

CREATE TABLE operation(
num_op INTEGER auto_increment,
label  VARCHAR(64),
montant DOUBLE,
date_op  VARCHAR(16),
num_compte INTEGER,
PRIMARY KEY(num_op));

ALTER TABLE operation ADD CONSTRAINT operation_avec_compte_valide
FOREIGN KEY (num_compte) REFERENCES compte(numero);

CREATE TABLE client(
id INTEGER auto_increment,
prenom  VARCHAR(64),
nom VARCHAR(64),
PRIMARY KEY(id));

CREATE TABLE adresse_de_client(
id_client INTEGER,
numero  VARCHAR(16),
rue  VARCHAR(64),
code_postal VARCHAR(64),
ville VARCHAR(64));

ALTER TABLE adresse_de_client ADD CONSTRAINT adresse_de_client_avec_client_valide
FOREIGN KEY (id_client) REFERENCES client(id);


CREATE TABLE client_compte(
id_client  INTEGER,
num_compte INTEGER,
PRIMARY KEY(id_client,num_compte));

ALTER TABLE client_compte ADD CONSTRAINT client_compte_avec_compte_valide
FOREIGN KEY (num_compte) REFERENCES compte(numero);
ALTER TABLE client_compte ADD CONSTRAINT client_compte_avec_client_valide
FOREIGN KEY (id_client) REFERENCES client(id);


INSERT INTO employe (emp_id,firstname,lastname,phone_number,email,login,password)
VALUES (1,'alain', 'Therieur' , '0102030405' , 'alain.therieur@xyz.com','login1','pwd1');

INSERT INTO employe (emp_id,firstname,lastname,phone_number,email,login,password)
VALUES (2,'axelle', 'Aire' , '0102030405' , 'axelle.aire@m2i.com','login2','pwd2');

INSERT INTO compte (numero,label,solde,type_compte,taux) 
   VALUES (1,'compteA', 50.0,'CompteCourant',null);
INSERT INTO compte (numero,label,solde,type_compte,taux) 
  VALUES (2,'compteB', 70.0,'CompteEpargne',1.2);


INSERT INTO operation (num_op,label,montant,date_op,num_compte) 
   VALUES (1,'achat bonbons', -5.2 , '2022-12-08' , 1);
INSERT INTO operation (num_op,label,montant,date_op,num_compte) 
    VALUES (2,'paye novembre', 2000 , '2022-11-30' , 1);
    
INSERT INTO client (id,prenom,nom) VALUES (1,'alex', 'Therieur');
INSERT INTO client (id,prenom,nom) VALUES (2,'jean', 'Aimare');

INSERT INTO client_compte (id_client,num_compte) VALUES (1,1); 
INSERT INTO client_compte (id_client,num_compte) VALUES (2,1);
INSERT INTO client_compte (id_client,num_compte) VALUES (2,2); 

INSERT INTO adresse_de_client (id_client,numero,rue,code_postal,ville) 
      VALUES (1,"1","rue Xy" , "75001" , "Paris"); 
      
INSERT INTO adresse_de_client (id_client,numero,rue,code_postal,ville) 
      VALUES (2,"3bis","rue zz" , "76000" , "Rouen");      

CREATE TABLE resa_avec_version(
id_resa INTEGER auto_increment,
num_version INTEGER,
objet  VARCHAR(64),
num_client INTEGER,
PRIMARY KEY(id_resa));

INSERT INTO resa_avec_version (id_resa,num_version,objet,num_client) 
  VALUES (1,1,"uniqueVoitureDeCourtoisie" , null); 
  
CREATE TABLE big_data (
   id bigint not null auto_increment, 
   image longblob, 
   json_data longtext, 
   primary key (id));  
   
   
SELECT * FROM commande;
SELECT * FROM ligne_commande;

SELECT * FROM employe;
SELECT * FROM compte;
SELECT * FROM operation;
SELECT * FROM client;
SELECT * FROM adresse_de_client;
SELECT * FROM client_compte;
SELECT * FROM resa_avec_version;