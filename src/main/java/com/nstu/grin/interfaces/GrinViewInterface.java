package com.nstu.grin.interfaces;

import com.nstu.grin.pojo.Graphic;

public interface GrinViewInterface {
    void createUI();

    void setPresenter(GrinPresenterInterface pres);

    void drawGraphic(Graphic graphic);
}
 