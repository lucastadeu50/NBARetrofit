package com.example.arlinda.nbaretrofit.animanddrawer;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Animação utitlizada para expandir e colapsar os cards com as inforções dos jogadores
 */


public class DropDownAnim extends Animation {
    private final int targetHeightUp;
    private final int targetHeightDownn;
    private final View view;
    private final boolean down;

    public DropDownAnim(View view, int targetHeightUp, int targetHeightDown, boolean down) {
        this.view = view;
        this.targetHeightUp = targetHeightUp;
        this.targetHeightDownn = targetHeightDown;
        this.down = down;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        int startingheight = view.getHeight();
        int newHeight;
        if (down) {
            newHeight = (int) ( startingheight + ((targetHeightUp - startingheight) * interpolatedTime));
        } else {
            newHeight = (int) (targetHeightDownn + (startingheight - targetHeightDownn ) * (1 - interpolatedTime));

        }
        view.getLayoutParams().height = newHeight;
        view.requestLayout();
    }

    @Override
    public void initialize(int width, int height, int parentWidth,
                           int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}