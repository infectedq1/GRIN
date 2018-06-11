package com.nstu.grin.interfaces;

import com.nstu.grin.pojo.Graphic;

public interface GrinModelInterface {
    Graphic getGraphic();

    void setPresenter(GrinPresenterInterface presenter);
}
