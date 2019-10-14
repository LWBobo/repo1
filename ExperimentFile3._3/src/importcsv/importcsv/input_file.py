# -*- coding: utf-8 -*-
import rw_file
import format_check
import repeat_check
import logic_check
import add_list
import split_class_nums
'''
input file
'''


def console_main():
    """
    主函数
    :return:
    """
    student_data = input_stu('../data/input_data/newstudentInfo.csv')
    teacher_data = input_tec('../data/input_data/newteacherInfo.csv')
    course_data = input_course('../data/input_data/newcourseProgress.csv')
    if not student_data or not teacher_data or not course_data:
        return -1
    wrong_log = {}
    logic_check.logic_check(student_data, course_data, wrong_log, 2, 3)
    logic_check.logic_check(teacher_data, course_data, wrong_log, 0, 2)

    if len(wrong_log) == 0:
        rw_file.write_file(student_data, '../data/output_data/student01.csv', 'wb')
        rw_file.write_file(teacher_data, '../data/output_data/teacher01.csv', 'wb')
        rw_file.write_file(course_data, '../data/output_data/course01.csv', 'wb')
        print 'import comlpetely !'
    else:
        print wrong_log
        print 'please check your file'


def input_stu(new_filename='newstudentInfo.csv'):
    """
    导入学生
    :param new_filename:
    :return:
    """
    if format_check.filename_check(new_filename):  # 检查文件格式
        input_data = rw_file.read_file(new_filename)  # 读取文件内容
        existing_data = rw_file.read_file('../data/alreadyExisting_data/studentInfo.csv')  # 读取文件内容
        wrong_log = {}
        format_check.stu_check(input_data, wrong_log)  # 检查外部数据的格式
        middle_data = repeat_check.remove_repeat(input_data, existing_data)  # 外部数据与原有数据的去重处理
        logic_check.stu_check(middle_data, wrong_log)  # 检查逻辑重复（微信号）
        if len(wrong_log) == 0:
            output_data = add_list.way_add(middle_data)  # 格式化
            return output_data  # 最终的学生名单
        else:
            print wrong_log  # 打印错误日志

    else:
        print 'file name error'


def input_tec(new_filename='newteacherInfo.csv'):
    """
    导入教师文件
    :param new_filename:
    :return:
    """
    if format_check.filename_check(new_filename):  # 检查文件格式
        input_data = rw_file.read_file(new_filename)  # 读取文件内容
        existing_data = rw_file.read_file('../data/alreadyExisting_data/teacherInfo.csv')  # 读取文件内容
        wrong_log = {}
        format_check.tec_check(input_data, wrong_log)  # 检查外部数据的（课程表）格式
        middle_data = repeat_check.remove_repeat(input_data, existing_data)  # 外部数据与原有数据的去重处理
        logic_check.tec_check(middle_data, wrong_log)  # 检查逻辑重复（微信号）
        if len(wrong_log) == 0:
            return middle_data
        else:
            print wrong_log  # 打印错误日志

    else:
        print 'file name error'


def input_course(new_filename='newcourseProgress.csv'):
    """
    导入课程表
    :param new_filename:
    :return:
    """
    if format_check.filename_check(new_filename):  # 检查文件格式
        input_data = rw_file.read_file(new_filename)  # 读取文件内容
        existing_data = rw_file.read_file('../data/alreadyExisting_data/courseProgress.csv')  # 读取文件内容
        wrong_log = {}
        format_check.course_check(input_data, wrong_log)  # 检查外部数据的（课程表）格式
        middle_data = repeat_check.remove_repeat(input_data, existing_data)# 外部数据与原有数据的去重处理
        logic_check.course_check(middle_data, wrong_log)  # 检查逻辑重复（微信号）
        if len(wrong_log) == 0:
            output_data = split_class_nums.split_table(middle_data)  # 格式化课程表
            return output_data
        else:
            print wrong_log  # 打印错误日志

    else:
        print 'file name error'

if __name__ == '__main__':
    console_main()
eProgress.csv'):
 