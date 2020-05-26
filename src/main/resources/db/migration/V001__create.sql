create table estado (
    id bigint not null auto_increment primary key,
    nome varchar(255) not null,
    uf char(2) not null
);

create table cidade (
    id bigint not null auto_increment primary key,
    nome varchar(255) not null,
    estado_id bigint not null
);

alter table cidade add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

create table historico (
    id bigint not null auto_increment primary key,
    ultima_atualizacao datetime not null,
    fonte varchar(255)
)