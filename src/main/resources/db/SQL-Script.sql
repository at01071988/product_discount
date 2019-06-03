create schema product_discount collate utf8mb4_general_ci;

create table Discount
(
	id int auto_increment
		primary key,
	discount_percentage varchar(50) null
);

create table `group`
(
	id int auto_increment
		primary key,
	group_name varchar(50) null,
	discount_id int null,
	constraint d_fk
		foreign key (discount_id) references Discount (id)
			on update cascade
);

create table User
(
	id int auto_increment
		primary key,
	user_name varchar(100) null,
	group_id int null,
	bill varchar(1000) null,
	type varchar(100) null,
	constraint group___fk
		foreign key (group_id) references `group` (id)
			on update cascade on delete cascade
);

