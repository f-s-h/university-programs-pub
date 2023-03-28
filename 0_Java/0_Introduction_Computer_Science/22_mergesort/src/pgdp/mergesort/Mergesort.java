package pgdp.mergesort;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    private static boolean isSorted(List<Integer> list) {
        int prev = list.get(0);
        for(int i: list){
            if (i < prev){
                return false;
            }
            prev = i;
        }
        return true;
    }

    private static void splitList(List<Integer> list, List<Integer> leftHalf, List<Integer> rightHalf){
        int middleIndex = list.size() / 2;

        for(int i = 0; i < middleIndex; i++){
            leftHalf.add(list.get(i));
        }

        for(int i = middleIndex; i < list.size(); i++){
            rightHalf.add(list.get(i));
        }
    }

    public static List<Integer> mergeLists(List<Integer> leftHalf, List<Integer> rightHalf){
        List<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < leftHalf.size() && rightIndex < rightHalf.size()){
            if(leftHalf.get(leftIndex) < rightHalf.get(rightIndex)){
                mergedList.add(leftHalf.get(leftIndex));
                leftIndex++;
            }
            else{
                mergedList.add(rightHalf.get(rightIndex));
                rightIndex++;
            }
        }

        //If one index has reached the end, add all elements of the remaining list
        //There is no if condition because the for-loop itself is checking whether one index has reached the end
        for(int i = leftIndex; i < leftHalf.size(); i++){
            mergedList.add(leftHalf.get(i));
        }
        for(int i = rightIndex; i < rightHalf.size(); i++){
            mergedList.add(rightHalf.get(i));
        }

        return mergedList;
    }

    public static List<Integer> mergesort(List<Integer> list) {
        if(list.size() < 2 || isSorted(list)){
            return list;
        }

        List<Integer> leftHalf = new ArrayList<>();
        List<Integer> rightHalf = new ArrayList<>();
        splitList(list, leftHalf, rightHalf);

        leftHalf = mergesort(leftHalf);
        rightHalf = mergesort(rightHalf);

        list = mergeLists(leftHalf, rightHalf);

        return list;
    }
}
