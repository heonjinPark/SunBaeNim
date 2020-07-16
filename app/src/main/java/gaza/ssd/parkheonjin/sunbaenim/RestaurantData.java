package gaza.ssd.parkheonjin.sunbaenim;

public class RestaurantData {
    private int img;
    private String restaurant;
    private String mainMenu;

    public RestaurantData(int img, String restaurant, String mainMenu) {
        this.img = img;
        this.restaurant = restaurant;
        this.mainMenu = mainMenu;
    }

    public int getImg() {
        return img;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getMainMenu() {
        return mainMenu;
    }
}
