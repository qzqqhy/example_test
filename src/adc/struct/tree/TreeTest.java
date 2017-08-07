package adc.struct.tree;

/**
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 *
 * @author shiwenlong
 * @version V1.0
 * @Title: TreeTest.java
 * @Package adc.struct.tree
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午4:50:06
 */
public class TreeTest {


    public static void main(String[] args) {
        Tree t = new Tree("testroot");
        TreeNode nodeB = new TreeNode();
        nodeB.setName("B");
        TreeNode nodeC = new TreeNode();
        nodeC.setName("c");
        nodeB.addNode(nodeC);
        t.root.addNode(nodeB);
        System.out.println("build the tree finished!" + t.root.childrens().get(0).getName().toString());
    }
}

