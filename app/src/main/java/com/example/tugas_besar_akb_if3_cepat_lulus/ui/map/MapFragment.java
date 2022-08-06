package com.example.tugas_besar_akb_if3_cepat_lulus.ui.map;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugas_besar_akb_if3_cepat_lulus.R;
import com.example.tugas_besar_akb_if3_cepat_lulus.databinding.FragmentMap2Binding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.maps.OnMapReadyCallback;


public class MapFragment extends Fragment implements OnMapReadyCallback{
    private static final String MY_LOCATION_REQUEST_CODE= "LOCATION_PERMISSIONS";

    double latitude;
    double longitude;
    String title;
    private View fragmentView;
    private GoogleMap mMap;
    private FusedLocationProviderClient client;


    private static final String[] LOCATION_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map2, null, false);

        title = getActivity().getIntent().getStringExtra("title");
        latitude = getActivity().getIntent().getDoubleExtra("latitude", 0);
        longitude = getActivity().getIntent().getDoubleExtra("longitude", 0);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        // Async map
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.

        LatLng warkop99 = new LatLng(-6.739473987604177, 107.67910010594038);
        googleMap.addMarker(new MarkerOptions().position(warkop99)
                .title("Curug Ciangin"));




        LatLng warkopJagoRasa = new LatLng(-6.736802730258575, 107.66641611962608);
        googleMap.addMarker(new MarkerOptions().position(warkopJagoRasa)
                .title("Curug Koleangkak"));


        LatLng yezChicken = new LatLng(-6.9628679175676345, 107.88153175901687);
        googleMap.addMarker(new MarkerOptions().position(yezChicken)
                .title("Curug Cinulang"));


        LatLng kantinaa = new LatLng(-6.790774522005018, 107.58201417855445);
        googleMap.addMarker(new MarkerOptions().position(kantinaa)
                .title("Curug Tilu Leuwi Opat"));


        LatLng butatang = new LatLng(-6.799194687270798, 107.59221126954859);
        googleMap.addMarker(new MarkerOptions().position(butatang)
                .title("Curug Cipanas"));

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if(isPermissionGranted()) {
            client = LocationServices.getFusedLocationProviderClient(getActivity());Task<Location> task = client.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null){
                        LatLng lokasi = new LatLng(location.getLatitude(),location.getLongitude());
                        MarkerOptions options = new MarkerOptions().position(lokasi).title("Lokasi Saat Ini");
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi,17));
                        googleMap.addMarker(options);
                    } else {
                        Toast.makeText(getActivity(),"Tidak dapat membaca lokasi!",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(getActivity(),"Akses lokasi dimatikan!",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isPermissionGranted() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION
                }, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }

    }

}