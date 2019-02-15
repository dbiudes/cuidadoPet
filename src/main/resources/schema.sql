create table student (
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table responsavel (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(255),
  email varchar(255),
  telefone varchar(100)
);
