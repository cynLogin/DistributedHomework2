1. 创建员工表
```sql
create table staff(
	id char(20) primary key not null,
    username char(30) not null,
    sex enum('男','女') not null,
    password char(30) not null,
    phone_number char(15) not null
);
```
2. 创建客户表
```sql
create table customer(
	id char(20) primary key not null,
    phone_number char(15) not null,
    username char(30) not null,
    password char(30) not null,
    address varchar(50) not null,
    total_consumption decimal(15,2) not null default 0,
    staff_id char(20) not null,
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);
```  
3. 创建订单表
```sql
drop table  if EXISTS orders;
create table orders(
	id int primary key auto_increment,
    order_time timestamp not null,
    amount_money decimal(10,2) default 0,
    completion_status tinyint not null,
    consumer_id char(20) not null,
    foreign key (consumer_id) references customer(id),
    notes varchar(100)
);
```  
4. 产品表
```sql
create table product(
	id varchar(50) primary key,
    product_name char(20) not null,
    unit_price decimal(8,2) not null default 0,
    inventory_num int not null default 0
);
```  
5. 管理员表
```sql
create table administrator(
	id char(20) primary key,
    username char(30) not null,
    password char(30) not null
);
```  
6. 订单——用户表
```sql
create table orders_product(
	order_id int not null,
    product_id varchar(50) not null,
    primary key(order_id,product_id),
    num int not null default 0,
    foreign key(order_id) references orders(id)
    on delete cascade on update cascade,
    foreign key(product_id) references product(id)
    on delete cascade on update cascade
);
```  
