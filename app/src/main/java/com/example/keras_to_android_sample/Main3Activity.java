package com.example.keras_to_android_sample;

import static android.view.View.OnClickListener;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    Button buttonMap;
    Button buttonRecipe;
    Button buttonMore;


    String urlRecipe, urlRecommd;
    TextView t01,t02,txt1;
    Thread th;
    String location;
    String foodName;
    String te01,te02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonMap = (Button) findViewById(R.id.button1);
        buttonRecipe = (Button) findViewById(R.id.button2);
        buttonMore = (Button) findViewById(R.id.button3);

        //傳送資料到Activity3
        Bundle bundle = getIntent().getExtras();
        location = bundle.getString("message");

        //location = "yolk_pastry";
        //txt1.setText(location);
        th = new Thread(catch_data);  //執行緒
        th.start();

        buttonMap.setOnClickListener(new OnClickListener() {
            //跳轉食譜
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(foodName));
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        buttonRecipe.setOnClickListener(new OnClickListener() {
            //跳轉食譜
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("message", urlRecipe);
                intent.putExtras(bundle);
                intent.setClass(Main3Activity.this, Main4Activity.class);
                //跳轉到Main3Activity
                startActivity(intent);
            }
        });

        buttonMore.setOnClickListener(new OnClickListener() {
            //跳轉食譜
            @Override
            public void onClick(View view) {
                Uri moretUri = Uri.parse("instagram://tag?name=" + Uri.encode(foodName));
                Intent moretIntent = new Intent(android.content.Intent.ACTION_VIEW, moretUri);
                moretIntent.setPackage("com.instagram.android");
                try {
                    startActivity(moretIntent);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/explore/tags/" + Uri.encode(foodName))));
                }
            }
        });

    }
    private Runnable catch_data = new Runnable(){
        public void run(){
            try {

                switch (location)
                {
                    case "apple_pie" :
                        foodName = "蘋果派";
                        //recipe
                        urlRecipe = "https://a9556330.pixnet.net/blog/post/120768336-apple-pie";
                        urlRecommd = "https://ifoodie.tw/explore/list/%E8%98%8B%E6%9E%9C%E6%B4%BE?sortby=popular";
                        break;

                    case "baby_back_ribs" :
                        foodName = "美式烤肋排";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/320467";
                        urlRecommd = "https://ifoodie.tw/explore/list/%E7%83%A4%E8%82%8B%E6%8E%92?sortby=popular";
                        break;

                    case "bawan" :
                        foodName = "肉圓";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/193513";
                        break;

                    case "beef_carpaccio" :
                        foodName = "生牛肉片";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/350625";
                        break;

                    case "beef_noodles" :
                        foodName = "牛肉麵";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/390153";
                        break;
                    case "beef_soup" :
                        foodName = "牛肉湯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/180327";
                        break;
                    case "beef_tartare" :
                        foodName = "韃靼牛肉";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/207010";
                        break;

                    case "bibimbap" :
                        foodName = "拌飯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/328341";
                        break;

                    case "bitter_melon_with_salted_eggs" :
                        foodName = "苦瓜炒鹹蛋";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/316807";
                        break;

                    case "braised_napa_cabbage" :
                        foodName = "白菜滷";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/324354";
                        break;

                    case "braised_pork_over_rice" :
                        foodName = "滷肉飯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/327109";
                        break;
                    case "bread_pudding" :
                        foodName = "脆脆海綿麵包布甸";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/134193";
                        break;
                    case "brown_sugar_cake" :
                        foodName = "黑糖糕";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/326104";
                        break;
                    case "bubble_tea" :
                        foodName = "珍珠奶茶";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/376507";
                        break;
                    case "caesar_salad" :
                        foodName = "凱撒沙拉";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/310170";
                        break;
                    case "caozaiguo" :
                        foodName = "草仔粿";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/289468";
                        break;
                    case "cheese_plate" :
                        foodName = "起司拼盤";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/90110";
                        break;
                    case "cheesecake" :
                        foodName = "起司蛋糕";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/308405";
                        break;
                    case "chicken_curry" :
                        foodName = "咖哩雞";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/327955";
                        break;
                    case "chicken_mushroom_soup" :
                        foodName = "香菇雞湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/322838";
                        break;
                    case "chicken_wings" :
                        foodName = "雞翅";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/314912";
                        break;
                    case "chinese_pickled_cucumber" :
                        foodName = "涼拌小黃瓜";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/330352";
                        break;
                    case " chocolate_cake" :
                        foodName = "巧克力蛋糕";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/337596";
                        break;
                    case "chocolate_mousse":
                        foodName = "巧克力慕斯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/334435";
                        break;
                    case "churros" :
                        foodName = "油條";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/335611";
                        break;
                    case "clam_chowder" :
                        foodName = "蛤蜊濃湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/126388";
                        break;
                    case "club_sandwich" :
                        foodName = "總匯三明治";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/132432";
                        break;
                    case "coffin_toast" :
                        foodName = "棺材板";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/337518";
                        break;
                    case "cold_noodles" :
                        foodName = "涼麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/334586";
                        break;
                    case "crab_cakes" :
                        foodName ="蟹肉餅";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/158530";
                        break;
                    case "crab_migao" :
                        foodName ="紅蟳米糕";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/250827";
                        break;
                    case "creme_brulee" :
                        foodName ="焦糖布丁";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/323169";
                        break;
                    case "cup_cakes" :
                        foodName ="杯子蛋糕";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/340916";
                        break;
                    case "deep_fried_pork_rib_and_radish_soup" :
                        foodName ="冬瓜排骨酥湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/313058";
                        break;
                    case "deep-fried_chicken_cutlets" :
                        foodName ="炸雞排";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/287346";
                        break;
                    case "deviled_eggs" :
                        foodName ="惡魔蛋";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/193535";
                        break;
                    case "donuts" :
                        foodName ="甜甜圈";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/342301";
                        break;
                    case "dumplings" :
                        foodName ="水餃";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/336970";
                        break;
                    case "edamame" :
                        foodName ="毛豆";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/338740";
                        break;
                    case "egg_pancake_roll" :
                        foodName ="蛋餅";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/340543";
                        break;
                    case "eggs_benedict" :
                        foodName ="班尼迪克蛋";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/315316";
                        break;
                    case "eight_treasure_shaved_ice" :
                        foodName ="八寶冰";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/110496";
                        break;
                    case "escargots" :
                        foodName ="法式烤田螺";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/89985";
                        break;
                    case "falafel" :
                        foodName ="炸鷹嘴豆餅";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/329926";
                        break;

                    case "filet_mignon" :
                        foodName ="法式菲力牛排佐貝爾內醬";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/54669";
                        break;
                    case "fish_and_chips" :
                        foodName ="炸魚薯條";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/340430";
                        break;
                    case "fish_head_casserole" :
                        foodName ="砂鍋魚頭";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/341011";
                        break;
                    case "foie_gras" :
                        foodName ="慢煮鴨胸伴鵝肝";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/323059";
                        break;
                    case "french_fries" :
                        foodName ="薯條";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/329069";
                        break;
                    case "french_onion_soup" :
                        foodName ="法式洋蔥湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/334414";
                        break;
                    case "french_toast" :
                        foodName ="法式吐司";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/335228";
                        break;
                    case "fried_calamari" :
                        foodName ="鹹酥炸魷魚";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/290466";
                        break;
                    case "fried_eel_noodles" :
                        foodName  ="鱔魚意麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/247000";
                        break;
                    case "fried_instant_noodles" :
                        foodName  ="炒泡麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/341342";
                        break;
                    case "fried_rice" :
                        foodName  ="火腿蛋炒飯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/341216";
                        break;
                    case "fried_rice_noodles" :
                        foodName  ="肉絲炒米粉";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/342066";
                        break;
                    case "fried-spanish_mackerel_thick_soup" :
                        foodName  ="鹹酥土魠魚羹";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/333196";
                        break;
                    case "garlic_bread" :
                        foodName  ="大蒜麵包";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/278100";
                        break;
                    case "ginger_duck_stew" :
                        foodName  ="薑母鴨";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/286063";
                        break;
                    case "gnocchi" :
                        foodName  ="義式橄欖Gnocchi馬鈴薯麵疙瘩佐乳酪";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/209368";
                        break;
                    case "grilled_cheese_sandwich" :
                        foodName  ="美式爆漿烤起司三明治";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/147988";
                        break;
                    case "grilled_corn" :
                        foodName  ="氣炸沙茶烤玉米";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/319792";
                        break;
                    case "grilled_salmon" :
                        foodName  ="香蒜奶油烤鮭魚排";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/341594";
                        break;
                    case "grilled_taiwanese_sausage" :
                        foodName  ="烤香腸";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/331446";
                        break;
                    case "gyoza" :
                        foodName  ="手工高麗菜豬肉水餃";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/263103";
                        break;
                    case "hakka_stir-fried" :
                        foodName  ="客家小炒";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/329366";
                        break;
                    case "hamburger" :
                        foodName  ="漢堡";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/335270";
                        break;
                    case "hot_and_sour_soup" :
                        foodName  ="酸辣湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/335195";
                        break;
                    case "hot_dog" :
                        foodName  ="熱狗";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/125185";
                        break;
                    case "hot_sour_soup" :
                        foodName  ="酸辣湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/337149";
                        break;
                    case "hummus" :
                        foodName  ="鷹嘴豆泥";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/322601";
                        break;
                    case "hung_rui_chen_sandwich" :
                        foodName ="洪瑞珍三明治";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/331262";
                        break;
                    case "ice_cream" :
                        foodName ="冰淇淋";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/342054";
                        break;
                    case "intestine_and_oyster_vermicelli" :
                        foodName ="大腸蚵仔麵線";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/338356";
                        break;
                    case "iron_egg" :
                        foodName ="香滷鐵蛋";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/319561";
                        break;
                    case "jelly_of_gravey_and_chicken_feet_skin" :
                        foodName ="古早味雞腳凍";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/278302";
                        break;
                    case "jerky" :
                        foodName ="豬肉乾";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/330693";
                        break;
                    case "kung-pao_chicken" :
                        foodName ="宮保雞丁";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/335839";
                        break;
                    case "lasagna" :
                        foodName ="肉醬千層麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/338393";
                        break;
                    case "lobster_bisque" :
                        foodName ="法式龍蝦濃湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/232052";
                        break;
                    case "lobster_roll_sandwich" :
                        foodName ="龍蝦三明治";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/247765";
                        break;
                    case "luwei" :
                        foodName ="綜合滷味";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/327886";
                        break;
                    case "macaroni_and_cheese" :
                        foodName ="起司通心麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/325650";
                        break;
                    case "macarons" :
                        foodName ="起司通心麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/340831";
                        break;
                    case "mango_shaved_ice" :
                        foodName ="芒果牛奶雪花冰";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/342489";
                        break;
                    case "meat_dumpling_in_chili_oil" :
                        foodName ="紅油抄手";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/341824";
                        break;
                    case "milkfish_belly_congee" :
                        foodName ="虱目魚肚粥";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/257370";
                        break;
                    case "miso_soup" :
                        foodName ="味噌豆腐湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/341971";
                        break;
                    case "mochi" :
                        foodName ="麻糬";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/335764";
                        break;
                    case "mung_bean_smoothie_milk" :
                        foodName ="綠豆沙牛奶";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/170562";
                        break;
                    case "mussels" :
                        foodName ="淡菜";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/307044";
                        break;
                    case "mutton_fried_noodles" :
                        foodName ="羊肉炒麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/307044";
                        break;
                    case "mutton_hot_pot" :
                        foodName ="羊肉爐";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/286628";
                        break;
                    case "nabeyaki_egg_noodles" :
                        foodName ="鍋燒意麵";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/315742";
                        break;
                    case "night_market_steak" :
                        foodName ="夜市鐵板牛排";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/116495";
                        break;
                    case "nougat" :
                        foodName ="牛軋糖";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/340267";
                        break;
                    case "omelette" :
                        foodName ="歐姆蛋";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/309477";
                        break;
                    case "onion_rings" :
                        foodName ="洋蔥圈";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/338993";
                        break;
                    case "oyster_fritter" :
                        foodName ="蚵嗲";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/340950";
                        break;
                    case "oyster_omelet" :
                        foodName ="蚵仔煎";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/340570";
                        break;


                    case "oysters" :
                        foodName ="烤生蠔";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/56649";
                        break;

                    case "pad_thai" :
                        foodName ="泰式炒河粉";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/329236";
                        break;

                    case "paella" :
                        foodName ="燉飯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/338388";
                        break;
                    case "pancakes" :
                        foodName ="鬆餅";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/336788";
                        break;
                    case "panna_cotta" :
                        foodName ="奶酪";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/332551";
                        break;
                    case "papaya_milk" :
                        foodName ="木瓜牛奶";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/331460";
                        break;
                    case "peanut_brittle" :
                        foodName ="花生糖";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/320194";
                        break;
                    case "peking_duck" :
                        foodName ="北京烤鴨";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/182351";
                        break;
                    case "pepper_pork_bun" :
                        foodName ="胡椒餅";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/336012";
                        break;
                    case "pho" :
                        foodName ="越式牛肉河粉湯";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/337367";
                        break;
                    case "pig's_blood_soup" :
                        foodName ="越式牛肉河粉湯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/309536";
                        break;
                    case "pineapple_cake" :
                        foodName ="鳳梨酥";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/341099";
                        break;
                    case "pizza" :
                        foodName ="披薩";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/337877";
                        break;
                    case "pork_chop" :
                        foodName ="豬排";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/337115";
                        break;
                    case "pork_intestines_fire_pot" :
                        foodName ="五更腸旺";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/339383";
                        break;
                    case "potsticker" :
                        foodName ="冰花煎餃";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/337580";
                        break;
                    case "poutine" :
                        foodName ="肉汁乾酪薯條";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/121053";
                        break;
                    case "preserved_egg_tofu" :
                        foodName ="皮蛋豆腐";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/342011";
                        break;
                    case "prime_rib" :
                        foodName ="牛肋排";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/315975";
                        break;
                    case "ramen" :
                        foodName ="豚骨拉麵";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/287747";
                        break;
                    case "ravioli" :
                        foodName ="義大利餃";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/262179";
                        break;
                    case "rice_dumpling" :
                        foodName ="粽子";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/341551";
                        break;
                    case "rice_noodles_with_squid" :
                        foodName ="小卷米粉";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/289358";
                        break;
                    case "rice_with_soy-stewed_pork" :
                        foodName ="控肉飯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/321090";
                        break;
                    case "risotto" :
                        foodName ="義大利燉飯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/269895";
                        break;
                    case "roasted_sweet_potato" :
                        foodName ="烤地瓜";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/333809";
                        break;
                    case "sailfish_stick" :
                        foodName ="旗魚黑輪";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/39534";
                        break;
                    case "salty_fried_chicken_nuggets" :
                        foodName ="鹹酥雞";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/334387";
                        break;
                    case "sanxia_golden_croissants" :
                        foodName ="金牛角";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/311844";
                        break;
                    case "sashimi" :
                        foodName ="生魚片";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/156384";
                        break;
                    case "saute_spring_onion_with_beef" :
                        foodName ="蔥爆牛肉";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/334450";
                        break;
                    case "scallion_pancake" :
                        foodName ="蔥油餅";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/339838";
                        break;
                    case "scallops" :
                        foodName ="干貝";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/334852";
                        break;
                    case "scrambled_eggs_with_shrimp" :
                        foodName ="滑蛋蝦仁";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/330537";
                        break;
                    case "scrambled_eggs_with_tomatoes" :
                        foodName ="西紅柿炒蛋";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/342562";
                        break;
                    case "seafood_congee" :
                        foodName ="海鮮粥";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/342780";
                        break;
                    case "seaweed_salad" :
                        foodName ="涼拌海藻";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/332609";
                        break;
                    case "sesame_oil_chicken_soup" :
                        foodName ="麻油雞湯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/337218";
                        break;
                    case "shrimp_rice" :
                        foodName ="蝦仁飯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/341811";
                        break;
                    case "sishen_soup" :
                        foodName ="四神湯";
                        //recipe
                        urlRecipe = "https://ichttps://icook.tw/recipes/339476";
                        break;
                    case "sliced_pork_bun" :
                        foodName ="刈包";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/332090";
                        break;
                    case "spaghetti_bolognese" :
                        foodName ="茄汁肉醬義大利";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/341503";
                        break;
                    case "spaghetti_carbonara" :
                        foodName ="培根蛋黃義大利麵";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/335836";
                        break;
                    case "spicy_duck_blood" :
                        foodName ="麻辣鴨血";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/339555";
                        break;
                    case "spring_rolls" :
                        foodName ="炸春捲";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/317013";
                        break;
                    case "steak" :
                        foodName ="牛排";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/340409";
                        break;
                    case "steamed_cod_fish_with_crispy_bean" :
                        foodName ="豆酥鱈魚";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/321165";
                        break;
                    case "steamed_taro_cake" :
                        foodName ="芋粿巧";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/339112";
                        break;
                    case "steam-fried_bun" :
                        foodName ="水煎包";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/340554";
                        break;
                    case "stewed_pig's_knuckles" :
                        foodName ="滷豬腳";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/336547";
                        break;
                    case "stinky_tofu" :
                        foodName ="臭豆腐";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/255950";
                        break;
                    case "stir_fried_clams_with_basil" :
                        foodName ="熱炒海瓜子";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/340932";
                        break;
                    case "stir-fried_duck_meat_broth" :
                        foodName ="生炒鴨肉羹";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/281172";
                        break;
                    case "stir-fried_calamari_broth" :
                        foodName ="生炒花枝羹";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/252981";
                        break;

                    case "stir-fried_loofah_with_clam" :
                        foodName ="蛤蜊絲瓜";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/338358";
                        break;
                    case "stir-fried_pork_intestine_with_ginger" :
                        foodName ="薑絲炒大腸";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/341410";
                        break;
                    case "xiaolongbao" :
                        foodName ="小籠包";
                        //recipe
                        urlRecipe ="https://icook.tw/recipes/336970";
                        break;
                    case "sugar_coated_sweet_potato" :
                        foodName ="拔絲地瓜";
                        //recipe
                        urlRecipe = " https://icook.tw/recipes/294421";
                        break;
                    case "sun_cake" :
                        foodName ="太陽餅";
                        //recipe
                        urlRecipe = " https://icook.tw/recipes/313716";
                        break;
                    case "sushi" :
                        foodName ="壽司";
                        //recipe
                        urlRecipe = " https://icook.tw/recipes/161963";
                        break;
                    case "sweet_and_sour_pork_ribs" :
                        foodName ="糖醋排骨";
                        //recipe
                        urlRecipe = " https://icook.tw/recipes/342850";
                        break;
                    case "sweet_potato_ball" :
                        foodName ="地瓜球";
                        //recipe
                        urlRecipe = " https://icook.tw/recipes/335530";
                        break;
                    case "tacos" :
                        foodName ="墨西哥夾餅";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/270750";
                        break;
                    case "taiwanese_burrito" :
                        foodName ="台式潤餅捲";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/330447";
                        break;
                    case "taiwanese_pork_ball_soup" :
                        foodName ="貢丸湯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/331086";
                        break;
                    case "taiwanese_sausage_in_rice_bun" :
                        foodName ="大腸包小腸";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/299526";
                        break;
                    case "takoyaki" :
                        foodName ="章魚燒";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/340768";
                        break;
                    case "tanghulu" :
                        foodName ="糖葫蘆";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/243604";
                        break;
                    case "tangyuan" :
                        foodName ="湯圓";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/322732";
                        break;
                    case "taro_ball" :
                        foodName ="地瓜圓";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/302107";
                        break;
                    case "three-cup_chicken" :
                        foodName ="三杯雞";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/342451";
                        break;
                    case "tiramisu" :
                        foodName ="提拉米蘇";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/340021";
                        break;
                    case "tube-shaped_migao" :
                        foodName ="筒仔米糕";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/335655";
                        break;
                    case "turkey_rice" :
                        foodName ="火雞肉飯";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/177217";
                        break;
                    case "turnip_cake" :
                        foodName ="蘿蔔糕";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/341754";
                        break;
                    case "waffles" :
                        foodName ="鬆餅";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/257220";
                        break;
                    case "wheel_pie" :
                        foodName ="車輪餅";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/141869";
                        break;
                }

            }

            catch (Exception e){
            }
        }
    };

}
