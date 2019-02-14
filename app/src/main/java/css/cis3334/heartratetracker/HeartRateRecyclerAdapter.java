package css.cis3334.heartratetracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class HeartRateRecyclerAdapter  extends RecyclerView.Adapter<HeartRateRecyclerAdapter.MyViewHolder> {

    private HeartRateList hrList;       // The object holding the arraylist of hear rates
    private TextView tvPulse;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HeartRateRecyclerAdapter(HeartRateList hrList) {
        this.hrList = hrList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HeartRateRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.heart_rate_row, parent, false);
        // add code here
        tvPulse=(TextView)v.findViewById(R.id.textViewPulse);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.textView.setText(mDataset[position]);

        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        tvPulse.setText(hr.getPulse().toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return hrList.getList().size();
    }
}