/*      Lab4,Assignment1
        Created:2020-10-01
        Last updated: 2020-10-05
        Author: Amir Ali Safizadeh.
        Purpose of the code: Find a path between to given vertices by searching the depth of the graph first.
        Credit to Robert Sedgewick and Kevin Wayne who written the book Algorithms. the code in this class is inspired from
        the code in the book.
 */


public class DFSTask1 {
    private boolean[] marked; // If there is path between our source vertex and a vertex with the same value as a
    // index of this array, we mark that position as true
    private int[] edgeTo; // Last vertex on known path to this vertex.
    private final int s; // The vertex that we want to find all of its path.

    // Constructor for DFS.
    public DFSTask1(Graph G, int s)
    {
        // Update the size of our array to the number of vertices in the graph.
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        // Update the source vertex.
        this.s = s;
        dfs(G, s);
    }

    // Recursive function that finds all the paths of the given vertex
    private void dfs(Graph G, int v) {
        // It has a path to itself
        marked[v] = true;
        // Go through all the vertices that adjacent to v
        for (int w : G.adj(v))
            // If the vertex is unmarked
            if (!marked[w]) {
                // We put the given vertex to the position of that unmarked vertex and call dfs with that vertex again
                // to find the depth of the path. (I.e last vertex on known path to this vertex.)
                edgeTo[w] = v;
                dfs(G, w);
            }

    }

    // Return the true if there is path from the s(source vertex) to v
    public boolean hasPathTo(int v){
                return marked[v];
    }

    // Return a path from s to v in a form of  stack<integer>
    public Stack<Integer> pathTo(int v)
    {
        // If there is no path return null;
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        // Push the given vertex into stack so it will become the last element of the stack and then we retrace from it
        // and we find the vertex before it(if there is any) and push it to stack. We do this until we reach the source
        //  vertex
        for (int x = v; x != s; x = edgeTo[x])

            path.push(x);
        // Push the source vertex to stack, no stack starts with the source vertex and return the path
        path.push(s);
        return path;
    }

}
