package com.example.task.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.task.databinding.ViewHolderEventBinding;
import com.example.task.model.Event;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class AdapterEvents extends RecyclerView.Adapter<AdapterEvents.HolderEvent> {

    private  List<Event> list;

    private  OnEditListener onEditListener ;
    private  OnRemoveListener onRemoveListener ;

    public void setOnEditListener(OnEditListener onEditListener) {
        this.onEditListener = onEditListener;
    }

    public void setOnRemoveListener(OnRemoveListener onRemoveListener) {
        this.onRemoveListener = onRemoveListener;
    }

    public void setList(List<Event> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public HolderEvent onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        return new HolderEvent(ViewHolderEventBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HolderEvent holder, int position) {
        holder.binding.setEvent(list.get(position));

        if(onEditListener != null)
        holder.binding.btnEdit.setOnClickListener(view -> onEditListener.onEdit(list.get(position)));

        if(onRemoveListener != null)
        holder.binding.btnDelete.setOnClickListener(view -> onRemoveListener.onRemove(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class HolderEvent extends RecyclerView.ViewHolder {

        ViewHolderEventBinding binding ;

        public HolderEvent(@NonNull ViewHolderEventBinding binding) {
            super(binding.getRoot());

            this.binding = binding ;
        }
    }
}


