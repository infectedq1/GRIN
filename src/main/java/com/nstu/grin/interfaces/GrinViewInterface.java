package com.nstu.grin.interfaces;

import com.nstu.grin.entities.ToolbarButton;

public interface GrinViewInterface {
    void createUI();
    void setPresenter(GrinPresenterInterface pres);
    void windowToolbarButtonListener (ToolbarButton btn);
    void operationsToolbarButtonListener (ToolbarButton btn);
}
 