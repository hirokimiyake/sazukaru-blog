

/* Create Tables */
drop table m_user;
CREATE TABLE m_user
(
	user_id serial NOT NULL,
	name text,
	mailaddress text,
	password text,
	nickname text,
	data_description text,
	ins_date timestamp DEFAULT current_timestamp,
	ins_user varchar(16),
	upd_date timestamp,
	upd_user varchar(16),
	del_kbn char(2) DEFAULT '01',
	PRIMARY KEY (user_id)
) WITHOUT OIDS;


CREATE TABLE m_user_blog
(
	user_blog_id serial NOT NULL,
	user_id int NOT NULL,
	blog_name text,
	blog_url text,
	rss text,
	introduction text,
	profile_picture_path text,
	data_description text,
	ins_date timestamp DEFAULT current_timestamp,
	ins_user varchar(16),
	upd_date timestamp,
	upd_user varchar(16),
	del_kbn char(2) DEFAULT '01',
	PRIMARY KEY (user_blog_id)
) WITHOUT OIDS;



