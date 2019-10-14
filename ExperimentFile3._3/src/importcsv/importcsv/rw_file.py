# -*- coding: utf-8 -*-
import csv


def read_file(filename, way='rb'):
    """read file information to listList
    :param filename: filename
    :param way: 文件打开方式默认为'rb'
    :return: 文件数据列表
    """
    try:
        with open(filename, way) as csv_file:
            reader = csv.reader(csv_file)
            reader.next()
            list_list = []  # 以list为元素的list
            for line in reader:
                list_list.append(line)

        csv_file.close()
        return list_list
    except IOError:
        print "File open error : "+filename+"\nplease check the filename"
        exit(-1)


def write_file(data, filename, way='ab'):
    """write file information to list_list
    :param data: 待写入文件的数据列表
    :param filename: 带写入的文件名
    :param way: 文件打开方式默认为'ab'
    :return: null
    """
    try:
        with open(filename, way) as csv_file:
            writer = csv.writer(csv_file)
            writer.writerows(data)
            csv_file.close()
    except IOError:
        print "File open error : " + filename + "\nplease check the filename"
        exit(-1)


if __name__ == '__main__':
    csv_file1 = open('newstudentInfo.csv', 'rb')
    reader1 = csv.reader(csv_file1)
    reader1.next()
    list_list1 = []  # 以list为元素的list
    for line1 in reader1:
        list_list1.append(line1)

    csv_file1.close()
    print list_list1
    print read_file('newstudentInfo.csv', 'rb')
   return list_list
    except IOError:
        print "File open error : "+filename+"\nplease check the filename"
        exit(-1)


def write_file(data, filename, way='ab'):
    """write file information to list_list
    :param data: 待写入文件的数据列表
    :param filename: 带写入的文件名
    :param way: 文件打开方式默认为'ab'
    :return: null
    """
    try:
        with open(filename, way) as csv_file:
            writer = csv.writer(csv_file)