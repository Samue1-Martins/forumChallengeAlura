create table tb_profile(
    id bigint not null auto_increment,
    name varchar (100) not null,
    email varchar(255) not null,
    password varchar(255) not null,

    primary key(id)
    )

