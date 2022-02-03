
8 CREATE TABLE CENTRO(
9 codcentro number(2) not null,
10 direccion varchar2(30) not null,
11 localidad varchar2(20) not null);
12 insert into centro values (01,'Rambla Nova','Tarragona');
13 insert into centro values (02,'Alcala','Madrid');
14 insert into centro values (03,'Sierpes','Sevilla');
15 alter table centro add constraints pk_codcentro primary key (codcentro);
16 CREATE TABLE DPTO(
17 coddpto number(2) not null,
18 denominacion varchar2(20) not null,
19 codcentro number(2) not null,
20 coddptodepende number(2),
21 codemplejefe number(3) not null,
22 tipo char(1) not null ,
23 presupuesto number(8,2) not null);
24 insert into dpto values (01,'DIRECCIÓN',01,NULL,01,'P',100000);
25 insert into dpto values (02,'ADMINISTRACION',01,01,03,'F',50000);
26 insert into dpto values (03,'RECURSOS HUMANOS',01,01,05,'P',30000);
27 insert into dpto values (05,'CENTRAL COMERCIAL',01,01,07,'P',100000);
28 insert into dpto values (06,'COMERCIAL CENTRO',02,05,02,'F',5000);
29 insert into dpto values (07,'COMERCIAL SUR',03,05,04,'F',40000);
30 create table empleado(
31 codemple number(3) not null,
32 ape1 varchar2(20) not null,
33 ape2 varchar2(20) not null,
34 nombre varchar2(15) not null,
35 direccion varchar2(25) not null,
36 localidad varchar(25) not null,
37 telef varchar(9),
38 coddpto number(2) not null,
39 codcate number(2) not null,
40 fechaingreso date not null,
41 salario number(6,2) not null,
42 comision number(6,2)
43 );
44 insert into empleado values (01,'LOPEZ','GARCIA','ANA','C/ ANAS','MADRID',666666666,
01,01,'01/02/2000',3000,NULL);
45 insert into empleado values (02,'FERNANDEZ','MORON','JUAN','C/FUENTE','TARRAGONA',
7777777,01,02,'01/02/2002',2000,NULL);
46 insert into empleado values (03,'CORTES','LOPEZ','ANGEL','C/CIFUENTES','BARACALDO',
888888,02,01,'01/03/2003',2000,NULL);
47 insert into empleado values (04,'SANCHEZ','LUZ','FABIOLA','C/CARDON','SEVILLA',
99999999,03,02,'21/05/2001',2500,NULL);
48 insert into empleado values (05,'RAJOY','AZNAR','PAZ','C/MAR','JAEN',88888888,03,01,
'23/02/2000',2000,130);
49 insert into empleado values (06,'ZAPATERO','GALLARDON','ANGUSTIAS','C/SUR','MADRID',
78787878,05,03,'01/02/2000',2000,NULL);
50 insert into empleado values (07,'FLOR','LUZ','BLANCA','C/TECLA','SEVILLA',7777777,06,
01,'01/02/2000',3000,130);
51 insert into empleado values (08,'ROS','SANTON','ALFONSO','C/ LUZ','MADRID',888888,07,
03,'01/02/2003',2000,NULL);
52 insert into empleado values (09,'LOPEZ','ITURRIALDE','GANDI','C/OASIS','TARRAGONA',
777777,05,01,'01/02/1998',1500,210);
53 insert into empleado values (10,'JAZMIN','EXPOSITO','MARIA','C/MANDRAGORA','MADRID',
888888,05,03,'01/03/2001',1000,200);
54
55 alter table dpto add constraints pk_coddpto primary key (coddpto);
56 alter table dpto add constraints fk_codcentro foreign key(codcentro) references
centro(codcentro);
57 alter table dpto add constraints fk_coddptodepende foreign key(coddptodepende)
references dpto(coddpto);
58 alter table dpto add constraints chk_tipo check(tipo in('P','F'));
59 alter table empleado add constraints pk_codemple primary key(codemple);
60
61 alter table dpto add constraints fk_codemplejefe foreign key (codemplejefe)
references empleado(codemple);
62
63 alter table empleado add constraints fk_coddpto foreign key(coddpto) references dpto(
coddpto);
64
65 create table categoria(
66 codcate number(2) not null,
67 denom varchar2(20) not null,
68 julio number(6,2) not null,
69 diciembre number(6,2) not null
70 );
71 insert into categoria values (1,'ALTOS DIRECTIVOS',6000,5000);
72 insert into categoria values (2,'DIRECTIVOS',3000,2000);
73 insert into categoria values (3,'ADMINISTRATIVOS',2000,1500);
74
75 alter table categoria add constraints pk_codcate primary key(codcate);
76 alter table empleado add constraints fk_codcate foreign key(codcate) references
categoria(codcate);