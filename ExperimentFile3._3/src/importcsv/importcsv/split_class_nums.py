# -*- coding: utf-8 -*-
import re
coursdata = [
    ['51610189', '软件工程概论', '2004633', '软件工程概论', '1', '1', '2004633', '2004633', '软件工程1401'],
    ['51610189', '软件工程概论', '2004633', '软件工程概论', '1', '1', '2004633', '2004633', '软件工程1402-软件1405']
]


def copy_line(line, class_name, num):
    """be used in def split_table(newCourseDate, subscript=-1): in order to apply for new memory
    :param line: 待复制行数据
    :param class_name: 修改项的组成部分
    :param num: 修改项的组成部分
    :return: 修改数据后的一行数据列表
    """
    line2 = []
    for i in line:
        line2.append(i)
    line2[-1] = class_name + str(num)
    return line2


def split_table(course_data, subscript=-1):
    """make class_names to class_name
    :param course_data: 课程表数据
    :param subscript: 待拆分的数据所在位置
    :return: 格式化的数据列表
    """
    new_data = []

	# ……
	# 遍历course_data，将班级区间切分、转换为需要的格式
	
    return cut_list(new_data)


def cut_list(course_data):
    end_data = []
    for line in course_data:
        new_line = [line[2], line[3], line[0], line[8]]
        end_data.append(new_line)

    return end_data


if __name__ == '__main__':
    print split_table(coursdata, -1)
n def split_table(newCourseDate, subscript=-1): in order to apply for new memory
    :param line: 待复制行数据
    :param class_name: 修改项的组成部分
    :param num: 修改项的组成部分
    :return: 修改数据后的一行数据列表
    """
    line2 = []
    for i in line:
        line2.append(i)
    line2[-1] = class_name + str(num)
    return line2


def split_table(course_data, subscript=-1):
    """make class_names to class_name
    :param course_data: 课程表数据
    :param subscript: 待拆分的数据所在位置
    :return: 格式化的数据列表
    """
    new_data = []

	# ……