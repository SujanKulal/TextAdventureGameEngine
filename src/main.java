import com.google.gson.Gson;

class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson("Boss is ready to build!");
        System.out.println(json);
    }
}
