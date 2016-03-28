package com.example.caijie.CustomerFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.example.caijie.studyandriod.R;

/**
 * Created by caijie on 16/3/28.
 */
public class DatePickkerFragmnet extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity()).setTitle(R.string.date_picker_title).setPositiveButton(R.string.dialog_ok,null).create();
    }

    
}
