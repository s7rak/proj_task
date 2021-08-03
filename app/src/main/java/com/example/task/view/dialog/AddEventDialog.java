package com.example.task.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.task.Utility.room_db.DatabaseClient;
import com.example.task.databinding.DialogAddOrRemoveEventBinding;
import com.example.task.model.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;

public class AddEventDialog extends Dialog {



    private final String gregorianDate;

    private final String hijriDate;

    private DialogAddOrRemoveEventBinding binding;

    public AddEventDialog(@NonNull Context context, String gregorianDat, String hijriDate) {
        super(context);

        this.gregorianDate = gregorianDat;
        this.hijriDate = hijriDate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DialogAddOrRemoveEventBinding.inflate(getLayoutInflater());


        Window window = getWindow();
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);

        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() -> {

            DatabaseClient.getInstance(getContext())
                    .getAppDatabase().eventDao()
                    .insert(new Event(
                            Objects.requireNonNull(binding.txtNameEvent.getText()).toString(),
                            Objects.requireNonNull(binding.txtDesc.getText()).toString(),
                            gregorianDate,
                            hijriDate,
                            new SimpleDateFormat("dd/MM/yyyy", new Locale("en")).format(new Date())
                    ));


            dismiss();


        }));

    }
}
