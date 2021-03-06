/* Question
Clone an undirected graph. Each node in the graph contains a label and a list of
its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and
each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as
separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a 
self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/              		 

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
       label = x; 
       neighbors = new ArrayList<UndirectedGraphNode>(); 
       }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //key -> old nodes value-> newly created node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new 
            HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneRec(node, map); 
    }
    private UndirectedGraphNode cloneRec(UndirectedGraphNode node, 
                        HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        if (node == null) {
            return null;
        }
        //return the cloned node if the node is already processed
        if (map.containsKey(node)) {
            return map.get(node);
        }
        //create the current node
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        //create new Nodes for node.neighbors and then add to newNode.neighbor.
        for (UndirectedGraphNode graphNodes : node.neighbors) {
            newNode.neighbors.add(cloneRec(graphNodes, map));
        }
        return newNode;
    }
}
