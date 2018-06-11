package com.nstu.grin.view;

import com.nstu.grin.interfaces.OnButtonClickListener;

import javax.swing.*;

public class OperationsToolbar extends JPanel {

    private OnButtonClickListener listener;

    public void setOnButtonClickListener(OnButtonClickListener listener){
        this.listener = listener;
    }
}
