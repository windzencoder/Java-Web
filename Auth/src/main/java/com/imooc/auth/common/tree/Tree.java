package com.imooc.auth.common.tree;

import com.imooc.auth.entity.Functions;

import java.util.*;

/**
 * Tree和function相关联的
 */
public class Tree {
    private List<Node> nodes=new LinkedList<>();

    private Node root=null;//根节点

    public Tree(List<Functions> functionsList){
        for(Functions function :functionsList){
            Node node=new Node(function.getId(),function.getParentId(),function.getName(),"open",function.getSerialNum()
            ,new NodeAttribute(function.getId(),null==function.getUrl()? "": function.getUrl()));

            if(node.getParentId()==0)
                root=node;
        }
    }

    public List<Node> build(){
        buildTree(root);
        List<Node> results=new ArrayList<>();
        results.add(root);
        return results;
    }

    private void buildTree(Node parent){
        Node node=null;
        Iterator<Node> it=nodes.iterator();
        while (it.hasNext()){
            node=it.next();
            if(Objects.equals(node.getParentId(),parent.getId())){
                parent.getChildren().add(node);
            }
            buildTree(node);
        }
    }
}
