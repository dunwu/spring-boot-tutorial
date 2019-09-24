create table security.user
(
	id bigint not null primary key,
	nickname varchar(255) null,
	password varchar(255) null,
	username varchar(255) null
)engine=MyISAM;
