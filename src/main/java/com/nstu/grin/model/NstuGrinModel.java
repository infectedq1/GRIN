package com.nstu.grin.model;

import com.nstu.grin.interfaces.GrinModelInterface;
import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.pojo.Graphic;

public class NstuGrinModel implements GrinModelInterface {
    private GrinPresenterInterface presenter;

    @Override
    public Graphic getGraphic(String fileName) {
        return Parser.parse(fileName);
    }

    @Override
    public void setPresenter(GrinPresenterInterface presenter) {
        this.presenter = presenter;
    }
}
