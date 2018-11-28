package cl.bgautier.claptrack.Utilities;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class SpotDiffCallback extends DiffUtil.Callback {

    private final List<Spot> oldList;
    private final List<Spot> newList;

    public SpotDiffCallback(List<Spot> oldList, List<Spot> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldPosition, int newPosition) {
        return oldList.get(oldPosition).id == newList.get(newPosition).id;
    }

    @Override
    public boolean areContentsTheSame(int oldPosition, int newPosition) {
        Spot oldSpot = oldList.get(oldPosition);
        Spot newSpot = newList.get(newPosition);
        return oldSpot.url.equals(newSpot.url);
    }

}