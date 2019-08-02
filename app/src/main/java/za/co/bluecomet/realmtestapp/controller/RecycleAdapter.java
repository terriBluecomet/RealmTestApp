package za.co.bluecomet.realmtestapp.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmResults;
import za.co.bluecomet.realmtestapp.R;
import za.co.bluecomet.realmtestapp.model.Student;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    public RealmResults<Student> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public MyViewHolder(TextView itemView) {
            super(itemView);
            mTextView = itemView;
        }
    }
    public RecycleAdapter(RealmResults<Student> myDataset){
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_list, viewGroup, false);
        MyViewHolder vh =  new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView.setText((CharSequence) mDataset.get(i));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
