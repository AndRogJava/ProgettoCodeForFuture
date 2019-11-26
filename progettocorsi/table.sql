--CREARE NUOVA CONNESSIONE SU ORACLE:

CREATE USER progettocorso IDENTIFIED BY password;

GRANT CONNECT TO  progettocorso;


GRANT ALL PRIVILEGES TO progettocorso;



--PREMERE "+" IN ALTO A SINISTRA E INSERIRE LE NUOVE CREDENZIALI:

--NUOVA CONNESSIONE: ConnessioneFinale
--USER: progettocorso
--PASSWORD: password

----------------------------------------------------------------------------------------------------------------------------------------------------------------------

--CREARE E RIEMPIRE LE TABELLE

CREATE  TABLE DATI_AMMINISTRATORI (
nomeadmin varchar2 (50),
cognomeadmin varchar2 (50),
codadmin number (10),
constraint pk_codadmin primary key (codadmin)
);


insert into DATI_AMMINISTRATORI values ('Gabriella','Grandine',10);
insert into DATI_AMMINISTRATORI values ('Alice','Urban',11);
insert into DATI_AMMINISTRATORI values ('Elena','Greco',12);



CREATE TABLE DATI_DOCENTI (
nomedocente varchar2 (50),
cognomedocente varchar2 (50),
cv_docente varchar2 (50),
coddocente number (10),
constraint pk_coddocente primary key (coddocente)
);

insert into DATI_DOCENTI  values ('Selene','Allevi','TeamWork',100);
insert into DATI_DOCENTI  values ('Rossella','Di Palma','Comunicazione',200);
insert into DATI_DOCENTI values ('Saveria','Paese','Spagnolo',300);
insert into DATI_DOCENTI values ('Andrea','Rognetta','Informatica',400);
insert into DATI_DOCENTI values ('Valentina','Mama','Lingue',500);





 
CREATE TABLE DATI_CORSISTI (
nomecorsista varchar2 (50),
cognomecorsista varchar2 (50),
codcorsista number (10),
precedentiformativi varchar2 (50),
constraint pk_codcorsista primary key (codcorsista)
);


INSERT INTO DATI_CORSISTI values ('Francesca','Meroni',1,'Inglese');
INSERT INTO DATI_CORSISTI values ('Daniela','Damiano',2,'Spagnolo');
INSERT INTO DATI_CORSISTI values ('Chaiara','Nebuloni',3,'Arte');
INSERT INTO DATI_CORSISTI values ('Mariangela','Giovanzanti',4,'Tedesco');
INSERT INTO DATI_CORSISTI values ('Simona','Mar',5,'Tedesco');
INSERT INTO DATI_CORSISTI values ('Marco','Mai',6,'Spagnolo');
INSERT INTO DATI_CORSISTI values ('Francesco','Sa',7,'Spagnolo');




CREATE TABLE DATI_CORSI (
codcorso number (10),
coddocente number(10),
nomecorso varchar2(50),
data_iniziocorso date,
data_finecorso date,
costocorso number (10),
commenticorso varchar2 (50),
aulacorso varchar2 (50),
constraint pk_codcorso primary key(codcorso),
constraint fk_coddocente foreign key (coddocente)
references dati_docenti (coddocente)
);


INSERT INTO DATI_CORSI values (222,500,'Inglese',to_date('30/11/2019','DD-MM-YYYY'),to_date ('30/01/2020','DD-MM-YYYY'),200,'Avanzato','C');
INSERT INTO DATI_CORSI values (223,500,'Francese',to_date('28/11/2019','DD-MM-YYYY'),to_date ('28/01/2020','DD-MM-YYYY'),200,'Base','B');
INSERT INTO DATI_CORSI values (224,500,'Tedesco',to_date('22/11/2019','DD-MM-YYYY'),to_date ('22/01/2020','DD-MM-YYYY'),300,'Medio','D');
INSERT INTO DATI_CORSI values (225,400,'Java',to_date('01/12/2019','DD-MM-YYYY'),to_date ('01/01/2020','DD-MM-YYYY'),500,'Avanzato','F');
INSERT INTO DATI_CORSI values (226,400,'C++',to_date('12/12/2019','DD-MM-YYYY'),to_date ('12/01/2020','DD-MM-YYYY'),700,'Avanzato','F');
INSERT INTO DATI_CORSI values (227,200,'ArteModerna',to_date('21/11/2019','DD-MM-YYYY'),to_date ('21/01/2020','DD-MM-YYYY'),600,'Cultura','G');
INSERT INTO DATI_CORSI values (228,100,'EducazioneCivile',to_date('05/01/2020','DD-MM-YYYY'),to_date ('10/01/2020','DD-MM-YYYY'),600,'Civile','H');





CREATE TABLE CORSI_CORSISTI (
codcorsista number (10),
codcorso number (10),
codcorso_corsista number (10),
constraint pk_codcorso_corsista primary key (codcorso_corsista),
constraint fk_codcorsista foreign key (codcorsista)
references dati_corsisti(codcorsista),
constraint fk_codcorso foreign key(codcorso)
references dati_corsi (codcorso)
);
INSERT INTO CORSI_CORSISTI values ( 1,224,1000);
INSERT INTO CORSI_CORSISTI values ( 2,224,2000);
INSERT INTO CORSI_CORSISTI values ( 3,224,3000);
INSERT INTO CORSI_CORSISTI values ( 4,224,4000);
INSERT INTO CORSI_CORSISTI values ( 5,226,5000);
INSERT INTO CORSI_CORSISTI values (6,227,6000);
INSERT INTO CORSI_CORSISTI values (7,228,7000);

commit;

create TRIGGER "AUTO_DELETE_ROW_corsiCorsisti" 
AFTER DELETE ON DATI_CORSI 
FOR EACH ROW
BEGIN
  DELETE FROM corsi_corsisti WHERE corsi_corsisti.CODCORSO = :old.CODCORSO;
END;

create sequence CorsoCorsista_Seq
start with 8000 increment by 1000
minvalue 1 nomaxvalue nocycle;


create sequence DATI_CORSISTI_codcorsista_Seq
start with 8 increment by 1
minvalue 1 nomaxvalue nocycle;

commit;
