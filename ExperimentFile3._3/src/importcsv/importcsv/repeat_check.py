# -*- coding: utf-8 -*-
data1 = [
    ['201416920127', '张', '软件1401', 'wfsf_136'],
    ['201416920129', '张三', '软件1401', 'wfsf_135']
]
data2 = [
    ['201451692012', '张一', '软件1401', 'wfsf_137'],
    ['201416920127', '张', '软件1401', 'wfsf_136'],
    ['201416920128', '张三', '软件1401', 'wfsf_135']
]


def course_remove_repeat(new_data, old_data, keys):
    '''
    课程表以keys为去重标准
    :param new_data: 外部数据
    :param old_data: 内部数据
    :param keys: 键值
    :return: 去重后的数据
    '''
    for old_line in old_data:
        flog = True
        for new_line in new_data:
            num = 0
            for key in keys:
                if old_line[key] == new_line[key]:
                    num += 1
            if num == len(keys):
                flog = False
                break
        if flog:
            new_data.append(old_line)
        else:
            pass
    return new_data


def remove_repeat(new_data, old_data, subscript=0):
    """save the a and b not repeat part in newData,use subscript to judge
    :param new_data: 外部数据
    :param old_data: 内部数据
    :param subscript: 目标数据的下标
    :return: 外部数据与内部数据的并集列表
    """
    id_data = []
    for newline in new_data:
        id_data.append(newline[subscript])

    for line in old_data:
        if line[subscript] not in id_data:
            new_data.append(line)

    return sorted(new_data, key=lambda n: n[subscript])  # 按学号排序

if __name__ == '__main__':
    print remove_repeat(data1, data2, 0)
   for new_line in new_data:
            num = 0
            for key in keys:
                if old_line[key] == new_line[key]:
                    num += 1
            if num == len(keys):
                flog = False
                break
        if flog:
            new_data.append(old_line)
        else:
            pass
    return new_data


def remove_repeat(new_