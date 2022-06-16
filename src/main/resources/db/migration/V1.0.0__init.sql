create table owner (
     id numeric(19,0) constraint pk_owner primary key,
     first_name varchar(128) not null,
     last_name varchar(128) not null,
     phone varchar(32) not null
);

create sequence owner_seq increment by 20 minvalue 10000 maxvalue 999999999999999999 cache 20;