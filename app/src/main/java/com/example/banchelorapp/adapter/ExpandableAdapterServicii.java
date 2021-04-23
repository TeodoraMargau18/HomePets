package com.example.banchelorapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.banchelorapp.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableAdapterServicii extends BaseExpandableListAdapter {

    Context context;
    List<String> listGroupServicii;
    HashMap<String,List<String>> listItemServicii;

    public ExpandableAdapterServicii(Context context,
                                     List<String> listGroup,
                                     HashMap<String, List<String>> listItem) {
        this.context = context;
        this.listGroupServicii = listGroup;
        this.listItemServicii = listItem;
    }

    @Override
    public int getGroupCount() {
        return listGroupServicii.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItemServicii.get(this.listGroupServicii.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listGroupServicii.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listItemServicii.get(this.listGroupServicii.get(groupPosition)).
                get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group=(String) getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_group_servicii,null);
        }

        TextView textView=convertView.findViewById(R.id.listadeExpandatServicii);
        textView.setText(group);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child=(String) getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) this.context.
            getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_item_sevicii,null);
        }

        TextView textView=convertView.findViewById(R.id.listaCopiiExpandatiServicii);
        textView.setText(child);
        return  convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
