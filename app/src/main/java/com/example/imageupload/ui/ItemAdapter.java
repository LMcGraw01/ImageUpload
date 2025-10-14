package com.example.imageupload.ui;


import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.imageupload.ui.Item;
import com.example.imageupload.R;

// adapter acts like a bridge between data and the UI
// in terms of using recycler view, it holds data (checklist of items), creates and binds the biew, tells the RV how many items exist, updates the UI when data changes
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> checklist;

    public ItemAdapter(List<Item> checklist)
    {
        this.checklist = checklist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Item item = checklist.get(position);
        holder.textView.setText(item.getText());
        holder.checkBox.setChecked(item.isChecked());

        // listener
        holder.checkBox.setOnCheckedChangeListener(null);

        // sync checkbox state
        holder.checkBox.setChecked(item.isChecked());

        // listen for checkbox changes
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
        });

        // make entire item clickable
        holder.textView.setOnClickListener(v -> {
            // Toggle the checkbox
            boolean newState = !item.isChecked();
            item.setChecked(newState);
            holder.checkBox.setChecked(newState);
        });
    }

    @Override
    public int getItemCount()
    {
        return checklist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        CheckBox checkBox;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById((R.id.checkBox));
            textView = itemView.findViewById(R.id.item_text);
        }
    }
}