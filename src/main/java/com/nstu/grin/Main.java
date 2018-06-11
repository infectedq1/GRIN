package com.nstu.grin;

import com.nstu.grin.entities.EDTInvocationHandler;
import com.nstu.grin.interfaces.GrinViewInterface;
import com.nstu.grin.model.NstuGrinModel;
import com.nstu.grin.presenter.NstuGrinPresenter;
import com.nstu.grin.view.NstuGrinView;

public class Main {
    public static void main (String[] abs) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    NstuGrinPresenter presenter = new NstuGrinPresenter();
                    NstuGrinModel model = new NstuGrinModel();

                    GrinViewInterface view = (GrinViewInterface) java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(),
                            new Class[]{GrinViewInterface.class}, new EDTInvocationHandler(new NstuGrinView()));

                    presenter.setModel(model);
                    presenter.setView(view);
                    model.setPresenter(presenter);
                    view.setPresenter(presenter);
                    view.createUI();
                }
            });
    }
}
