package com.nstu.grin.view;

import com.nstu.grin.entities.OperationButton;
import com.nstu.grin.interfaces.OnButtonClickListener;

import javax.swing.*;

public class OperationsToolbar extends JPanel {
    private OnButtonClickListener<OperationButton> listener;

    public void setOnButtonClickListener(OnButtonClickListener<OperationButton> listener){
        this.listener = listener;
    }
}
