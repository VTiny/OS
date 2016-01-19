package osdesign.model;

import java.util.List;

/**
 * Created by pokerface_lx
 */
public class FileTreeNode {

    private String myPath;
    private String fatherPath;
    private List<String> childrenPaths;

    public FileTreeNode() {}

    /***
     * FileTreeNode(String myPath, String fatherPath) 构造方法
     *
     * @param myPath
     * @param fatherPath
     */
    public FileTreeNode(String myPath, String fatherPath) {
        this.myPath = myPath;
        this.fatherPath = fatherPath;
        this.childrenPaths = null;
    }

    /***
     * FileTreeNode(String myPath, String fatherPath, List<String> childrenPaths) 构造方法
     *
     * @param myPath
     * @param fatherPath
     * @param childrenPaths
     */
    public FileTreeNode(String myPath, String fatherPath, List<String> childrenPaths) {
        this.myPath = myPath;
        this.fatherPath = fatherPath;
        this.childrenPaths = childrenPaths;
    }

    /***
     * addChild(String childPath) 添加子文件目录方法
     *
     * @param childPath
     */
    public void addChild(String childPath) {
        this.childrenPaths.add(childPath);
    }

    public String getMyPath() {
        return myPath;
    }

    public void setMyPath(String myPath) {
        this.myPath = myPath;
    }

    public String getFatherPath() {
        return fatherPath;
    }

    public void setFatherPath(String fatherPath) {
        this.fatherPath = fatherPath;
    }

    public List<String> getChildrenPaths() {
        return childrenPaths;
    }

    public void setChildrenPaths(List<String> childrenPaths) {
        this.childrenPaths = childrenPaths;
    }
}
