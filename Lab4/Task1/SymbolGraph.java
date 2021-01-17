/*      Lab4,Assignment1,2
        Created:2020-10-01
        Last updated: 2020-10-05
        Author: Amir Ali Safizadeh.
        Purpose of the code: Use binary search tree to store string of vertices and create a graph with them.
        Credit to Robert Sedgewick and Kevin Wayne who written the book Algorithms. the code in this class is inspired from
        the code in the book.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph {
    private BST<String, Integer> st; // create a BST to store the indexes
    private String[] keys; // An array of key (given vertices)
    private Graph G; // create a graph

    public SymbolGraph(File file, String sp) throws FileNotFoundException {

        // Create the binary search tree
        st = new BST<String, Integer>();
        // Scanner to read the file
        Scanner scanner = new Scanner(file);

        // Read all of the vertices store in the file, put them in the BST with some given values
        while (scanner.hasNextLine())
        {
            String[] a = scanner.nextLine().split(sp);

            // Put the Unique vertices name in the BST as the key and assign different values for each of them(size
            // of the bst would be the value)
            for (int i = 0; i < a.length; i++)
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
        }

        // Put all the vertices which store in the BST int
        keys = new String[st.size()];
        for (String name : st.keys())
            keys[st.get(name)] = name;

        // Update the number of vertices in the graph
        G = new Graph(st.size());
        scanner = new Scanner(file);

        // Read all the vertices in the file and with the help of bst, builds the graph by connecting first vertex on each
        //        // line to all other
        while (scanner.hasNextLine())
        {
            // Store the vertices in a temporary array, in that way that the first element is the vertex v and the
            // second element is the vertex w. and we connect vertex v to w and w to v.
            String[] a = scanner.nextLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
                // Using addEdges() method in our grape we connect those to vertices
                G.addEdge(v, st.get(a[i]));
        }
    }


    // Return the value of the key(vertex(
    public int index(String s) {
        return st.get(s);
    }
    // Return the vertex
    public String name(int v) {
        return keys[v];
    }
    // Return the graph
    public Graph G() { return G;
    }


    // Return a string of all the vertices and their adjacent vertices
    public String toString(SymbolGraph sg)
    {
        StringBuilder sb =new StringBuilder();
        sb.append("number of vertices: " + G.V() + " .number of edges: " + G.E());
        sb.append("\n");
        for (int i = 0; i < G.V(); i++) {
            sb.append(sg.name(i) + ":");
            for (int w : G.adj(i))
                sb.append(sg.name(w) + " ");

            sb.append("\n");
        }

        return String.valueOf(sb);
    }

    // Return a string of the given path
    public String toStringPath(SymbolGraph sg, Stack<Integer> stack)
    {

        StringBuilder sb =new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(sg.name(stack.pop()));
            if (stack.size() != 0)
                sb.append("-");
        }

        return String.valueOf(sb);
    }





}
