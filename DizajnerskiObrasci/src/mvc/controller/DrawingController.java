package mvc.controller;

import mvc.model.DrawingModel;
import mvc.view.DrawingView;
import ui.FrmDrawing;

public class DrawingController {

    private final DrawingModel model;
    private final DrawingView view;
    private final FrmDrawing frame;

    public DrawingController(DrawingModel model, DrawingView view, FrmDrawing frame) {
        this.model = model;
        this.view = view;
        this.frame = frame;
    }

    // Kasnije ćemo ovdje prebaciti logiku (klik, delete, modify...)
}
