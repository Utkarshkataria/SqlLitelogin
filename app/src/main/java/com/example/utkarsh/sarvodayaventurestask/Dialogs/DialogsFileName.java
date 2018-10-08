package com.example.utkarsh.sarvodayaventurestask.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utkarsh.sarvodayaventurestask.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DialogsFileName extends AppCompatDialogFragment {

    ArrayList<String> arrayList_phone;
    EditText ed_filename;

 //   private DialogFeedbacklistener dialogfeedbacklistener;


    public DialogsFileName()
    {

    }
    @SuppressLint("ValidFragment")
    public DialogsFileName(ArrayList<String> arrayList_phone)
    {
        this.arrayList_phone = arrayList_phone;
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.namedialog,null);
        ed_filename = view.findViewById(R.id.editText);



        builder.setView(view)
                .setTitle("Save Details")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String filename =  ed_filename.getText().toString();

                  if(filename.equals(""))
                  {
                      ed_filename.setError("Empty Field");
                      return;
                  }

                try {
                    FileOutputStream fileOutputStream = getActivity().openFileOutput(filename,Context.MODE_PRIVATE);

                    for (int i=0;i<arrayList_phone.size();i++) {
                        String message = arrayList_phone.get(i);
                        fileOutputStream.write(message.getBytes());
                        fileOutputStream.close();

                    }} catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                //  dialogfeedbacklistener.applyText(filename);
            }
        });

        return builder.create();
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            dialogfeedbacklistener = (DialogFeedbacklistener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement leaveDialogListener");
        }
    }

    public interface DialogFeedbacklistener
    {
        void applyText(String filename);
    }*/
}
