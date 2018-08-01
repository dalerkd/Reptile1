package com.company;

/*
* // 问题二：实现一个整数数组类 MyArray, 里面包含一个数组， 有5种操作：
// 1. 添加一个整数到数组中，例：myArray.add(5)
// 2. 从小到大排序, 例：myArray.sort()
// 3. 获取数组最大值, 例：myArray.max()
// 4. 获取数组长度, 例：myArray.length()
// 5. 获取内部的数组, 返回一个数组, 例：int[] output = myArray.output()
// 注：在java中定义一个整数数组的语法: int[] array = new int[20];
// java遍历一个数组的语法：for (int i = 0; i < array.size(); i++) System.out.print(array[i])
*
* */
public class MyArray {
    private int[] array = null;

    public void add(int number) {
        int len;
        if(array!=null) {
            len  = array.length;
        }else
        {
            len = 0;
        }
        int[] arrayTemp = new int[len + 1];
        if (array!=null) {
            for (int i = 0; i < array.length; i++) {
                arrayTemp[i] = array[i];
            }
        }
        array = arrayTemp;
        array[len] = number;
    }

    /*
     * 从小到大排序:qsort
     * */
    public void sort() {
        QSort x = new QSort(array, false);
        array = x.getArr();
    }

    /*
     * 遍历找最大
     * */
    public int max() {
        int max = 0;
        boolean one = false;
        for (int tempNumber : array) {
            if (!one) {
                one = true;
                max = tempNumber;
            } else {
                if (tempNumber > max) {
                    max = tempNumber;
                }
            }
        }
        if (!one) {
            throw new ArithmeticException();
        }
        return max;

    }

    public int length() {
        return array.length;
    }

    public int[] output() {
        return array;
    }

}
