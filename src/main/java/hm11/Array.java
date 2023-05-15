package hm11;

public class Array {
    public static int[] getElementAfterFour (int[]array) {
        int lastIndexOfFour = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                lastIndexOfFour = i;
                break;
            }
        }
        if (lastIndexOfFour == -1) {
            throw new RuntimeException("Array has not a number 4");
        }
        int elementsToCopy = array.length - lastIndexOfFour - 1;
        int[] result = new int[elementsToCopy];
        System.arraycopy(array, lastIndexOfFour + 1, result, 0, elementsToCopy);
        return result;
    }


    public static boolean oneFourInArray(int[] array) {
        boolean hasFour = false;
        boolean hasOne = false;

        for (int nums : array) {
            if (nums == 1) {
                hasOne = true;
            } else if (nums == 4) {
                hasFour = true;
            }
        }
        return hasOne && hasFour;
    }

}
