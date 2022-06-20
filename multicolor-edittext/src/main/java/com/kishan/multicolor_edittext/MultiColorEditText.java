package com.kishan.multicolor_edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MultiColorEditText extends androidx.appcompat.widget.AppCompatEditText {
    private final String TAG = this.getClass().getSimpleName();
    int position = 1;
    private String originalText = "";
    @ColorInt
    private int defaultTextColor = Color.BLACK;
    private int currentTextColor = Color.BLACK;

    public MultiColorEditText(@NonNull Context context) {
        this(context, null);
    }

    public MultiColorEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public MultiColorEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiColorEditText);
        defaultTextColor = typedArray.getColor(R.styleable.MultiColorEditText_defaultColor, defaultTextColor);
        setDefaultTextColor(defaultTextColor);
        typedArray.recycle();

        init();
    }

    private void init() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*if (position == 1 || position == 6) {
                    position = 1;
                    setEditTextColor(Color.BLACK);
                } else if (position == 2) {
                    setEditTextColor(Color.RED);
                } else if (position == 3) {
                    setEditTextColor(Color.GREEN);
                } else if (position == 4) {
                    setEditTextColor(Color.YELLOW);
                } else if (position == 5) {
                    setEditTextColor(Color.BLUE);
                }
                position = position + 1;*/
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void setCurrentTextColor(@NonNull String colorCode) {
        String text = getText().toString();
        text = text + "<font color='" + colorCode + "'>lo</font>";
        setText(text);
    }


    public void setDefaultTextColor(@ColorInt int defaultTextColor) {
        this.defaultTextColor = defaultTextColor;
        setTextColor(this.defaultTextColor);
    }

    private void setEditTextColor(@ColorInt int currentTextColor) {
        this.currentTextColor = currentTextColor;
        setTextColor(this.currentTextColor);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        Log.d(TAG, "setText : " + text.toString());
        originalText = text.toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            text = Html.fromHtml(text.toString(), Html.FROM_HTML_MODE_LEGACY);
        } else {
            text = Html.fromHtml(text.toString());
        }
        super.setText(text, type);
    }

}
