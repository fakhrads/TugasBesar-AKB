package com.example.tugas_besar_akb_if3_cepat_lulus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class RecyclerView_Config {
    private Context mContext;
    private MapsAdapter mMapsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Maps> maps,
                          List<String> keys) {
        mContext = context;
        mMapsAdapter = new MapsAdapter(maps, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mMapsAdapter);
    }

    class MapItemView extends RecyclerView.ViewHolder{
        private TextView mPlaceName;
        private String key;

        public MapItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.map_list_item, parent, false));

            mPlaceName = (TextView) itemView.findViewById(R.id.placeNameTXT);

            //button set on click
            //send to
        }

        public void bind(Maps map, String key) {
            mPlaceName.setText(map.getTitle());
            this.key = key;
        }
    }
    class MapsAdapter extends RecyclerView.Adapter<MapItemView>{
        private List<Maps> mMapList;
        private List<String> mKeys;

        public MapsAdapter(List<Maps> mMapList, List<String> mKeys) {
            this.mMapList = mMapList;
            this.mKeys = mKeys;

        }

        @NonNull
        @Override
        public MapItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MapItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MapItemView holder, int position) {
            holder.bind(mMapList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mMapList.size();
        }
    }
}
