package adc.struct.tree;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: Tree.java
 * @Package adc.struct.tree
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午4:43:04
 */
public class Tree {

    TreeNode root = null;

    public Tree(String treeName) {
        super();
        root = new TreeNode();
        root.setName(treeName);
    }


}

