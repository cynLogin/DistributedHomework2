# 创建数据库
CREATE DATABASE distributed_homework;
use distributed_homework;
# 员工表

CREATE TABLE employee (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL
);
# 管理员表

CREATE TABLE admin (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       admin_name VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
);
# 设置密码默认值
ALTER TABLE employee
    ALTER COLUMN password SET DEFAULT '123456';
ALTER TABLE admin
    ALTER COLUMN password SET DEFAULT '123456';

# 插入数据

INSERT INTO employee (username) VALUES
                                              ('user1'),
                                              ('user2'),
                                              ('user3');
INSERT INTO admin (admin_name) VALUES
                                             ('admin1'),
                                             ('admin2'),
                                             ('admin3');
