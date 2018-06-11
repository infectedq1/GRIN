package com.nstu.grin.interfaces;

public interface GrinPresenterInterface {
    void setModel(GrinModelInterface model);

    void setView(GrinViewInterface view);

    void openFile(String fileName);
}
