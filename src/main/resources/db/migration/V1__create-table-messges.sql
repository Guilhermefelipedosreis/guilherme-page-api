create table messages (
    
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null,
    phone varchar(20),
    content varchar(1000)not null,

    primary key(id)
);