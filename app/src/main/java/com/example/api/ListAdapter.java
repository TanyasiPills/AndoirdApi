package com.example.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Telephones> {
    private final List<Telephones> itemList;
    private Context myContext;
    public ListAdapter(Context context, List<Telephones> items) {
        super(context, R.layout.listitem);
        this.itemList = items;
        this.myContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }

        Telephones item = getItem(position);

        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemCategory = convertView.findViewById(R.id.item_kategory);
        TextView itemPrice = convertView.findViewById(R.id.item_price);
        TextView itemCount = convertView.findViewById(R.id.item_count);

        itemName.setText(item.getName());
        itemCategory.setText(item.getCategory());
        itemPrice.setText(String.valueOf(item.getPrice()));
        itemCount.setText(String.valueOf(item.getCount()));

        return convertView;
    }
}
