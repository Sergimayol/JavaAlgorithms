def selectionSort(numbers):
    for i in range(len(numbers)):
        lowest_value_index = i
        for j in range(i+1, len(numbers)):
            if numbers[j] < numbers[lowest_value_index]:
                lowest_value_index = j
        numbers[i], numbers[lowest_value_index] = numbers[lowest_value_index], numbers[i]