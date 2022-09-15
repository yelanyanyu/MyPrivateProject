SELECT classname,AVG(Chinese) FROM students
GROUP BY classname
HAVING AVG(Chinese)>=90


SELECT classname,AVG(Chinese) FROM students
GROUP BY classname
HAVING AVG(Chinese)>=90


    # 语文平均成绩不及格的班级
SELECT classname,AVG(Chinese) FROM students
GROUP BY classname
HAVING AVG(Chinese)<60

    # 语文平均成绩不及格的班级个数
SELECT COUNT(*) FROM (SELECT classname,AVG(Chinese) FROM students
                      GROUP BY classname
                      HAVING AVG(Chinese)<60) a

SELECT COUNT(*) FROM students

                         # 查询某个班级语文的优秀人员
SELECT `name` ,Chinese,classname FROM students
WHERE classname='母鸡养殖211' AND Chinese>=90
    # 查询某个班级数学的优秀人员
SELECT `name` ,math,classname FROM students
WHERE classname='母鸡养殖211' AND math>=90
    # 查询某个班级英语的优秀人员
SELECT `name` ,English,classname FROM students
WHERE classname='母鸡养殖211' AND English>=90

    # '母鸡养殖211'班语文优秀率（优秀人数/总人数）
SELECT classname,COUNT(CASE WHEN Chinese>=90 THEN 1 ELSE NULL END)/COUNT(*) AS youxiulvOf FROM students
GROUP BY classname
ORDER BY youxiulv DESC
    DESC students
SELECT * FROM students


    INSERT INTO students VALUES(7,'ami','母鸡养殖211',90,85,30)
INSERT INTO students VALUES(NULL,'你坤哥','母鸡养殖213',91,83,100)
UPDATE students SET classname='母鸡养殖211' WHERE classname='母鸡养殖'

SELECT classname,COUNT(CASE WHEN Chinese<60 THEN 1 ELSE NULL END)/COUNT(*) AS youxiulv FROM students
GROUP BY classname
ORDER BY youxiulv DESC