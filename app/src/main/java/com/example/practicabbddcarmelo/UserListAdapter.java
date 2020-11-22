package com.example.practicabbddcarmelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicabbddcarmelo.db.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> implements View.OnClickListener {

    private Context context;
    private List<User> userList;
    private View.OnClickListener listener;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        holder.tvFirstName.setText(this.userList.get(position).firstName);
        holder.tvLastName.setText(this.userList.get(position).lastName);
        String id =Integer.toString (this.userList.get(position).uid);
        holder.tvId.setText(id);
        holder.tvPhoneNumber.setText(this.userList.get(position).phoneNumber);
        holder.tvBirthDate.setText(this.userList.get(position).birthDate);
        holder.tvLocation.setText(this.userList.get(position).location);
        holder.tvStreet.setText(this.userList.get(position).street);
        holder.tvNumber.setText(this.userList.get(position).number);
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;
        TextView tvId;
        TextView tvPhoneNumber;
        TextView tvBirthDate;
        TextView tvLocation;
        TextView tvStreet;
        TextView tvNumber;

        public MyViewHolder(View view) {
            super(view);
            tvFirstName = view.findViewById(R.id.tvFirstName);
            tvLastName = view.findViewById(R.id.tvLastName);
            tvPhoneNumber = view.findViewById(R.id.tvPhoneNumber);
            tvBirthDate = view.findViewById(R.id.tvBirthDate);
            tvLocation = view.findViewById(R.id.tvLocation);
            tvStreet = view.findViewById(R.id.tvStreet);
            tvNumber = view.findViewById(R.id.tvNumber);
            tvId = view.findViewById(R.id.tvId);


        }
    }
}

