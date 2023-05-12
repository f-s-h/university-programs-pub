package gad.binarysearch;

public final class BinSea {

    private BinSea() {
    }

    // Returns the index
    public static int search(int[] sortedData, int value) {
        int l = 0;
        int r = sortedData.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;
            if (sortedData[m] == value) {
                return m;
            }
            if (sortedData[m] < value) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (l < sortedData.length) {
            return l;
        } else {
            return r;
        }

    }

    // lowerBound -> smallest index, where arr[i] >= value
    public static int search(int[] sortedData, int value, boolean lowerBound) {
        int index = search(sortedData, value);
        if(lowerBound) {
            if(sortedData[index] == value) {
                while(index > 0 && sortedData[index-1] == value) {
                    index--;
                }
            }
            else {
                if(index == sortedData.length-1 && sortedData[sortedData.length-1] < value) {
                    return -1;
                }
                while(index > 0 && sortedData[index-1] >= value) {
                    index--;

                }
            }
        }
        else{
            if(sortedData[index] == value) {
                while(index < (sortedData.length - 1) && sortedData[index+1] == value) {
                    index++;
                }
            }
            else {
                if(index == 0 && sortedData[0] > value) {
                    return -1;
                }
                if(sortedData[index] < value) {
                    while(index < (sortedData.length - 1) && sortedData[index+1] <= value) {
                        index++;
                    }
                }
                else {
                    while(index > 0 && sortedData[index] > value) {
                        index--;
                    }
                }


            }
        }
        return index;
    }

    public static Interval search(int[] sortedData, NonEmptyInterval valueRange) {
        int lower = search(sortedData, valueRange.getFrom(), true);
        if (lower == -1) {
            return Interval.EmptyInterval.getEmptyInterval();
        }
        int higher = search(sortedData, valueRange.getTo(), false);
        if (higher == -1) {
            return Interval.EmptyInterval.getEmptyInterval();
        }
        if(lower > higher) {
            return Interval.EmptyInterval.getEmptyInterval();
        }
        return new NonEmptyInterval(lower, higher);
    }
}