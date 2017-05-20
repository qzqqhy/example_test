package adc.struct.tree;

import java.util.Vector;

/**   
* @Title: Tree.java 
* @Package adc.struct.tree 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午4:43:04 
* @version V1.0   
*/
public class TreeNode {

    private String name;
    private TreeNode node;
    private Vector<TreeNode> childrens=new Vector<TreeNode>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public TreeNode getNode() {
        return node;
    }
    public void setNode(TreeNode node) {
        this.node = node;
    }
    public Vector<TreeNode> childrens() {
        return childrens;
    }
 
    
    public void addNode(TreeNode node){
        this.childrens.addElement(node);
    }
    
    
    public void removeNode(TreeNode node){
        this.childrens.remove(node);
    }
}

