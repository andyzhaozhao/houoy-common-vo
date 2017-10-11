package com.houoy.common.vo;

import com.houoy.common.utils.BeanRefUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构的vo
 * Created by andyzhao on 2017/5/12.
 */
public abstract class TreeVO<T> extends SuperVO {

    private List<T> nodes ;

    public abstract String getParentPKField();

    public List<T> getNodes() {
        return nodes;
    }

    public void setNodes(List<T> nodes) {
        this.nodes = nodes;
    }

    public final static String RootParentPk = "0";

    public static <P extends TreeVO> TreeVO listToTreeNode(List<P> arr) throws Exception {
        Map<String, TreeVO> map = new HashMap();
        TreeVO _root = null;
        for (int i = 0; i < arr.size(); i++) {
            TreeVO node = arr.get(i);
            String id = BeanRefUtil.getFieldValue(node, node.getPKField());
            String pid = BeanRefUtil.getFieldValue(node, node.getParentPKField());
            if (map.containsKey(pid)) {
                TreeVO parentNode = map.get(pid);
                if(parentNode.getNodes() == null){
                    parentNode.setNodes(new ArrayList());
                }
                parentNode.getNodes().add(node);
            }
            map.put(id, node);
            if (_root == null) {
                if (RootParentPk.equals(pid)) {
                    _root = node;
                }
            }
        }

        return _root;
    }
}
