
create table users (
 id NUMERIC(7) not null,
 fullName VARCHAR(50) not null,
 username VARCHAR(50) not null,
 passwd	 VARCHAR(50) not null,
 rol NUMERIC(2) not null,
 isActive NUMERIC(1) not null
);

create table status(
	id NUMERIC(2) not null,
	value VARCHAR(15) not null
);

create table categories(
	id NUMERIC(3) not null,
	value VARCHAR(50) not null,
	description VARCHAR(250) not null,
	status NUMERIC(2) not null,
	creationDate DATE not null,
	modificationDate DATE not null
);

create table offers(
	id NUMERIC(7) not null,
	value VARCHAR(50) not null,
	description VARCHAR(250) not null,
	status NUMERIC(2) not null,
	creationDate DATE not null,
	modificationDate DATE not null,
	category_id NUMERIC(3) not null
);

create table request_offers(
	offer_id NUMERIC(7) not null,
	users_id  NUMERIC(7) not null
);

create table needs(
	id NUMERIC(7) not null,
	value VARCHAR(50) not null,
	description VARCHAR(250) not null,
	status NUMERIC(2) not null,
	creationDate DATE not null,
	modificationDate DATE not null,
	category_id NUMERIC(3) not null
);

create table request_needs(
	needs_id NUMERIC(7) not null,
	users_id  NUMERIC(7) not null
);
