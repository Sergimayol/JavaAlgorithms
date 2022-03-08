def insertionSort(numbers):
    for i in range(1, len(numbers)):
        item_to_insert = numbers[i]
        j = i-1
        while j >= 0 and numbers[j] > item_to_insert:
            numbers[j+1] = numbers[j]
            j -= 1
        numbers[j+1] = item_to_insert