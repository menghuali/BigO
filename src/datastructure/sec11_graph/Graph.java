package datastructure.sec11_graph;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<Integer, Set<Integer>> adjacentList;

    public Graph() {
        adjacentList = new HashMap<>();
    }

    public void addVertex(int node) {
        adjacentList.put(node, new HashSet<>());
    }

    public void addEdge(int node1, int node2) {
        if (!(adjacentList.containsKey(node1) && adjacentList.containsKey(node2))) {
            throw new InvalidParameterException(String.format("Node %d or %d is not in graph.", node1, node2));
        }

        var edges1 = adjacentList.get(node1);
        edges1.add(node2);

        var edges2 = adjacentList.get(node2);
        edges2.add(node1);
    }

    public void showConnections() {
        var nodes = adjacentList.entrySet().iterator();
        while (nodes.hasNext()) {
            var node = nodes.next();
            var conns = node.getValue().iterator();
            StringBuilder connsText = new StringBuilder();
            while (conns.hasNext())
                connsText.append(conns.next()).append(' ');
            System.out.println(String.format("%d --> %s", node.getKey(), connsText));
        }
    }

    public int getNumberOfNodes() {
        return adjacentList.keySet().size();
    }

    public static void main(String[] args) {
        var myGraph = new Graph();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(6, 5);

        myGraph.showConnections();
    }

}
