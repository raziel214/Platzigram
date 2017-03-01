package com.platzi.platzigram.view.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.platzi.platzigram.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewPostFragment extends Fragment {

    ImageView ivPicture;
    Button btnTakePicture;
    static final int REQUETS_IMAGE_CAPTURE=1;




    public NewPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_new_post, container, false);

        ivPicture = (ImageView)  view.findViewById(R.id.ivPicture);
        btnTakePicture=(Button)  view.findViewById(R.id.btnTakePicture);

        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        return view;




    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQUETS_IMAGE_CAPTURE && resultCode== getActivity().RESULT_OK){

            Bundle extras=data.getExtras();
            Bitmap imageBitmap=(Bitmap)extras.get("data") ;
            ivPicture.setImageBitmap(imageBitmap);

        }
    }

    private void takePicture() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takePictureIntent.resolveActivity(getActivity().getPackageManager()) !=null){

            File photoFile=null;
            try {
                photoFile=createImageFile();


            } catch (IOException e) {
                e.printStackTrace();
            }
            if(photoFile!=null){

                Uri photoURI= FileProvider.getUriForFile(getActivity(),
                        "com.platzi.platzigram",
                        photoFile);

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                startActivityForResult(takePictureIntent,REQUETS_IMAGE_CAPTURE);



            }





        }

    }


    private File createImageFile()throws IOException{

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName="JPG_"+timeStamp+"_";

        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);


        File image= File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir

        );

        return image;
    }




}
