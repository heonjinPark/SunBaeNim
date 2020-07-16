package gaza.ssd.parkheonjin.sunbaenim;


import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeatFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_six, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        ArrayList<RestaurantData> list = new ArrayList<>();
        list.add(new RestaurantData(R.drawable.meat,"족발야시장", "주메뉴 : 족발, 보쌈"));
        list.add(new RestaurantData(R.drawable.meat,"조가네달인족발보쌈", "주메뉴 : 족발, 보쌈"));
        list.add(new RestaurantData(R.drawable.meat,"등발보쌈", "주메뉴 : 족발, 보쌈"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapter(list));

        return view;
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<RestaurantData> restaurantData;

        MyAdapter(ArrayList<RestaurantData> list) {
            restaurantData = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            final RestaurantData data = restaurantData.get(i);

            myViewHolder.restaurant.setText(data.getRestaurant());
            myViewHolder.icon.setImageResource(data.getImg());
            myViewHolder.mainMenu.setText(data.getMainMenu());
            myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), MainInfoActivity.class);
                    intent.putExtra("restaurant", data.getRestaurant());
                    if (data.getRestaurant().equals("족발야시장")) {
                        intent.putExtra("mincharge", "최소배달요금 : 29000원이상");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.meat_item0);
                        intent.putExtra("tel", "tel:0415414969");
                    } else if (data.getRestaurant().equals("조가네달인족발보쌈")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.meat_item1);
                        intent.putExtra("tel", "tel:0415442588");
                    } else if (data.getRestaurant().equals("등발보쌈")) {
                        intent.putExtra("mincharge", "최소배달요금 : 29000원이상");
                        intent.putExtra("delivery", "배달요금 : 3000원");
                        intent.putExtra("image", R.drawable.meat_item2);
                        intent.putExtra("tel", "tel:0415495455");
                    }
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
                }
            });
        }

        @Override
        public int getItemCount() {
            return restaurantData.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView restaurant;
        public TextView mainMenu;
        public LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            restaurant = (TextView) itemView.findViewById(R.id.restaurant);
            mainMenu = (TextView) itemView.findViewById(R.id.main_menu);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear);
        }
    }
}
