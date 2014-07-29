package alg;

import alg.sort.SortAlg;

/**
 *
 * @author ideras
 */
public class CmdArgs {

    public static boolean printOriginalArray = false;
    public static boolean printSortedArray = false;
    public static boolean genenerateRandomSet = false;
    public static int arraySize = 100;
    public static String inputFilePath = "";
    public static int sortAlg = SortAlg.BUBBLE_SORT;

    public static boolean parse(String[] args) {
        int context = 0;

        if (args.length != 0) {
            for (String arg : args) {

                switch (context) {
                    case 0:
                        if (arg.compareTo("--print-original-array") == 0) {
                            printOriginalArray = true;
                        } else if (arg.compareTo("--print-sorted-array") == 0) {
                            printSortedArray = true;
                        } else if (arg.compareTo("--generate-random-set") == 0) {
                            genenerateRandomSet = true;
                        } else if (arg.compareTo("--bubble-sort") == 0) {
                            sortAlg = SortAlg.BUBBLE_SORT;
                        } else if (arg.compareTo("--selection-sort") == 0) {
                            sortAlg = SortAlg.SELECTION_SORT;
                        }  else if (arg.compareTo("--insertion-sort") == 0) {
                            sortAlg = SortAlg.INSERTION_SORT;
                        } else if (arg.compareTo("--shell-sort") == 0) {
                            sortAlg = SortAlg.SHELL_SORT;
                        } else if (arg.compareTo("--merge-sort") == 0) {
                            sortAlg = SortAlg.MERGE_SORT;
                        } else if (arg.compareTo("--quick-sort") == 0) {
                            sortAlg = SortAlg.QUICK_SORT;
						} else if (arg.compareTo("--quick-shell-sort") == 0) {
                            sortAlg = SortAlg.QUICK_SHELL_SORT;
                        } else if (arg.compareTo("--count") == 0) {
                            context = 1;
                        } else if (arg.compareTo("--input") == 0) {
                            context = 2;
                        } else {
                            System.out.println("Invalid argument '" + arg + "'");
                            return false;
                        }
                        break;
                    case 1: //Array size
                        try {
                            arraySize = Integer.parseInt(arg, 10);
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid number '" + arg + "'");
                            System.exit(0);
                        }
                        context = 0;
                        break;
                    case 2:
                        inputFilePath = arg;
                        context = 0;
                        break;
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
