/*      Lab4,Assignment2
        Created:2020-10-01
        Last updated: 2020-10-05
        Author: Amir Ali Safizadeh.
        Purpose of the code: Find a path between to given vertices by searching the breadth of the graph first.
        Basically the shortest path between two given vertices
 */


public class BFSTask2 {

    private boolean[] marked;// If there is path between our source vertex and a vertex with the same value as a
    // index of this array, we mark that position as true
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // The vertex that we want to find all of its path

    // Constructor for BFS
    public BFSTask2(Graph G, int s)
    {
        // Update the size of our array to the number of vertices in the graph
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        // Update the source vertex
        this.s = s;
        bfs(G, s);
    }

    // For bfs we start searching from s to the vertices that we can reach only by following one edge and
    // store those vertices into a queue. Then we continue from those vertices(by deQueuing) to vertices that we can reach
    // by one edge(two from the source) and store them into the queue. we do as long as we cover all the possible path
    // of our source vertex.
    private void bfs(Graph G, int s)
    {
        Queue<Integer> queue = new Queue<Integer>();
        // It has a path to itself
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();
            for (int w : G.adj(v))
                if (!marked[w]) {
                    // We put the given vertex to the position of that unmarked vertex
                    edgeTo[w] = v;
                    marked[w] = true;
                    // Enqueue the vertices that we can reach from s by only one edge
                    queue.enqueue(w);
                }
        }
    }

    // Return the true if there is path from the s(source vertex) to v
    public boolean hasPathTo(int v) {
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
