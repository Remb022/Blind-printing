package com.example.demo;

import com.example.demo.activity.MenuActivityController;

public class ControllerManager {
    private static ControllerManager instance;

    public MenuActivityController menuActivityController;
    public LayoutController layoutController;

    public static ControllerManager getInstance() {
        if (instance == null) {
            instance = new ControllerManager();
        }
        return instance;
    }

    public void setLayoutController(LayoutController layoutController) {
        this.layoutController = layoutController;
    }
    public LayoutController getLayoutController() {
        return layoutController;
    }

    public void setMenuActivityController(MenuActivityController menuActivityController) {
        this.menuActivityController = menuActivityController;
    }
    public MenuActivityController getMenuActivityController() {
        return menuActivityController;
    }
}
