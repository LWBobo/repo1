# -*- coding: utf-8 -*-
data = [
    ['201451692012', '张一', '软件1401', 'wfsf_137'],
    ['201416920127', '张', '软件1401', 'wfsf_136'],
    ['201416920127', '张', '软件1401', 'wfsf_136'],
    ['201416920128', '张三', '软件1401', 'wfsf_135']
]


def logic_check(person_data, course_data, log_buffer, id_subscript=0, course_subscript=0):
    """检查课程表中的教师或学生的名单与现有的教师学生名单是否匹配，保留匹配的部分，为不匹配的部分写日志
    :param person_data: 教师或学生的名单
    :param course_data: 课程表
    :param log_buffer: 错误日志
    :param id_subscript: 学生名单中的待用项下标
    :param course_subscript: 课程表中的待用项下标
    :return: 日志
    """
    all_course_id = []
    for line in course_data:
        all_course_id.append(line[course_subscript])

    for line in person_data:
        if line[id_subscript] in all_course_id:
            pass
        else:
            log_buffer.update({'The ' + line[id_subscript] + ' error ': ' not in course'})
    return


def same_id_check(new_data, log_buffer, subscript=0):
    """id重复检查
    :param new_data: 待检查的数据列表
    :param log_buffer: 错误日志
    :param subscript: id所处的位置
    :return: null
    """
    all_id = []
    for line in new_data:
        all_id.append(line[subscript])

    for newline in new_data:
        times_of_repeat = all_id.count(newline[subscript])
        if times_of_repeat > 1:
            log_buffer.update({'Id ' + newline[subscript] +
                               ' repeat ': 'The id repeat ' + str(times_of_repeat) + ' times'})
        else:
            pass

    return


def stu_check(student_data, log_buffer):
    """学生id重复性检查
    :param student_data:
    :param log_buffer:
    :return:
    """
    same_id_check(student_data, log_buffer, 0)

    return log_buffer


def tec_check(teacher_data, log_buffer):
    """教师id重复性检查
    :param teacher_data:
    :param log_buffer:
    :return:
    """
    same_id_check(teacher_data, log_buffer, 0)

    return log_buffer


def course_check(course_data, log_buffer):
    """课程id及任课教师的id重复性检查
    :param course_data:
    :param log_buffer:
    :return:
    """
    same_id_check(course_data, log_buffer, 0)
    same_id_check(course_data, log_buffer, 2)

    return log_buffer

if __name__ == '__main__':
    wrong_buffer = {}
    same_id_check(data, wrong_buffer, 0)
    print wrong_buffer
newline[subscript] +
                               ' repeat ': 'The id repeat ' + str(times_of_repeat) + ' times'})
        else:
            pass

    return


def stu_check(student_data, log_buffer):
    """学生id重复性检查
    :param student_data:
    :param log_buffer:
    :return:
    """
    same_id_check(student_data, log_buffer, 0)

    return log_buffer


def tec_check(teacher_data, log_buffer):
    """教师i