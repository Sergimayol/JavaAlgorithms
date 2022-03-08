def bubbleSort(numbers):
    exchange = True
    while exchange:
        exchange = False
        for i in range(len(numbers)-1):
            if numbers[i] > numbers[i+1]:
                numbers[i], numbers[i+1] = numbers[i+1], numbers[i]
                exchange = True
