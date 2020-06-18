package com.example.egyptcorona;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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

        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        holder.country_name.setText(userListResponses.get(position).getCountry());
        holder.totalcase.setText(decimalFormat.format(userListResponses.get(position).getCases()));
        holder.totalcase_new.setText("+"+decimalFormat.format(userListResponses.get(position).getTodayCases()));
        holder.death.setText(decimalFormat.format(userListResponses.get(position).getDeaths()));
        holder.death_new.setText("+"+decimalFormat.format(userListResponses.get(position).getTodayDeaths()));
        holder.recovery.setText(decimalFormat.format(userListResponses.get(position).getRecovered()));
        Glide.with(context).asBitmap().load(userListResponses.get(position).getCountryInfo().getFlag()).into(holder.circleImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //        Intent intent = new Intent(this,Main4Activity.class);
//        intent.putExtra("name",userListResponses.get(position).getCountry());
//        startActivity(intent);
                Intent intent = new Intent(context,Main6Activity.class);
                intent.putExtra("name",userListResponses.get(position).getCountry());
                intent.putExtra("totalcase",decimalFormat.format(userListResponses.get(position).getCases()));
                intent.putExtra("totalcase_new","+"+decimalFormat.format(userListResponses.get(position).getTodayCases()));
                intent.putExtra("death",decimalFormat.format(userListResponses.get(position).getDeaths()));
                intent.putExtra("death_new","+"+decimalFormat.format(userListResponses.get(position).getTodayDeaths()));
                intent.putExtra("recovery",decimalFormat.format(userListResponses.get(position).getRecovered()));
                intent.putExtra("active",decimalFormat.format(userListResponses.get(position).getActive()));
                intent.putExtra("CasesPerOneMillion",decimalFormat.format(userListResponses.get(position).getCasesPerOneMillion()));
                intent.putExtra("DeathsPerOneMillion",decimalFormat.format(userListResponses.get(position).getDeathsPerOneMillion()));
                intent.putExtra("image",userListResponses.get(position).getCountryInfo().getFlag());
                context.startActivity(intent);
               // Toast.makeText(context,"Active cases in " +userListResponses.get(position).getCountry()+" is "+
               //    decimalFormat.format(userListResponses.get(position).getActive()), Toast.LENGTH_SHORT).show();
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
        CircleImageView circleImageView ;
        public UsersViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.image109);
            country_name = itemView.findViewById(R.id.country_name);
            totalcase = itemView.findViewById(R.id.Total_Caseslist);
            totalcase_new = itemView.findViewById(R.id.New_Caseslist);
            death = itemView.findViewById(R.id.Death_Caseslist);
            death_new = itemView.findViewById(R.id.new_Deathlist);
            recovery = itemView.findViewById(R.id.total_recoverdlist);
        }
    }

}
