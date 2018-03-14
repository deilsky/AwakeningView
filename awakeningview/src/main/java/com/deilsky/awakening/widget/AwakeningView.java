package com.deilsky.awakening.widget;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
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

    /**
     * @param circleBuilder 构造圆形View
     */
    private AwakeningView(CircleBuilder circleBuilder) {
        this.mBorderType = BorderType.CIRCLE;
        this.mFillColor = circleBuilder.mFillColor;
        this.mStrokeColor = circleBuilder.mStrokeColor;
        this.mStrokeSize = circleBuilder.mStrokeSize;
    }

    /**
     * @param rectangleBuilder 构造圆角矩形View
     */
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

        /**
         * @param fillColor 填充颜色
         * @return CirCleBuilder
         */
        public CircleBuilder fillColor(@ColorRes int fillColor) {
            this.mFillColor = fillColor;
            return this;
        }

        /**
         * @param strokeColor 边框颜色
         * @return CirCleBuilder
         */

        public CircleBuilder strokeColor(@ColorRes int strokeColor) {
            this.mStrokeColor = strokeColor;
            return this;
        }

        /**
         * @param strokeSize 边框宽度
         * @return CirCleBuilder
         */

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
        private int mRadiusLeftTop = 0;
        private int mRadiusLeftBottom = 0;
        private int mRadiusRightTop = 0;
        private int mRadiusRightBottom = 0;

        public static RectangleBuilder create() {
            builder = new RectangleBuilder();
            return builder;
        }

        private RectangleBuilder() {
        }

        /**
         * @param fillColor 填充颜色
         * @return RectangleBuilder
         */
        public RectangleBuilder fillColor(@ColorRes int fillColor) {

            this.mFillColor = fillColor;
            return this;
        }

        /**
         * @param strokeColor 边框颜色
         * @return RectangleBuilder
         */

        public RectangleBuilder strokeColor(@ColorRes int strokeColor) {
            this.mStrokeColor = strokeColor;
            return this;
        }

        /**
         * @param strokeSize 边框宽度
         * @return RectangleBuilder
         */
        public RectangleBuilder strokeSize(int strokeSize) {
            this.mStrokeSize = strokeSize;
            return this;
        }

        /**
         * @param radius 统一设置圆角半径
         * @return RectangleBuilder
         */
        public RectangleBuilder connerAll(int radius) {
            this.mRadiusAll = radius;
            return this;
        }

        /**
         * @param radius 单独设置左上圆角半径
         * @return RectangleBuilder
         */
        public RectangleBuilder connerLeftTop(int radius) {
            this.mRadiusLeftTop = radius;
            return this;
        }

        /**
         * @param radius 单独设置左下圆角半径
         * @return RectangleBuilder
         */
        public RectangleBuilder connerLeftBottom(int radius) {
            this.mRadiusLeftBottom = radius;
            return this;
        }

        /**
         * @param radius  单独设置右上圆角半径
         * @return RectangleBuilder
         */
        public RectangleBuilder connerRightTop(int radius) {
            this.mRadiusRightTop = radius;
            return this;
        }

        /**
         * @param radius 单独设置右下圆角半径
         * @return RectangleBuilder
         */
        public RectangleBuilder connerRightBottom(int radius) {
            this.mRadiusRightBottom = radius;
            return this;
        }


        public AwakeningView build() {
            return new AwakeningView(this);
        }
    }

    private AwakeningView() {

    }

    /**
     * @param view 圆角View 目标
     * @return AwakeningView
     */
    public AwakeningView target(View... view) {
        this.mView = view;
        return this;
    }

    /**
     * @param dashGap 虚线间隔
     * @return AwakeningView
     */
    public AwakeningView dashGap(int dashGap) {
        this.mDashGap = dashGap;
        return this;
    }

    /**
     * @param dashWidth 虚线宽度
     * @return AwakeningView
     */
    public AwakeningView dashWidth(int dashWidth) {
        this.mDashWidth = dashWidth;
        return this;
    }

    /**
     * @param alpha 透明度
     * @return AwakeningView
     */
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
                gradientDrawable.setColor(color(mFillColor));
            }
            if (mDashGap > 0 && mDashWidth > 0) {
                gradientDrawable.setStroke(measureInt(mStrokeSize), color(mStrokeColor), measureInt(mDashWidth), measureInt(mDashGap));
            } else {
                gradientDrawable.setStroke(measureInt(mStrokeSize), color(mStrokeColor));
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
                gradientDrawable.setColor(color(mFillColor));
            }
            if (mDashGap > 0 && mDashWidth > 0) {
                gradientDrawable.setStroke(measureInt(mStrokeSize), color(mStrokeColor), measureInt(mDashWidth), measureInt(mDashGap));
            } else {
                gradientDrawable.setStroke(measureInt(mStrokeSize), color(mStrokeColor));
            }
            if (mRadiusAll != 0) {
                gradientDrawable.setCornerRadius(measureInt(mRadiusAll));
            } else {
                gradientDrawable.setCornerRadii(
                        new float[]{
                                measureFloat(mRadiusLeftTop), measureFloat(mRadiusLeftTop),
                                measureFloat(mRadiusRightTop), measureFloat(mRadiusRightTop),
                                measureFloat(mRadiusRightBottom), measureFloat(mRadiusRightBottom),
                                measureFloat(mRadiusLeftBottom), measureFloat(mRadiusLeftBottom)
                        }
                );
            }
            gradientDrawable.setAlpha(mAlpha);
            view.setBackground(gradientDrawable);
        }
    }

    private int measureInt(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, mView[0].getResources().getDisplayMetrics());
    }
    private float measureFloat(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, mView[0].getResources().getDisplayMetrics());
    }
    private int color(int resId){
        return ContextCompat.getColor(mView[0].getContext(),resId);
    }
}
