/*      Lab4,Assignment1,2
        Created:2020-10-01
        Last updated: 2020-10-05
        Author: Amir Ali Safizadeh.
        Purpose of the code: Generate an undirected graph.
        Credit to Robert Sedgewick and Kevin Wayne who written the book Algorithms. the code in this class is inspired from
        the code in the book.
 */




public class Graph
{
    // Number of vertices.
    private final int V;
    // Number of edges.
    private int E;
    // Adjacency lists.
    private Bag<Integer>[] adj;

    // Graph constructor.
    public Graph(int V)
    {
        // Update the number of the vertices to the given one. Update the number od edges
        this.V = V;
        this.E = 0;
        // Resize the array of bags to new number of vertices. Update all the bags in the array.
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    // Return the number of vertices
    public int V() {
        return V;
    }

    // Return the number of edges
    public int E() {
        return E;
    }

    // Add one edge
    public void addEdge(int v, int w)
    {   // Put w in the adjacency list of v. this means that there is an edge between vertex v and vertex w.
        // Because we are aiming for undirected graph the connections are two ways, so we put v in the adjacency list
        // of w.
        adj[v].add(w);
        adj[w].add(v);
        // Update the number of edges
        E++;
    }

    // Return the bag which contains all the adjacent vertices of v.
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


}
