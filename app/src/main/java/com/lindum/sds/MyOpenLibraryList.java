package com.lindum.sds;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @author MarkGosling
 * @date 2022/4/11 19:49收到
 */

public class MyOpenLibraryList extends ListView {
 private static final String TAG = "MyListview";

 public MyOpenLibraryList(Context context) {
  super(context);
 }

 public MyOpenLibraryList(Context context, AttributeSet attrs) {
  super(context, attrs);
 }

 /**
  * 把listview的高度设置为最大值.这样listview全部加载了
  * @param widthMeasureSpec
  * @param heightMeasureSpec
  */
 @Override
 protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
  int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
          MeasureSpec.AT_MOST);
  super.onMeasure(widthMeasureSpec, expandSpec);
 }
}