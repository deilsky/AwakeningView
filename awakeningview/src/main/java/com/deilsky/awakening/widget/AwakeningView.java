package com.deilsky.awakening.widget;

import android.graphics.drawable.GradientDrawable;
import android.view.View;

/**
 * Created by deilsky on 2017/8/29.
 */

public class AwakeningView {
    private enum BorderType {
        CIRCLE,
        RECTANGLE
    }

    private View[] mView;

    private int mFillColor;
    private int mStrokeColor;
    private int mStrokeSize;

    private BorderType mBorderType;
    private int mRadiusAll = 0;
    private float mRadiusLeftTop = 0;
    private float mRadiusLeftBottom = 0;
    private float mRadiusRightTop = 0;
    private float mRadiusRightBottom = 0;

    private int mDashGap = 0;
    private int mDashWidth = 0;

    private int mAlpha = 255;


    private AwakeningView(CircleBuilder circleBuilder) {
        this.mBorderType = BorderType.CIRCLE;
        this.mFillColor = circleBuilder.mFillColor;
        this.mStrokeColor = circleBuilder.mStrokeColor;
        this.mStrokeSize = circleBuilder.mStrokeSize;
    }

    private AwakeningView(RectangleBuilder rectangleBuilder) {
        this.mBorderType = BorderType.RECTANGLE;
        this.mFillColor = rectangleBuilder.mFillColor;
        this.mStrokeColor = rectangleBuilder.mStrokeColor;
        this.mStrokeSize = rectangleBuilder.mStrokeSize;
        this.mRadiusAll = rectangleBuilder.mRadiusAll;
        this.mRadiusLeftTop = rectangleBuilder.mRadiusLeftTop;
        this.mRadiusLeftBottom = rectangleBuilder.mRadiusLeftBottom;
        this.mRadiusRightTop = rectangleBuilder.mRadiusRightTop;
        this.mRadiusRightBottom = rectangleBuilder.mRadiusRightBottom;
    }


    public static class CircleBuilder {
        private static CircleBuilder builder;
        private int mFillColor = 0;
        private int mStrokeSize = 1;
        private int mStrokeColor = 0;

        public static CircleBuilder create() {
            builder = new CircleBuilder();
            return builder;
        }

        private CircleBuilder() {
        }

        public CircleBuilder fillColor(int fillColor) {
            this.mFillColor = fillColor;
            return this;
        }

        public CircleBuilder strokeColor(int strokeColor) {
            this.mStrokeColor = strokeColor;
            return this;
        }

        public CircleBuilder strokeSize(int strokeSize) {
            this.mStrokeSize = strokeSize;
            return this;
        }

        public AwakeningView build() {
            return new AwakeningView(this);
        }
    }

    public static class RectangleBuilder {
        private static RectangleBuilder builder;
        private int mFillColor = 0;
        private int mStrokeSize = 1;
        private int mStrokeColor = 0;
        private int mRadiusAll = 0;
        private float mRadiusLeftTop = 0;
        private float mRadiusLeftBottom = 0;
        private float mRadiusRightTop = 0;
        private float mRadiusRightBottom = 0;

        public static RectangleBuilder create() {
            builder = new RectangleBuilder();
            return builder;
        }

        private RectangleBuilder() {
        }

        public RectangleBuilder fillColor(int fillColor) {
            this.mFillColor = fillColor;
            return this;
        }

        public RectangleBuilder strokeColor(int strokeColor) {
            this.mStrokeColor = strokeColor;
            return this;
        }

        public RectangleBuilder strokeSize(int strokeSize) {
            this.mStrokeSize = strokeSize;
            return this;
        }

        public RectangleBuilder connerAll(int radius) {
            this.mRadiusAll = radius;
            return this;
        }

        public RectangleBuilder connerLeftTop(float radius) {
            this.mRadiusLeftTop = radius;
            return this;
        }

        public RectangleBuilder connerLeftBottom(float radius) {
            this.mRadiusLeftBottom = radius;
            return this;
        }

        public RectangleBuilder connerRightTop(float radius) {
            this.mRadiusRightTop = radius;
            return this;
        }

        public RectangleBuilder connerRightBottom(float radius) {
            this.mRadiusRightBottom = radius;
            return this;
        }


        public AwakeningView build() {
            return new AwakeningView(this);
        }
    }

    private AwakeningView() {

    }

    public AwakeningView target(View... view) {
        this.mView = view;
        return this;
    }

    public AwakeningView dashGap(int dashGap) {
        this.mDashGap = dashGap;
        return this;
    }

    public AwakeningView dashWidth(int dashWidth) {
        this.mDashWidth = dashWidth;
        return this;
    }

    public AwakeningView alpha(int alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public void build() {
        switch (mBorderType) {
            case CIRCLE:
                builderCircle();
                break;
            case RECTANGLE:
                builderRectangle();
                break;
        }

    }

    private void builderCircle() {
        GradientDrawable gradientDrawable = null;
        for (View view : mView) {
            view.setBackground(null);

            if (view.getBackground() != null) {
                gradientDrawable = (GradientDrawable) view.getBackground();
            } else {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setShape(GradientDrawable.OVAL);
            if (mFillColor != 0) {
                gradientDrawable.setColor(mFillColor);
            }
            if (mDashGap > 0 && mDashWidth > 0) {
                gradientDrawable.setStroke(mStrokeSize, mStrokeColor, mDashWidth, mDashGap);
            } else {
                gradientDrawable.setStroke(mStrokeSize, mStrokeColor);
            }
            gradientDrawable.setAlpha(mAlpha);

            view.setBackground(gradientDrawable);
        }
    }

    private void builderRectangle() {
        GradientDrawable gradientDrawable = null;
        for (View view : mView) {
            view.setBackground(null);
            if (view.getBackground() != null) {
                gradientDrawable = (GradientDrawable) view.getBackground();
            } else {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            if (mFillColor != 0) {
                gradientDrawable.setColor(mFillColor);
            }
            if (mDashGap > 0 && mDashWidth > 0) {
                gradientDrawable.setStroke(mStrokeSize, mStrokeColor, mDashWidth, mDashGap);
            } else {
                gradientDrawable.setStroke(mStrokeSize, mStrokeColor);
            }
            if (mRadiusAll > 0) {
                gradientDrawable.setCornerRadius(mRadiusAll);
            } else {
                gradientDrawable.setCornerRadii(
                        new float[]{
                                mRadiusLeftTop, mRadiusLeftTop,
                                mRadiusRightTop, mRadiusRightTop,
                                mRadiusRightBottom, mRadiusRightBottom,
                                mRadiusLeftBottom, mRadiusLeftBottom,
                        }
                );
            }
            gradientDrawable.setAlpha(mAlpha);
            view.setBackground(gradientDrawable);
        }
    }
}
