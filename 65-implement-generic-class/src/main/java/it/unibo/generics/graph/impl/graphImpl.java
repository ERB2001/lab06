package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import it.unibo.generics.graph.api.Graph;

import java.util.Queue;

public class GraphImpl<N> implements Graph<N> {

    // List<N> graphList;
    Map<N, Set<N>> graphMap;

    public GraphImpl() {
        // this.graphList = new LinkedList<N>();
        this.graphMap = new HashMap<N, Set<N>>();
    }

    /**
     * Adds a node: nothing happens if node is null or already there.
     * 
     * @param node
     *             the node to add
     */
    public void addNode(N node) {
        /*
         * if (!this.graphList.contains(node)) {
         * this.graphList.add(node);
         * }
         */
        Set<N> graph = new TreeSet<>();
        if (!this.graphMap.containsKey(node) && this.graphMap != null) {
            this.graphMap.put(node, graph);
        }
        return;
    }

    /**
     * Adds an edge: nothing happens if source or target are null.
     * 
     * @param source
     *               starting node
     * @param target
     *               ending node
     */
    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            graphMap.get(source).add(target);

        }
        // System.out.println(graphMap);
        return;
    }

    /**
     * @return all the nodes
     */
    public Set<N> nodeSet() {
        return this.graphMap.keySet();
    }

    /**
     * Returns all the nodes directly targeted from a node.
     * 
     * @param node
     *             the node
     * @return all the nodes directly targeted from the passed node
     */

    public Set<N> linkedNodes(N node) {
        return this.graphMap.get(node);
    }

    /**
     * Gets one sequence of nodes connecting source to target.
     * 
     * @param source
     *                       the source node
     * @param nodeNeighbours
     *                       the target node
     * @return a sequence of nodes connecting sources and target
     */
    
    public List<N> getPath(N source, N target) {
        LinkedList<N> visitedNodeList = new LinkedList<>();
        Queue<N> queue = new LinkedList<>();
        /*
         * in cui vado ad inserire i singoli nodi
         * esplorati durante il ciclo
         */

        queue.add(source);
        while (!queue.isEmpty()) {
            N node = queue.remove();
            visitedNodeList.add(node);
            List<N> nodesNeighboursList = new LinkedList<>(graphMap.get(node));
            if (nodesNeighboursList != null) {
                for (int index = 0; index < nodesNeighboursList.size(); index++) {
                    N nodesN = nodesNeighboursList.get(index);
                    if (nodesN != null && !visitedNodeList.contains(nodesN) && nodesN != target) {
                        queue.add(nodesN);
                    }
                }

                // System.out.println("1 " + queue);
                // System.out.println("2 " + visitedNodeList);
            }
        }
        visitedNodeList.add(target);
        return visitedNodeList;
    }
}
