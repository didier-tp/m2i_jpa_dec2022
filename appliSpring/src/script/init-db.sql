CREATE DATABASE IF NOT EXISTS BaseQuiVaBien ;
use BaseQuiVaBien;

DROP TABLE IF EXISTS employe;
DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS client_compte;
DROP TABLE IF EXISTS compte;
DROP TABLE IF EXISTS client;

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

INSERT INTO compte (numero,label,solde) VALUES (1,'compteA', 50.0);
INSERT INTO compte (numero,label,solde) VALUES (2,'compteB', 70.0);

INSERT INTO operation (num_op,label,montant,date_op,num_compte) 
   VALUES (1,'achat bonbons', -5.2 , '2022-12-08' , 1);
INSERT INTO operation (num_op,label,montant,date_op,num_compte) 
    VALUES (2,'paye novembre', 2000 , '2022-11-30' , 1);
    
INSERT INTO client (id,prenom,nom) VALUES (1,'alex', 'Therieur');
INSERT INTO client (id,prenom,nom) VALUES (2,'jean', 'Aimare');

INSERT INTO client_compte (id_client,num_compte) VALUES (1,1); 
INSERT INTO client_compte (id_client,num_compte) VALUES (2,1);
INSERT INTO client_compte (id_client,num_compte) VALUES (2,2);      

SELECT * FROM employe;
SELECT * FROM compte;
SELECT * FROM operation;
SELECT * FROM client;
SELECT * FROM client_compte;