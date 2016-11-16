package com.aleksodem.moneytor.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.aleksodem.moneytor.R;

public class CardBehavior extends CoordinatorLayout.Behavior<CardView> {

    private Context mContext;

    private float mStartToolbarPosition;
    private float mChangeBehaviorPoint;
    private float mChildWidth;
    private float mChildX;
    private float old;

    public CardBehavior(Context context, AttributeSet attrs) {
        super();
        this.mContext = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CardView child, View dependency) {
        return dependency instanceof Toolbar;
    }



    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CardView child, View dependency) {
        initProperties(child, dependency);

        ImageView navigationButton = (ImageView) parent.findViewById(R.id.navigation_menu);
        ImageView moreButton = (ImageView) parent.findViewById(R.id.navigation_more);

        final int maxScrollDistance = (int) (mStartToolbarPosition);
        float expandedPercentageFactor = (dependency.getY())/ maxScrollDistance;

        navigationButton.setAlpha(expandedPercentageFactor);
        moreButton.setAlpha(expandedPercentageFactor);

        child.setY(dependency.getY());
        child.setX(((dependency.getY()) / mChangeBehaviorPoint));
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.width = (int) (mChildWidth + ((mChildX) - (dependency.getY()) / mChangeBehaviorPoint) * 2);
        child.setLayoutParams(lp);

        if (dependency.getY() == 0) {
            child.setY(dependency.getY() - 6);
            child.setX(((dependency.getY()) / mChangeBehaviorPoint) - 3);
            CoordinatorLayout.LayoutParams lp1 = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            lp1.width = (int) ((mChildWidth + ((mChildX) - (dependency.getY()) / mChangeBehaviorPoint) * 2)) + 10;
            child.setLayoutParams(lp1);
        }
        return true;
    }

    private void initProperties(FrameLayout child, View dependency) {
        if (mStartToolbarPosition == 0)
            mStartToolbarPosition = dependency.getY();

        if (mChildX == 0) {
            mChildX = child.getX();
        }

        if (mChangeBehaviorPoint == 0) {
            mChangeBehaviorPoint = (child.getY() / (child.getX()));
        }

        if (mChildWidth == 0) {
            mChildWidth = child.getWidth();
        }
    }
}
