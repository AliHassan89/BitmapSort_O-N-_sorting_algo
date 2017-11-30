/*
You created a game that is more popular than Angry Birds.
Each round, players receive a score between 0 and 100, which you use to rank 
them from highest to lowest. So far you're using an algorithm that sorts in 
O(n\lg{n})O(nlgn) time, but players are complaining that their rankings aren't 
updated fast enough. You need a faster sorting algorithm.

Write a function that takes:

an array of unsortedScores
the highestPossibleScore in the game
and returns a sorted array of scores in less than O(n\lg{n})O(nlgn) time.

For example:

  int[] unsortedScores = {37, 89, 41, 65, 91, 53};
final int HIGHEST_POSSIBLE_SCORE = 100;

int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
// sortedScores: [91, 89, 65, 53, 41, 37]

We’re defining nn as the number of unsortedScores because we’re expecting the 
number of players to keep climbing.

And we'll treat highestPossibleScore as a constant instead of factoring it into 
our big O time and space costs, because the highest possible score isn’t going 
to change. Even if we do redesign the game a little, the scores will stay around 
the same order of magnitude.

 */
package bitmapsort;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

/**
 *
 * @author Ali
 */
public class BitMapSort 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] unsortedScores = {37, 89, 41, 65, 91, 53};
        int[] sortedArr = bitMapSort(unsortedScores, 100);
        
        for (int i:sortedArr)
            System.out.print(i+", ");
        
    }
    
    private static int[] bitMapSort(int[] unsorted, int maxVal)
    {
        int len = unsorted.length;
        if (len <= 1)
            return unsorted;
        
        BitArray bitArr = new BitArray(maxVal+1);
        
        for (int i=0; i<len; i++)
        {
            bitArr.setBit(unsorted[i]);
        }
        
        int[] sortedArr = new int[len];
        int j = 0;
        
        for(int i=0; i<maxVal+1; i++)
        {
            if (bitArr.getBit(i))
            {
                sortedArr[j] = i;
                j++;
            }
        }
        
        return sortedArr;
    }
    
}
