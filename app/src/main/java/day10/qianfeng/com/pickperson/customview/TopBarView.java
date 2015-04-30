package day10.qianfeng.com.pickperson.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import day10.qianfeng.com.pickperson.R;

/**
 * Created by aaa on 15-4-30.
 */
public class TopBarView extends RelativeLayout {
    private ImageView leftImageView,rightImageView;
    private TextView tittle;
    private View viewline;

    Drawable leftimage;
    Drawable rightimage;
    int textColor;
    float textSize;
    String textTitle;

    private LayoutParams leftParams, rightParams, titleParams,line;
    public TopBarView(Context context) {
        super(context);
    }

    public TopBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        leftimage= ta.getDrawable(R.styleable.TopBar_leftImage);
        rightimage = ta.getDrawable(R.styleable.TopBar_rightImage);
        textColor = ta.getColor(R.styleable.TopBar_titleTextColor,0);
        textSize=ta.getDimension(R.styleable.TopBar_titleTextSiza,0);
        textTitle=ta.getString(R.styleable.TopBar_topbar_title);

        ta.recycle();
        leftImageView=new ImageView(context);
        rightImageView=new ImageView(context);
        tittle=new TextView(context);
        viewline=new View(context);

        leftImageView.setImageDrawable(leftimage);
        leftImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        rightImageView.setImageDrawable(rightimage);
        rightImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        tittle.setTextColor(textColor);
        tittle.setText(textTitle);
        tittle.setTextSize(textSize);

        tittle.setGravity(Gravity.CENTER);
        viewline.setBackgroundColor(Color.parseColor("#999999"));


        leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftImageView,leftParams);

        rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);

        addView(rightImageView,rightParams);

        titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(CENTER_IN_PARENT,TRUE);

        addView(tittle,titleParams);

//        line=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
//        line.addRule(ALIGN_PARENT_BOTTOM);
//        addView(viewline,line);

        leftImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.leftButtonCallBack(v);
            }
        });

        rightImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                listener.rightButtonCallBack(v);
            }
        });

    }

    private TopbarCallBack listener;
    public interface TopbarCallBack{
        public void leftButtonCallBack(View view);
        public void rightButtonCallBack(View view);

    }
    public void setOnTobCilck(TopbarCallBack listener){
        this.listener=listener;
    }


    public void setLeftImageViewIcon(Drawable drawable){
        leftImageView.setImageDrawable(drawable);
    }

    public void setRigImageView(Drawable drawable){
        rightImageView.setImageDrawable(drawable);
    }
    public void setTittleText(String text){
        tittle.setText(text);
    }
}
