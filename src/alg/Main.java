package alg;

import alg.sort.*;
import alg.sort.InsertionSort;
import alg.sort.MergeSort;
import alg.sort.QuickSort;
import alg.sort.SelectionSort;
import alg.sort.ShellSort;
import alg.sort.SortAlg;
import java.io.IOException;

/**
 *
 * @author ideras
 */
public class Main {
    
    public static void main(String[] args) {
        if (!CmdArgs.parse(args)) {
            showUsage();
            System.exit(0);
        }

        if (CmdArgs.genenerateRandomSet) {
            long startTime = System.currentTimeMillis();

            Integer[] items = Util.GenerateRandomArray(CmdArgs.arraySize);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            System.err.println("Array generation elapsed time: " + elapsedTime + " ms");

            System.out.println(items.length);
            for (Integer n : items) {
                System.out.println(n);
            }
            System.exit(0);
        }

        String inFilePath = CmdArgs.inputFilePath;
        if (inFilePath.isEmpty()) {
            System.out.println("You must specify a input file");
            System.exit(0);
        }

        Integer items[] = null;
        try {
            items = Util.readArrayFromFile(inFilePath);
        } catch (IOException ex) {
            System.out.println("File not found + '" + inFilePath + "'");
            System.exit(0);
        }

        System.err.println("Array Size : " + items.length);

        if (CmdArgs.printOriginalArray) {
            System.out.println("Original Array");
            Util.PrintArray(items);
            System.out.println();
        }

        long startTime = System.currentTimeMillis();

        SortAlg sa = null;
        switch (CmdArgs.sortAlg) {
            case SortAlg.BUBBLE_SORT:
                sa = new BubbleSort();
                break;
            case SortAlg.SELECTION_SORT:
                sa = new SelectionSort();
                break;
            case SortAlg.INSERTION_SORT:
                sa = new InsertionSort();
                break;
            case SortAlg.SHELL_SORT:
                sa = new ShellSort();
                break;
            case SortAlg.MERGE_SORT:
                sa = new MergeSort();
                break;
            case SortAlg.QUICK_SORT:
                sa = new QuickSort();
                break;
			case SortAlg.QUICK_SHELL_SORT:
                sa = new QuickShellSort();
                break;
        }
        
        sa.Sort(items);
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        if (CmdArgs.printSortedArray) {
            System.out.println();
            System.out.println("Sorted Array");
            Util.PrintArray(items);
            System.out.println();
        }

        System.out.println("Sorting elapsed time: " + elapsedTime + " ms");
    }

    private static void showUsage() {
        System.err.println("Usage: ");
        System.err.println("1. To generate a random set of integers:");
        System.err.println("    java -jar Alg.jar --generate-random-set --count <size>");
        System.err.println("2. To sort an array from a file:");
        System.err.println("    java -jar Alg.jar --input <file> [--bubble-sort |--selection-sort|--insertion-sort|--merge-sort |--quick-sort] [--print-original-array] [--print-sorted-array]");
    }    
}
