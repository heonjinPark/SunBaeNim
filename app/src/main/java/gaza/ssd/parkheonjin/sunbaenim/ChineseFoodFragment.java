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
public class ChineseFoodFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        ArrayList<RestaurantData> list = new ArrayList<>();
        list.add(new RestaurantData(R.drawable.chinese_food,"비단비", "주메뉴 : 짜장면, 짬뽕"));
        list.add(new RestaurantData(R.drawable.chinese_food,"하이린", "주메뉴 : 짜장면, 짬뽕"));
        list.add(new RestaurantData(R.drawable.chinese_food,"화정관", "주메뉴 : 짜장면, 짬뽕"));
        list.add(new RestaurantData(R.drawable.chinese_food,"환영각", "주메뉴 : 짜장면, 짬뽕"));

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
                    if (data.getRestaurant().equals("비단비")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chinese_food_item0);
                        intent.putExtra("tel", "tel:0415347550");
                    } else if (data.getRestaurant().equals("하이린")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chinese_food_item1);
                        intent.putExtra("tel", "tel:0415458818");
                    } else if (data.getRestaurant().equals("화정관")) {
                        intent.putExtra("mincharge", "최소배달요금 : 10000원이상");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chinese_food_item2);
                        intent.putExtra("tel", "tel:0415412266");
                    } else if (data.getRestaurant().equals("환영각")) {
                        intent.putExtra("mincharge", "최소배달요금 : 10000원이상");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chinese_food_item3);
                        intent.putExtra("tel", "tel:0415317765");
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
