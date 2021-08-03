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
import com.example.task.view.fragment.OnFinishListener;
import java.util.Objects;
import java.util.concurrent.Executors;

public class DialogEditEvent  extends Dialog {

    private final OnFinishListener onFinishListener;

    private DialogAddOrRemoveEventBinding binding;

    private final Event event;

    public DialogEditEvent(@NonNull Context context , Event event , OnFinishListener onFinishListener) {
        super(context);
        this.event =event;
        this.onFinishListener = onFinishListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DialogAddOrRemoveEventBinding.inflate(getLayoutInflater());


        Window window = getWindow();
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);

        setContentView(binding.getRoot());

        binding.txtNameEvent.setText(event.getEventName());
        binding.txtDesc.setText(event.getEventDescription());

        binding.btnSave.setOnClickListener(view -> {

            event.setEventName(Objects.requireNonNull(binding.txtNameEvent.getText()).toString());
            event.setEventDescription(Objects.requireNonNull(binding.txtDesc.getText()).toString());

            Executors.newSingleThreadExecutor().execute(() -> {

                DatabaseClient.getInstance(getContext())
                        .getAppDatabase().eventDao().update(event);

                onFinishListener.onFinishUpdate();
                dismiss();


            });
        });



    }
}
