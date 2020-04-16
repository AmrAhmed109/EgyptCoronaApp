package com.example.egyptcorona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>  {
    Context context;
    List<Api2> userListResponses;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");



    public UsersAdapter(Context context, List<Api2> userListResponses) {
        this.context = context;
        this.userListResponses = userListResponses;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_list_item,null);
        UsersViewHolder usersViewHolder =new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {

        if (userListResponses.get(position).getCountry().equals("")){
            userListResponses.remove(position);
            userListResponses.add(227,userListResponses.get(0));
        }

        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        holder.country_name.setText(userListResponses.get(position).getCountry());
        holder.totalcase.setText(decimalFormat.format(userListResponses.get(position).getTotalCases()));
        holder.totalcase_new.setText("+"+decimalFormat.format(userListResponses.get(position).getNewCases()));
        holder.death.setText(decimalFormat.format(userListResponses.get(position).getTotalDeaths()));
        holder.death_new.setText("+"+decimalFormat.format(userListResponses.get(position).getNewDeaths()));
        holder.recovery.setText(decimalFormat.format(userListResponses.get(position).getTotalRecovered()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Active cases in " +userListResponses.get(position).getCountry()+" is "+
                        decimalFormat.format(userListResponses.get(position).getActiveCases()), Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return userListResponses.size();
    }

    public void fiterlist (ArrayList<Api2> filteredlist){
        userListResponses = filteredlist;
        notifyDataSetChanged();

    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView  country_name ,totalcase, totalcase_new,
                death,death_new,
                recovery;
        public UsersViewHolder(View itemView) {
            super(itemView);
            country_name = itemView.findViewById(R.id.country_name);
            totalcase = itemView.findViewById(R.id.Total_Caseslist);
            totalcase_new = itemView.findViewById(R.id.New_Caseslist);
            death = itemView.findViewById(R.id.Death_Caseslist);
            death_new = itemView.findViewById(R.id.new_Deathlist);
            recovery = itemView.findViewById(R.id.total_recoverdlist);
        }
    }

}
