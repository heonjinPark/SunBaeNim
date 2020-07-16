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
public class FlourBasedFoodFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        ArrayList<RestaurantData> list = new ArrayList<>();
        list.add(new RestaurantData(R.drawable.flour_based_food,"마녀떡볶이", "주메뉴 : 떡볶이"));
        list.add(new RestaurantData(R.drawable.flour_based_food,"청년다방", "주메뉴 : 떡볶이"));
        list.add(new RestaurantData(R.drawable.flour_based_food,"마초떡볶이", "주메뉴 : 떡볶이"));
        list.add(new RestaurantData(R.drawable.flour_based_food,"퐁당누들떡볶이", "주메뉴 : 떡볶이"));
        list.add(new RestaurantData(R.drawable.flour_based_food,"몬스터꼬맹이김밥", "주메뉴 : 김밥"));
        list.add(new RestaurantData(R.drawable.flour_based_food,"아리랑수제핫도그", "주메뉴 : 핫도그"));

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

                    if (data.getRestaurant().equals("마녀떡볶이")) {
                        intent.putExtra("mincharge", "최소배달요금 : 15000원");
                        intent.putExtra("delivery", "배달요금 : 명암리, 명암2리 2000원");
                        intent.putExtra("image", R.drawable.flour_based_food_item5);
                        intent.putExtra("tel", "tel:0415319273");
                    } else if (data.getRestaurant().equals("청년다방")) {
                        intent.putExtra("mincharge", "최소배달요금 : 16000원이상");
                        intent.putExtra("delivery", "배달요금 : 2000원");
                        intent.putExtra("image", R.drawable.flour_based_food_item0);
                        intent.putExtra("tel", "tel:0415440035");
                    } else if (data.getRestaurant().equals("마초떡볶이")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.flour_based_food_item1);
                        intent.putExtra("tel", "tel:0415445636");
                    } else if (data.getRestaurant().equals("퐁당누들떡볶이")) {
                        intent.putExtra("mincharge", "최소배달요금 : 13000원이상");
                        intent.putExtra("delivery", "배달요금 : 2000원");
                        intent.putExtra("image", R.drawable.flour_based_food_item2);
                        intent.putExtra("tel", "tel:0415417427");
                    } else if (data.getRestaurant().equals("몬스터꼬맹이김밥")) {
                        intent.putExtra("mincharge", "최소배달요금 : 지중해,트라 현금 결제시 3만원이상");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.flour_based_food_item3);
                        intent.putExtra("tel", "tel:0415426533");
                    } else if (data.getRestaurant().equals("아리랑수제핫도그")) {
                        intent.putExtra("mincharge", "최소배달요금 : 50000원이상");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.flour_based_food_item4);
                        intent.putExtra("tel", "tel:07088400005");
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
