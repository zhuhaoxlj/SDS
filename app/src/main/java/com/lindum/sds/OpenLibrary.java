package com.lindum.sds;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lindum.sds.entity.OpenLibraryEntity;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.utils.StatusBarUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MarkGosling
 * @date 2022/4/11 14:51
 */

public class OpenLibrary extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XUI.initTheme(this);
        setContentView(R.layout.open_library);
        StatusBarUtils.initStatusBarStyle(this, false);
        TitleBar openLibrariesTitleBar = findViewById(R.id.openLibrariesTitleBar);
        LinearLayout virtualStatusBar = findViewById(R.id.virtualStatusBar);
        // 状态栏高度
        virtualStatusBar.setBackgroundColor(Color.parseColor("#ffffff"));
        ViewGroup.LayoutParams params = virtualStatusBar.getLayoutParams();
        params.height = StatusBarUtils.getStatusBarHeight(this);
        openLibrariesTitleBar.setBackgroundColor(Color.parseColor("#ffffff"));
        ListView openLibrariesList = findViewById(R.id.openLibrariesList);
        List<OpenLibraryEntity> openLibraryList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            OpenLibraryEntity openLibraryEntity = new OpenLibraryEntity();
            openLibraryEntity.setName("Echart");
            openLibraryEntity.setContent("The following software may be included in this product: dagger. This software contains ths following license and notice below:The following software may be included in this product: dagger. This software contains ths following license and notice below:\nThe following software may be included in this product: dagger. This software contains ths following license and notice below:");
            openLibraryList.add(openLibraryEntity);
        }
        OpenLibraryListAdapter openLibrariesListAdapter = new OpenLibraryListAdapter(this, R.layout.open_libray_list_item, openLibraryList);
        openLibrariesList.setAdapter(openLibrariesListAdapter);
    }
}
