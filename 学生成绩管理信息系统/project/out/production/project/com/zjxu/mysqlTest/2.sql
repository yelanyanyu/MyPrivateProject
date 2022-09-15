CREATE DATABASE studentManagementSystem

--学生学号、姓名、班级，语文、数学、英语成绩
CREATE TABLE students(
                         id INT PRIMARY KEY,
                         `name` VARCHAR(10),
                         class VARCHAR(21),
                         Chinese INT,
                         math INT,
                         English INT
)CHARACTER SET utf8

SELECT * FROM students

    INSERT INTO students VALUES(1,'牛大锤','母鸡养殖211',0,0,0);
INSERT INTO students VALUES(2,'张三','法学211',80,40,100);
INSERT INTO students VALUES(3,'李四','母猪养殖213',70,95,77);
INSERT INTO students VALUES(4,'tom','舞蹈212',98,59,78);
INSERT INTO students VALUES(5,'yaw','表情215',45,79,66);


关键字查询，姓名
SELECT * FROM students
WHERE id=?
SELECT * FROM students
WHERE `name`=?
SELECT * FROM students
WHERE class=?
SELECT * FROM students
WHERE =?

    DESC students

SELECT `name` , (Chinese+English+math) AS `sum` FROM students
ORDER BY `sum`

SELECT `name` , (Chinese+English+math)/3 AS `avg` FROM students
ORDER BY `avg` DESC
SELECT * FROM students
WHERE Chinese=(SELECT MAX(Chinese) FROM students)


CREATE TABLE `user`(
                       username VARCHAR(64),
                       pwd VARCHAR(24),
                       isLogin INT)CHARACTER SET utf8
SELECT * FROM users

    INSERT INTO users VALUES('123',MD5(123),0)



