package com.example.egyptcorona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {
    Context context;
    List<Api2> userListResponses;

    int count=0;
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
            count++;
        }


        holder.country_name.setText(userListResponses.get(position).getCountry());
        String totalcase = String.valueOf(userListResponses.get(position).getTotalCases());
        String totalcase_new = String.valueOf(userListResponses.get(position).getNewCases());
        String death = String.valueOf(userListResponses.get(position).getTotalDeaths());
        String death_new = String.valueOf(userListResponses.get(position).getNewDeaths());
        String recovery = String.valueOf(userListResponses.get(position).getTotalRecovered());



        holder.totalcase.setText(totalcase);
        holder.totalcase_new.setText("+"+totalcase_new);
        holder.death.setText(death);
        holder.death_new.setText("+"+death_new);
        holder.recovery.setText(recovery);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, userListResponses.get(position).toString(), Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return userListResponses.size() ;
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
