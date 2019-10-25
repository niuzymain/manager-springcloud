create table account(
account_id int(10) primary key auto_increment,
account_name varchar(20),
password varchar(20)
)

create table ar(
ar_id int(10) primary key auto_increment,
gif_path varchar(200),
ar_title varchar(20),
ar_detail varchar(200)
)

create table gov_info(
info_id int(10) primary key auto_increment,
info_title varchar(100),
info_detail varchar(1000),
create_time datetime,
edit_time datetime
)

create table ticket(
ticket_id int(10) primary key auto_increment,
from_city varchar(10),
reach_city varchar(10),
start_time datetime,
reach_time datetime,
price int(10),
type varchar(10),
from_airport varchar(10),
reach_airport varchar(10),
count int(10)
)

create table veg_price(
id int(10) primary key auto_increment,
veg_name varchar(10),
price int(5)
)

create table weather(
weather_id int(10) primary key auto_increment,
city varchar(10),
temprature int(10),
humidity int(10),
wind int(10),
des varchar(10),
advice varchar(100)
)