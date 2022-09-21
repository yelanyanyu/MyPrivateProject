import os

def comeWord_FileName(filepath):
    list=[]
    for trash02, trash01, filenamelist in os.walk(filepath):
        for filename in filenamelist:
            # 这是一个判断逻辑——判断文件的后缀是否为.docx
            if filename.endswith(".docx"):
                list.append(filename)
    return list


