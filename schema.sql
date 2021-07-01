create table users
(
    id       serial primary key,
    username varchar(255) unique not null,
    password varchar(255)        not null,
    role     varchar(255) default 'ROLE_USER'
);

create table posts
(
    id      serial primary key,
    user_id int  not null,
    content text not null,
    foreign key (user_id) references users (id)
);
