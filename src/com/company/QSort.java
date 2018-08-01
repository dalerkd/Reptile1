
package com.company;

public class QSort {
    private int[] array;

    QSort(int[] inNumbers,boolean bB2S) {
        array = inNumbers;
        mySort(0,array.length-1,bB2S);
    }
    public int[] getArr(){
        return array;
    }

    //递归的
    void mySort(int leftIndex, int rightIndex, boolean bB2S) {
        {
            if (leftIndex >= rightIndex) {
                return;
            }
            int standard_value = array[leftIndex];


            //找到标准数新的位置:分水岭的位置
            int standard_new_index = 0;

            //分成两部分
    /*
    左边找一个合适的index
    右遍找一个合适的index

    */
            int tmpLIndex = leftIndex + 1;
            int tmpRIndex = rightIndex;
            for (; ; ) {

//                SORT_INDEX_EQUAL:
                if (tmpLIndex == tmpRIndex)//已经移动到一起了
                {
            /*和标准比较大小
            1   2//
            1   0//就放在其

            */
                    int mid_value = array[tmpLIndex];
                    if (bB2S) {
                        if (standard_value < mid_value) {
                            //标准数需要放在mid右侧

                            array[leftIndex] = array[tmpLIndex];
                            array[tmpLIndex] = standard_value;
                            standard_new_index = tmpLIndex;

                        } else {
                            //标准数需要放在mid左侧

                            standard_new_index = tmpLIndex - 1;
                            array[leftIndex] = array[standard_new_index];
                            array[tmpLIndex - 1] = standard_value;

                        }
                    } else {
                        if (standard_value < mid_value) {
                            //标准数需要放在mid左侧
                            standard_new_index = tmpLIndex - 1;
                            array[leftIndex] = array[standard_new_index];
                            array[tmpLIndex - 1] = standard_value;
                        } else {
                            //标准数需要放在mid右侧
                            array[leftIndex] = array[tmpLIndex];
                            array[tmpLIndex] = standard_value;
                            standard_new_index = tmpLIndex;
                        }
                    }
                    break;
                }

                for (; ; ++tmpLIndex) {
                    if (tmpLIndex == tmpRIndex) {
                        break;
                    }
                    if (bB2S) {
                        if (array[tmpLIndex] < standard_value) {
                            break;
                        }
                    } else {
                        if (array[tmpLIndex] > standard_value) {
                            break;
                        }
                    }
                }

                for (; ; --tmpRIndex) {
                    if (tmpLIndex == tmpRIndex) {
                        break;
                    }
                    if (bB2S) {
                        if (array[tmpRIndex] > standard_value) {
                            break;
                        }
                    } else {
                        if (array[tmpRIndex] < standard_value) {
                            break;
                        }
                    }
                }

                if (tmpLIndex == tmpRIndex) {
                   continue;
                }
                //交换
                if (bB2S) {
                    if (array[tmpLIndex] < array[tmpRIndex]) {
                        int tmp = array[tmpRIndex];
                        array[tmpRIndex] = array[tmpLIndex];
                        array[tmpLIndex] = tmp;
                    }
                } else {
                    if (array[tmpLIndex] > array[tmpRIndex]) {
                        int tmp = array[tmpRIndex];
                        array[tmpRIndex] = array[tmpLIndex];
                        array[tmpLIndex] = tmp;
                    }
                }
                if (1 == (tmpRIndex - tmpLIndex))//已经相临 且经过前面的交换
                {
            /*
            似乎很简单
            */
                    array[leftIndex] = array[tmpLIndex];
                    array[tmpLIndex] = standard_value;
                    standard_new_index = tmpLIndex;
                    break;
                }

            }

            //防止边界
            if (standard_new_index != leftIndex) {
                mySort(leftIndex, standard_new_index - 1, bB2S);
            }
            if (standard_new_index != rightIndex) {
                mySort(standard_new_index + 1, rightIndex, bB2S);
            }
            return;
        }
    }
}
