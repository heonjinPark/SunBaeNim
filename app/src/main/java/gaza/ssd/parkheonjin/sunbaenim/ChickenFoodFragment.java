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
public class ChickenFoodFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        ArrayList<RestaurantData> list = new ArrayList<>();
        list.add(new RestaurantData(R.drawable.chicken,"깐풍기치킨호프", "주메뉴 : 깐풍기, 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"마슬랜", "주메뉴 : 치킨, 탕수육"));
        list.add(new RestaurantData(R.drawable.chicken,"BHC", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"BBQ", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"맘스터치", "주메뉴 : 치킨, 햄버거"));
        list.add(new RestaurantData(R.drawable.chicken,"굽네치킨", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"처갓집", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"페리카나", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"치르치르", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"깻잎두마리치킨", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"스피드탕수육&치킨", "주메뉴 : 탕수육"));
        list.add(new RestaurantData(R.drawable.chicken,"큰통치킨", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"우리동네닭집", "주메뉴 : 치킨"));
        list.add(new RestaurantData(R.drawable.chicken,"원주통닭", "주메뉴 : 치킨"));

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
                    if (data.getRestaurant().equals("깐풍기치킨호프")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item0);
                        intent.putExtra("tel", "tel:0415333005");
                    } else if (data.getRestaurant().equals("마슬랜")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item13);
                        intent.putExtra("tel", "tel:0415440757");
                    } else if (data.getRestaurant().equals("BHC")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item1);
                        intent.putExtra("tel", "tel:050431421973");
                    } else if (data.getRestaurant().equals("BBQ")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item2);
                        intent.putExtra("tel", "tel:0415348181");
                    } else if (data.getRestaurant().equals("맘스터치")) {
                        intent.putExtra("mincharge", "최소배달요금 : 15000원이상");
                        intent.putExtra("delivery", "배달요금 : 1000원");
                        intent.putExtra("image", R.drawable.chicken_item3);
                        intent.putExtra("tel", "tel:0415444249");
                    } else if (data.getRestaurant().equals("굽네치킨")) {
                        intent.putExtra("mincharge", "최소배달요금 : 15000원이상");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item4);
                        intent.putExtra("tel", "tel:0415429492");
                    } else if (data.getRestaurant().equals("처갓집")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item5);
                        intent.putExtra("tel", "tel:0415489997");
                    } else if (data.getRestaurant().equals("페리카나")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item6);
                        intent.putExtra("tel", "tel:0415439298");
                    } else if (data.getRestaurant().equals("치르치르")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 2000원");
                        intent.putExtra("image", R.drawable.chicken_item7);
                        intent.putExtra("tel", "tel:0415317275");
                    } else if (data.getRestaurant().equals("깻잎두마리치킨")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item8);
                        intent.putExtra("tel", "tel:0415475595");
                    } else if (data.getRestaurant().equals("스피드탕수육&치킨")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item9);
                        intent.putExtra("tel", "tel:0415435040");
                    } else if (data.getRestaurant().equals("큰통치킨")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item10);
                        intent.putExtra("tel", "tel:0415463066");
                    } else if (data.getRestaurant().equals("우리동네닭집")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.chicken_item11);
                        intent.putExtra("tel", "tel:0415412249");
                    } else if (data.getRestaurant().equals("원주통닭")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 2000원(현금결제시1000원)");
                        intent.putExtra("image", R.drawable.chicken_item12);
                        intent.putExtra("tel", "tel:0415493330");
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
