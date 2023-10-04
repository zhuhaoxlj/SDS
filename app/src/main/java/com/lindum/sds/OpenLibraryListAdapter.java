package com.lindum.sds;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lindum.sds.entity.OpenLibraryEntity;

import java.util.List;

/**
 * @author MarkGosling
 * @date 2022/2/15 3:39
 */
public class OpenLibraryListAdapter extends ArrayAdapter<OpenLibraryEntity> {
    private final int resourceId;

    public OpenLibraryListAdapter(Context context, int textViewResourceId, List<OpenLibraryEntity> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        OpenLibraryEntity openLibraryEntity = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView openLibraryName = view.findViewById(R.id.openLibraryName);
        TextView openLibraryContent = view.findViewById(R.id.openLibraryContent);
        openLibraryName.setText(openLibraryEntity.getName());
        openLibraryContent.setText(openLibraryEntity.getContent());
//        ImageView foodImage = view.findViewById(R.id.foodImage);
//        TextView fibre = view.findViewById(R.id.fibre);
//        TextView cal = view.findViewById(R.id.cal);
//        TextView foodName = view.findViewById(R.id.foodName);
//        foodImage.setImageDrawable(footEntity.getFoodImage());
//        fibre.setText(footEntity.getFibre());
//        cal.setText(footEntity.getCal());
//        foodName.setText(footEntity.getFoodName());
        return view;
    }
}
