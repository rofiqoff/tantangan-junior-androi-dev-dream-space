package id.rofiqoff.tantangan.data;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import id.rofiqoff.tantangan.R;
import id.rofiqoff.tantangan.model.Destination;

public class DataGenerator {

    public static List<Destination> getDestination1(Context context) {
        List<Destination> items = new ArrayList<>();
        TypedArray imageArray = context.getResources().obtainTypedArray(R.array.destination_image_1);
        for (int i = 0; i < imageArray.length(); i++) {
            Destination data = new Destination();
            data.image = imageArray.getResourceId(i, -1);
            items.add(data);
        }
        return items;
    }

    public static List<Destination> getDestination2(Context context) {
        List<Destination> items = new ArrayList<>();
        TypedArray imageArray = context.getResources().obtainTypedArray(R.array.destination_image_2);
        for (int i = 0; i < imageArray.length(); i++) {
            Destination data = new Destination();
            data.image = imageArray.getResourceId(i, -1);
            items.add(data);
        }
        return items;
    }

}
