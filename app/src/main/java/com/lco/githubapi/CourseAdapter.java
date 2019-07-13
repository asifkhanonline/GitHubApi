package com.lco.githubapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lco.githubapi.Model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

 public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
List<User> notelist;
private Context context;
ImageView profilepic;
TextView textView,text;
public CourseAdapter(List<User>notelist,Context context){
    this.notelist=notelist;
    this.context=context;
}
    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        final  User geterl=notelist.get(position);
        String login,image,usertpye;
        login=geterl.getLogin();
        image=geterl.getType();
        usertpye=geterl.getType();
        textView.setText(login);
        text.setText(usertpye);
        Picasso.get().load(image).into(profilepic);


    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
    TextView textView,text;
   // ImageView imageView;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.name);
            text=itemView.findViewById(R.id.textView3);
            profilepic=itemView.findViewById(R.id.image);

        }
    }
}
