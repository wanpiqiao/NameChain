# NameChain
Xiaoxi Dong-University of Pittsburgh-Mini Project

This question can be simplified as finding the longest path in a directed graph. Even though we have had may classic solutions to get the shortest path in a graph, most of the algorithms cannot be applied in finding the longest path, except Floyd Algorithm and Dynamic Programming. Since we need to print out the path in this question, Dynamic Programming is better than Floyd Algorithm.

This is a simple java project, and can be compiled by any Java IDE.

###Big-O analysis: 
public static void getNameChain(String[] names){
	 for (int i = 0; i < names.length; i++) {	         O(N)
            ……
        recursive(names, 1);
            ……
       }
}
static void recursive(String[] part, int offset) {		O(N+N)
    if (offset > maxPathLength) {//record longest name chain each time
        ……
        for (int i = 0; i < offset; i++) {				O(N)
            maxPathExample.append(" " + getLastChar(part[i]));
        }
    }
    String lastChar = getLastChar(part[offset - 1]);
    for (int i = offset; i < part.length; i++) {			O(N)
        if (getFirstChar(part[i]).equals(lastChar)) {
        ……
            recursive(names, offset+1);				O(N)
        ……
        }
    }
}

Time: O(N) = O(N^3);
Memory: O(N) = O(N);

I have tried to optimize the time complexity and memory complexity. I give up the solution at last because it may cost much more time to rewrite the whole algorithm, but I will work on that in the future.

###Test:
You can find the test code in src file.
Here are the results.
The program can get the correct result of given example:

<code>
    maximum path length        : 4

    example path of that length: Lebron James Elton John Lennon</code>

I used the subset of UCI Machine Learning Repository Movie Dataset (https://archive.ics.uci.edu/ml/datasets/Movie). And cleaned them with R. The input file is “CeleName.txt”, and the screen shot of output is as follow:

<code>
    maximum path length        : 10
    
    example path of that length: Crane Randolph Anders Glenn Scott Newman Barry Patrick Lee Bill Tony</code>
