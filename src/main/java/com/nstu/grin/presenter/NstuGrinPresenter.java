package com.nstu.grin.presenter;

import com.nstu.grin.interfaces.GrinModelInterface;
import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.interfaces.GrinViewInterface;

public class NstuGrinPresenter implements GrinPresenterInterface {
    private GrinModelInterface model;
    private GrinViewInterface view;

    public void setModel(GrinModelInterface model) {
        this.model = model;
    }
    public void setView(GrinViewInterface view) {
        this.view = view;
    }
}
