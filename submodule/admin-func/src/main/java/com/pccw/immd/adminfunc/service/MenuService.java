package com.pccw.immd.adminfunc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface MenuService {

    public static final String MENU_ROOT_KEY = "ROOT";
    public static final String FUNC_MENU_KEY = "MENU";
    public static final String FUNC_LIST = "FUNC_LIST";

    public MenuItem buildMenuTree() throws IOException;

    public MenuItem buildMenuTree(Map<String, String> propertiesMap);

    public Map<String,String>  getMenuMapping();

        public class MenuItem{
        private String labelKey;
        private String label;
        private String url;

        /**
         * Failed when using getParent() method, Set public for preventing recursive loop error from Thymeleaf to render navigation menu.
         * Ref.: https://stackoverflow.com/questions/29895541/hibernate-and-thymeleaf-infinite-recursion
         */
        public MenuItem parent;
        private List<MenuItem> child = new ArrayList<>();

        public MenuItem(MenuItem parent, String key, String label, String url) {
            this.parent = parent;
            this.labelKey = key;
            this.label = label;
            this.url = url;
        }

        public String getLabel() {
            return label;
        }

        public String getUrl() {
            return url;
        }

        public List<MenuItem> getChild() {
            return child;
        }

        public void addChild(MenuItem menuItem) {
            this.child.add(menuItem);
        }

        public String getLabelKey() {
            return labelKey;
        }

        @Override
        public String toString() {
            return "MenuItem:{" +
                    "label:\"" + label + "\"" +
                    ", url:\"" + url + "\"" +
                    ", paren:" + (parent != null? "\"" + parent.getLabel()+ "\"" :"null") +
                    ", child:" + child +
                    '}';
        }

        public void addAllChild(List<MenuItem> children) {
            this.child.addAll(children);
        }
    }
}
