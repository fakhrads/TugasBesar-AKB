package com.example.tugas_besar_akb_if3_cepat_lulus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ProfileFragment extends Fragment implements AdapterView.OnItemClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] profileName = {"Oji","Pukri","Jikun"};

        ListView listView = (ListView)view.findViewById(R.id.list_v);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, profileName);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if(position==0) {
            Intent intent = new Intent(getActivity().getApplication(), OjiActivity.class);
            startActivity(intent);
        }
        if(position==1) {
            Intent intent = new Intent(getActivity().getApplication(), OjiActivity.class);
            startActivity(intent);
        }
        if(position==2) {
            Intent intent = new Intent(getActivity().getApplication(), OjiActivity.class);
            startActivity(intent);
        }
    }
}