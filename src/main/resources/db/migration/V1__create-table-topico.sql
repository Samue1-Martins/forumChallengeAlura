create table tb_topic(
    id bigint not null auto_increment,
    title varchar (100) not null,
    message text not null,
    created_at timestamp,
    status varchar(30),
    author varchar(50),
    response text,
    course varchar (100),

    primary key(id)
    )