package gaza.ssd.parkheonjin.sunbaenim;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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
public class EtcFoodFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seven, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        ArrayList<RestaurantData> list = new ArrayList<>();
        list.add(new RestaurantData(R.drawable.etc,"도스마스", "주메뉴 : 부리또"));
        list.add(new RestaurantData(R.drawable.etc,"농부바베큐", "주메뉴 : 바베큐(통상겹 등)"));
        list.add(new RestaurantData(R.drawable.etc,"똥집튀김", "주메뉴 : 닭똥집, 무뼈닭발)"));
        list.add(new RestaurantData(R.drawable.etc,"롯데리아", "주메뉴 : 햄버거"));
        list.add(new RestaurantData(R.drawable.etc,"베스킨라벤스", "주메뉴 : 아이스크림"));
        list.add(new RestaurantData(R.drawable.etc,"시골촌", "주메뉴 : 닭볶음탕, 찌개, 탕"));
        list.add(new RestaurantData(R.drawable.etc,"신진성아구찜해물찜", "주메뉴 : 아구찜, 해물찜"));
        list.add(new RestaurantData(R.drawable.etc,"신화불날개", "주메뉴 : 불날개, 불닭발"));
        list.add(new RestaurantData(R.drawable.etc,"안동홍초찜닭", "주메뉴 : 찜닭"));
        list.add(new RestaurantData(R.drawable.etc,"홍스쭈꾸미", "주메뉴 : 쭈꾸미, 쭈삼겹"));


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
                    if (data.getRestaurant().equals("도스마스")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.etc_item9);
                        intent.putExtra("tel", "tel:0415448098");
                    } else if (data.getRestaurant().equals("농부바베큐")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.etc_item0);
                        intent.putExtra("tel", "tel:0415429482");
                    } else if (data.getRestaurant().equals("똥집튀김")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.etc_item1);
                        intent.putExtra("tel", "tel:0415347667");
                    } else if (data.getRestaurant().equals("롯데리아")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.etc_item2);
                        intent.putExtra("tel", "tel:0415430120");
                    } else if (data.getRestaurant().equals("베스킨라벤스")) {
                        intent.putExtra("mincharge", "최소배달요금 : 13500원이상");
                        intent.putExtra("delivery", "배달요금 : 3000원");
                        intent.putExtra("image", R.drawable.etc_item3);
                        intent.putExtra("tel", "tel:0415333132");
                    } else if (data.getRestaurant().equals("시골촌")) {
                        intent.putExtra("mincharge", "최소배달요금 : 17000원이상");
                        intent.putExtra("delivery", "배달요금 : 1000원");
                        intent.putExtra("image", R.drawable.etc_item4);
                        intent.putExtra("tel", "tel:0415438987");
                    } else if (data.getRestaurant().equals("신진성아구찜해물찜")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 3000원");
                        intent.putExtra("image", R.drawable.etc_item5);
                        intent.putExtra("tel", "tel:0415450255");
                    } else if (data.getRestaurant().equals("신화불날개")) {
                        intent.putExtra("mincharge", "최소배달요금 : 14000원이상");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.etc_item6);
                        intent.putExtra("tel", "tel:0415410666");
                    } else if (data.getRestaurant().equals("안동홍초찜닭")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.etc_item7);
                        intent.putExtra("tel", "tel:0415320814");
                    } else if (data.getRestaurant().equals("홍스쭈꾸미")) {
                        intent.putExtra("mincharge", "최소배달요금 : 없음");
                        intent.putExtra("delivery", "배달요금 : 없음");
                        intent.putExtra("image", R.drawable.etc_item8);
                        intent.putExtra("tel", "tel:0415456979");
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
