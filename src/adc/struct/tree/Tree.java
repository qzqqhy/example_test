package adc.struct.tree;
/**   
* @Title: Tree.java 
* @Package adc.struct.tree 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午4:43:04 
* @version V1.0   
*/
public class Tree {

    TreeNode root = null;  
    public Tree(String treeName) {
        super();
        root=new TreeNode();
        root.setName(treeName);
    }
    
      
}

