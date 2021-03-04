create table notes (
	id bigint not null primary key,
	title varchar(127),
	body varchar(1023) not null
);