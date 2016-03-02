package ele.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.elementora.amresh.ele.R;

import java.util.ArrayList;

/**
 * Created by Amresh on 3-2-2016.
 */
public class RecyclerviewAdaptor extends RecyclerView.Adapter<RecyclerviewAdaptor.ViewHolder> {

    private static ArrayList<String> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView card_view;
        public TextView mTextView;

        public ViewHolder(View itemBookMarked) {
            super(itemBookMarked);
            card_view = (CardView) itemBookMarked.findViewById(R.id.card_view);
            mTextView = (TextView) itemBookMarked.findViewById(R.id.info_text);
        }
    }

    public RecyclerviewAdaptor(ArrayList<String> myDataset) {
        mDataset = new ArrayList<>();
        mDataset = myDataset;

    }

    @Override
    public RecyclerviewAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smslist_filtered, parent, false);
        ViewHolder pvh = new ViewHolder(view);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
