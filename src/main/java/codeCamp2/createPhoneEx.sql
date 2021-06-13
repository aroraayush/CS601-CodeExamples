CREATE TABLE pusers ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30) NOT NULL);
insert into pusers (name) VALUES ('Olga');
insert into pusers (name) VALUES ('Justin');
insert into pusers (name) VALUES ('Cathy');
insert into pusers (name) VALUES ('Alice');
insert into pusers (name) VALUES ('Cathy');

CREATE TABLE phones ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, area CHAR(3) NOT NULL, number CHAR(8), descr VARCHAR(15), userid INT(6));
insert into phones (area, number, descr, userid) VALUES ('510', '111-1111', 'Work', 1);
insert into phones (area, number, descr, userid) VALUES ('415', '123-4567', 'HOME', 1);
insert into phones (area, number, descr, userid) VALUES ('415', '222-2222', 'Cell', 2);
insert into phones (area, number, descr, userid) VALUES ('956', '333-3333', 'HOME', 3);
insert into phones (area, number, descr, userid) VALUES ('401', '444-4444', 'Cell', 4);
