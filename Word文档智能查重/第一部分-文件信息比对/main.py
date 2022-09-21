import win32com.client
from win32com.client import Dispatch
import readword
import datetime

connect_word = Dispatch("Word.Application")
MyFile = Dispatch("Scripting.FileSystemObject")
connect_word.ScreenUpdating = False
connect_word.Application.DisplayAlerts = False

Path = input("请输入文件夹路径：")
wordnamelist = readword.comeWord_FileName(Path)
timesub=input("请输入判断总编译时间（精度）(分钟)：")
dataFileSource = input("请输入您期望的数据文件储存路径：")
with open(dataFileSource + "\dataFile.txt", 'a') as txt_object:
    for name in wordnamelist:
        ThisWordPath = Path + "\\" + name

        doc = connect_word.Documents.Open(ThisWordPath)

        mylist = [MyFile.Getfile(ThisWordPath).Name,  # 文件名称
                  MyFile.Getfile(ThisWordPath).DateCreated,  # 文件创建日期（重要）
                  MyFile.Getfile(ThisWordPath).DateLastModified,  # 文件修改日期（重要）
                  MyFile.Getfile(ThisWordPath).DateLastAccessed,  # 文件访问日期
                  MyFile.Getfile(ThisWordPath).ParentFolder,  # 文件保存路径
                  doc.BuiltInDocumentProperties(3),  # 作者
                  doc.BuiltInDocumentProperties(7),  # 上一个作者
                  doc.BuiltInDocumentProperties(11),  # 创建时间（内置属性值）
                  doc.BuiltInDocumentProperties(22),  # 字节数
                  doc.BuiltInDocumentProperties(15),  # 修订次数
                  doc.BuiltInDocumentProperties(8),  # 字数
                  doc.BuiltInDocumentProperties("Total Editing Time"),  # 总编辑时间
                  doc.BuiltInDocumentProperties(16)]  # 字符数

        # 这里加入判断逻辑
        date_01=str(mylist[1])
        date_02=str(mylist[2])
        try:
            time01_object = datetime.datetime.strptime(date_01[0:19], '%Y-%m-%d %H:%M:%S')
            time02_object = datetime.datetime.strptime(date_02[0:19], '%Y-%m-%d %H:%M:%S')
        except RuntimeError:
            pass
        # if str(mylist[5])!=str(mylist[6]) :
        #     print(mylist[0]+"为可疑作业")
        if int(mylist[11])<int(timesub):
            print(mylist[0]+"为可疑作业")
        for list_01 in mylist:
            txt_object.write(str(list_01) + "\n")
        txt_object.write("========\n")
        doc.Close()
connect_word.ScreenUpdating = True
connect_word.DisplayAlerts = True
connect_word.DisplayAlerts = True
connect_word.Quit()


# ThisWordPath = input("请输入文件夹路径：")
# doc = connect_word.Documents.Open(ThisWordPath)
# print()
# connect_word.ScreenUpdating = True
# connect_word.DisplayAlerts = True
# connect_word.DisplayAlerts = True
# connect_word.Quit()

