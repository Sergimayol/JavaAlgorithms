def merge(left_list, right_list):
    sort_list = []
    left_list_index = right_list_index = 0
    left_list_len, right_list_len = len(left_list), len(right_list)
    for _ in range(left_list_len + right_list_len):
        if left_list_index < left_list_len and right_list_index < right_list_len:
            if left_list[left_list_index] <= right_list[right_list_index]:
                sort_list.append(left_list[left_list_index])
                left_list_index += 1
            else:
                sort_list.append(right_list[right_list_index])
                right_list_index += 1
        elif left_list_index == left_list_len:
            sort_list.append(right_list[right_list_index])
            right_list_index += 1
        elif right_list_index == right_list_len:
            sort_list.append(left_list[left_list_index])
            left_list_index += 1
    return sort_list


def mergeSort(numbers):
    if len(numbers) <= 1:
        return numbers
    mid = len(numbers)//2
    left_list = mergeSort(numbers[:mid])
    right_list = mergeSort(numbers[mid:])
    return merge(left_list, right_list)