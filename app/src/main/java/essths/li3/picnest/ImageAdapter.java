package essths.li3.picnest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<String> imageList;
    private OnItemClickListener listener;
    private int[] likeCounts;

    public interface OnItemClickListener { void onItemClick(int position); }

    public ImageAdapter(List<String> imageList, OnItemClickListener listener){
        this.imageList = imageList;
        this.listener = listener;
        likeCounts = new int[imageList.size()];
    }

    public void updateList(List<String> newList){
        imageList = newList;
        likeCounts = new int[newList.size()];
        notifyDataSetChanged();
    }

    public String getImage(int pos){ return imageList.get(pos); }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Context context = holder.itemView.getContext();
        int resId = context.getResources().getIdentifier(imageList.get(position),"drawable",context.getPackageName());
        if(resId != 0) holder.postImage.setImageResource(resId);

        holder.likeButton.setOnClickListener(v -> {
            likeCounts[position]++;
            holder.likeCount.setText(String.valueOf(likeCounts[position]));
        });

        holder.downloadButton.setOnClickListener(v -> {
            Toast.makeText(context,"Image downloaded (simulated)",Toast.LENGTH_SHORT).show();
        });

        holder.likeCount.setText(String.valueOf(likeCounts[position]));
    }

    @Override
    public int getItemCount(){ return imageList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView postImage;
        ImageButton likeButton, downloadButton;
        TextView likeCount;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener){
            super(itemView);
            postImage = itemView.findViewById(R.id.postImage);
            likeButton = itemView.findViewById(R.id.likeButton);
            downloadButton = itemView.findViewById(R.id.downloadButton);
            likeCount = itemView.findViewById(R.id.likeCount);

            itemView.setOnClickListener(v -> {
                if(listener!=null){
                    int pos = getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION)
                        listener.onItemClick(pos);
                }
            });
        }
    }
}
