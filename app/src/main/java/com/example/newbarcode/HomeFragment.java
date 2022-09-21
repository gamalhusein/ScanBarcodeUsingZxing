package com.example.newbarcode;


import android.app.Dialog;
import android.os.Bundle;



import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.example.newbarcode.Model.ScanBarcodeResponse;
import com.example.newbarcode.Services.ApiInterface;
import com.example.newbarcode.Services.ApiService;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String getData;




    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
            getData = getArguments().getString("ee");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView photo = view.findViewById(R.id.img_aset);
        TextView barcode = view.findViewById(R.id.tv_barcode);
        TextView newInventory = view.findViewById(R.id.tv_new_inventory);
        TextView deskripsi = view.findViewById(R.id.tv_deskripsi);
        TextView assetDeskripsi = view.findViewById(R.id.tv_asset_deskripsi);
        TextView stokOfName = view.findViewById(R.id.tv_stokopname);

        TextView lokasiStorage = view.findViewById(R.id.tv_storage_location);
        TextView copyStorage = view.findViewById(R.id.tv_copy_storage);
        TextView sucofindo = view.findViewById(R.id.tv_sucofindo);
        TextView noAsset = view.findViewById(R.id.tv_no_asset);
        TextView remarks = view.findViewById(R.id.tv_remarks);
        TextView kondisi = view.findViewById(R.id.tv_kondisi);

        TextView updateBy = view.findViewById(R.id.tv_update_by);
        TextView updateDate = view.findViewById(R.id.tv_update_date);
        TextView status = view.findViewById(R.id.tv_status);




        ApiInterface service = ApiService.getBarcode().create(ApiInterface.class);
        Call<ScanBarcodeResponse> scanqr = service.getScanBarcode(getData);
        scanqr.enqueue(new Callback<ScanBarcodeResponse>() {
            @Override
            public void onResponse(Call<ScanBarcodeResponse> call, Response<ScanBarcodeResponse> response) {
                if(response.isSuccessful()){
                   barcode.setText(response.body().getData().getBARCODE());
                   Picasso.get()
                           .load("https://rocat.scu.co.id/go/dg/204/gen_sto/"+response.body().getData().getDIGITAL())
                           .error(R.drawable.eror)
                           .fit().centerCrop()
                           .into(photo);
                   Log.d("tag","tes "+response.body().getData().getDIGITAL());
                   newInventory.setText(response.body().getData().getNEWINVENTORYNO());
                   deskripsi.setText(response.body().getData().getDESCRIPTION());
                   assetDeskripsi.setText(response.body().getData().getASSETDESCRIPTIONSKK());
                   stokOfName.setText(response.body().getData().getSTOCKOFNAME());
                   lokasiStorage.setText(response.body().getData().getSTORAGELOCATION2());
                   copyStorage.setText(response.body().getData().getCOPYSTORAGELOCATION2());
                   sucofindo.setText(response.body().getData().getSUCOFINDOBARCODE());
                   noAsset.setText(response.body().getData().getNOASSET());
                   remarks.setText(response.body().getData().getREMARKS());
                   kondisi.setText(response.body().getData().getREMARKS());

                   updateBy.setText(response.body().getData().getUPDATEBY());
                   updateDate.setText(response.body().getData().getUPDATEDATE());
                   status.setText(response.body().getData().getSTATUS());



                } else{
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ScanBarcodeResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }




}