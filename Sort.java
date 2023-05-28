import java.util.Arrays;
 
class Sort{

        public static void main(String[] args)
    {
        int[] array = { 6, 4, 7, 1, 9, -2 };
 
        // выполняем иерархическую сортировку массива
        heapsort(array);
 
        // печатаем отсортированный массив
        System.out.println(Arrays.toString(array));
    }
    // вернуть левого потомка `array[i]`
    private static int LEFT(int i) {
        return (2*i + 1);
    }
 
    // вернуть правого потомка `array[i]`
    private static int RIGHT(int i) {
        return (2*i + 2);
    }
 
    // Вспомогательная функция для замены двух индексов в массиве
    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    // Рекурсивный алгоритм heapify-down. Узел с индексом `i` и два его прямых потомка нарушают свойство кучи
    private static void heapify(int[] array, int i, int size)
    {
        // получить левый и правый потомки узла с индексом `i`
        int left = LEFT(i);
        int right = RIGHT(i);
 
        int largest = i;
 
        // сравниваем `array[i]` с его левым и правым дочерними элементами
        // и находим наибольшее значение
        if (left < size && array[left] > array[i]) {
            largest = left;
        }
 
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
 
        // поменяться местами с потомком, имеющим большее значение и
        // вызовите heapify-down для дочернего элемента
        if (largest != i)
        {
            swap(array, i, largest);
            heapify(array, largest, size);
        }
    }
 
    // Функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int pop(int[] array, int size)
    {
        // если в куче нет элементов
        if (size <= 0) {
            return -1;
        }
 
        int top = array[0];
 
        // заменяем корень кучи последним элементом
        // массива
        array[0] = array[size-1];
 
        // вызовите heapify-down на корневом узле
        heapify(array, 0, size - 1);
 
        return top;
    }
 
    // Функция для выполнения пирамидальной сортировки массива `array` размера `n`
    public static void heapsort(int[] array)
    {
        // строим приоритетную очередь и инициализируем ее заданным массивом
        int n = array.length;
 
        // Build-heap: вызывать heapify, начиная с последнего внутреннего
        // узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(array, i--, n);
        }
 
        // несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0)
        {
            array[n - 1] = pop(array, n);
            n--;
        }
    }
 

}