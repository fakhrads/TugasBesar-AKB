package com.example.tugas_besar_akb_if3_cepat_lulus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListMapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMapsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    public ListMapsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListMapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListMapsFragment newInstance(String param1, String param2) {
        ListMapsFragment fragment = new ListMapsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_maps, container, false);
        // Inflate the layout for this fragment
        lvItems = (ListView) v.findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        readItems(); // <---- Add this line
        itemsAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        Button button = (Button) v.findViewById(R.id.btnAddItem);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText etNewItem = (EditText) getActivity().findViewById(R.id.etNewItem);
                String itemText = etNewItem.getText().toString();
                itemsAdapter.add(itemText);
                etNewItem.setText("");
                writeItems();
            }
        });

        return v;
    }
    private void readItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        writeItems();
                        return true;
                    }

                });
    }
}