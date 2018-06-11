package com.nstu.grin.model;

import com.nstu.grin.interfaces.GrinModelInterface;
import com.nstu.grin.interfaces.GrinPresenterInterface;
import com.nstu.grin.pojo.Graphic;

public class NstuGrinModel implements GrinModelInterface {
    private GrinPresenterInterface presenter;

    @Override
    public Graphic getGraphic() {
        return Parser.parse("C:\\Users\\hekpo\\Downloads\\Telegram Desktop\\export.csv");
    }

    @Override
    public void setPresenter(GrinPresenterInterface presenter) {
        this.presenter = presenter;
    }
}
