# -*- coding: utf-8 -*-
import re
'''
the table format check
'''
# 本文件的测试用例
data = [
    ['201451692012', '张一', '软件1401', 'wfsf_137'],
    ['201416920124', '张二', '软件1401', 'wfsf_136'],
    ['201416920128', '张三', '软件1402', 'wfsf_135']
]


def id_format_check(id_str, id_len, log_buffer, line_num):
    """record the format wrong id in log_buffer
    :param id_str: 待匹配的字符串
    :param id_len: 需要的字符长度
    :param log_buffer: 错误日志
    :param line_num: str所在行
    :return: null
    """
	# 检查id格式是否正确


def name_format_check(name_str, log_buffer, line_num):
    """record the format wrong name in log_buffer
    :param name_str: 待匹配的字符串
    :param log_buffer: 错误日志
    :param line_num: str属性
    :return: null
    """
	# 检查姓名是否符合要求


def class_format_check(class_str, log_buffer, line_num):
    """record the format wrong class_name in log_buffer
    :param class_str: class name
    :param log_buffer: wrong buffer
    :param line_num: str nature
    :return:
    """
	# 用正则表达式对班级数据进行检查


def char_format_check(char_str, log_buffer, line_num):
    """record the format wrong char in log_buffer
    :param char_str: 待匹配字符串
    :param log_buffer: 错误日志
    :param line_num: 用于错误日志的记录该字符串的行数
    :return: null
    """
	# 用正则表达式检查字符串是否使数字或字母组成的


def filename_check(new_filename):
    """check the file name whether is xx.csv file
    :param new_filename: file name
    :return: bool
    """
	# 检查文件名是否是csv文件


def stu_check(new_data, log_buffer):
    """学生数据的格式检查
    :param new_data: 学生数据列表
    :param log_buffer: 错误日志
    :return: null
    """
    for line in new_data:
        line_num = str(new_data.index(line))
        id_format_check(line[0], 12, log_buffer, line_num)
        name_format_check(line[1], log_buffer, line_num)
        class_format_check(line[2], log_buffer, line_num)
        char_format_check(line[3], log_buffer, line_num)


def tec_check(new_data, log_buffer):
    """教师数据的格式检查
    :param new_data: 教师数据列表
    :param log_buffer: 错误日志
    :return: null
    """
    for line in new_data:
        line_num = str(new_data.index(line))
        id_format_check(line[0], 7, log_buffer, line_num)
        name_format_check(line[1], log_buffer, line_num)
        char_format_check(line[2], log_buffer, line_num)


def course_check(new_data, log_buffer):
    """课程白的数据有效性检查
    :param new_data: 课程列表
    :param log_buffer: 错误日志
    :return: null
    """
    for line in new_data:
        line_num = str(new_data.index(line))
        id_format_check(line[0], 7, log_buffer, line_num)
        name_format_check(line[1], log_buffer, line_num)
        id_format_check(line[2], 8, log_buffer, line_num)
        class_format_check(line[8], log_buffer, line_num)

    return log_buffer


if __name__ == '__main__':
    wrong_buffer = {}
    for lines in data:
        lines_num = str(data.index(lines))
        id_format_check(lines[0], 12, wrong_buffer, lines_num)
        name_format_check(lines[1], wrong_buffer, lines_num)
        class_format_check(lines[2], wrong_buffer, lines_num)
        char_format_check(lines[3], wrong_buffer, lines_num)

    print wrong_buffer
    if filename_check('123.csv'):
        print 'O'
    else:
        print 'X'
_buffer, line_num)


def course_check(new_data, log_buffer):
    """课程白的数据有效性检查
    :param new_data: 课程列表
    :param log_buffer: 错误日志
    :return: null
    """
    for line in new_data:
        line_num = str(new_data.index(line))
        id_format_check(line[0], 7, log_buffer, line_num)
        name_format_check(line[1], log_buffer, line_num)
        id_format_chec