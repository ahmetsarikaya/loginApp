create table users(
	username varchar(30) primary key,
	password varchar(100),
	email varchar(100),
	role varchar(100),
);
insert into users values('ahmet','12345','abc@abc.com','USER');
commit;
