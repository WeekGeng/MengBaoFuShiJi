package com.example.administrator.mengbaofushiji.pagerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.SchoolToolsAdapter;
import com.example.administrator.mengbaofushiji.fragment.SchoolFragment;
import com.example.administrator.mengbaofushiji.view.ToolsDetailActivity;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import github.chenupt.dragtoplayout.AttachUtil;

/**
 * Created by Administrator on 2015/4/8.
 */
public class PagerSchoolToolsFragment extends Fragment {
    ChildItem childItem;
    Map<String,Object> map;
    List<Map<String,Object>> lists;
    private ListView school_tools_lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDatas();
    }

//    private void getData() {
//        list=new ArrayList<>();
//        groupItem1.title="全自动辅食工具";
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_a));
//        map.put("title","Beaba电动辅食机";
//        map.put("description","Beaba电动辅食机是这次生了二宝以后买的，果然是众多妈妈推荐的神物，蒸和搅拌一次完成，非常方便，而且打出来的泥状食物非常细腻，夏天天气炎热，可以给宝宝做些开胃的水果泥和蔬菜泥。我觉得如果条件允许，电动辅食机还是很有必要的，辅食做起来省时省力，这样妈妈们才会有更多精力去研究辅食的多样化。虽然使用的时间可能只是6个月到1岁多，但是这个阶段也是宝宝成长的关键阶段，各种营养的摄入很重要。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem1.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_b));
//        map.put("title","飞利浦新安怡 食品蒸制搅拌一体机";
//        map.put("description","飞利浦新安怡的这款辅食机也是相当好用的一款，相比Beaba来说价格更适中，使用起来也非常省心，先蒸煮，再翻转即可打泥，不用再几个容器倒腾来倒腾去，弄的哪里都是，或者手忙脚乱，从食材放入都收获泥糊一气呵成，最后倒出来就能直接喂给宝宝吃，是给宝宝添加健康辅食不可或缺的得力助手。";
//        map.put("seecount",1000;
//        map.put("collectionCount",354;
//        map.put("buyCount",100;
//        groupItem1.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_c));
//        map.put("title","Vitamix搅拌机";
//        map.put("description","Vitamix搅拌机真的各种长草，搅打功能强，据说石头都能打碎，更别提宝宝辅食了！功率大，细胞破壁率高，营养全面均衡。制作出来的全谷类制品、水果汁、蔬菜汁、芝麻糊等十分细腻，宝宝容易消化。就是海淘的话就没有7年的保修了，而买国行的话，价格又贵的离谱。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem1.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_d));
//        map.put("title","Easiyo易极优酸奶机";
//        map.put("description","因为喜欢易极优的酸奶粉，所以推荐这款同品牌的酸奶机。它是全球最大的DIY酸奶品牌，有了这款工具轻轻松松就可以让在家吃到新鲜美味的酸奶，操作简单，配合易极优酸乳粉，内罐放入水和酸乳粉摇匀、外罐倒入开水、盖盖等着，三步就能完成酸奶DIY，完全适合懒人。宝宝6个月就可以加酸奶了，易极优的酸奶粉原味的就可以做给宝宝喝。顺便说之前我用的是小熊的可以分杯的酸奶机，我觉得也挺好的，分杯功能特别适合给宝宝用，一次一杯,很方便！";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem1.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_e));
//        map.put("title","九阳全自动面条机";
//        map.put("description","面条是很棒的辅食，出去买担心会放什么添加剂，自己做又费劲，这款全自动面条机能自动和面，18分钟全自动成面，操作简单。可以制作鸡蛋面、胡萝卜面、菠菜面...想要什么面都能实现。另外还有很多高大上的厨师机，比如KitchenAid，如果你特别喜欢下厨，不妨买一台，什么和面啦，绞肉啦，打蛋啦，做面条，做冰淇淋感觉无所不能。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem1.item.add(childItem);
//        list.add(groupItem1);
//
//        groupItem2.title="手动辅食工具";
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_f));
//        map.put("title","NUK freshfood研磨碗";
//        map.put("description","妞们对NUK freshfood研磨碗肯定不会陌生，便宜又好用。内侧设计很赞，一半光滑，一半有纹路，使用起来很省力，现做现吃。不含双酚A，清洁也方便，便宜好用还携带方便。从哥哥的时候就开始用，简直是做香蕉泥，牛油果泥，压石榴汁的利器，你值得拥有！";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_g));
//        map.put("title","Fox Run肉丸子制作器";
//        map.put("description","如果宝宝爱吃肉丸子，你觉得弄起来麻烦，肿么办？这款神器是制作肉丸子的好帮手，做出来的肉丸子大小均匀，干净又方便。等弟弟到了能次大丸子的时候，我准备入一个试试。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_h));
//        map.put("title","Gino婴儿辅食剪";
//        map.put("description","这款萌萌的婴儿辅食剪非常好用，适合碾碎熟软食物，操作方便，容易上手，也适合外出携带。外出就餐很多饭店没有专门给小宝宝的食物，碰到大块的食物宝宝嘴小吃不了怎么办？用这个辅食剪一切就都能搞定了。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_i));
//        map.put("title","日本京瓷Kyocera案板刀具";
//        map.put("description","这款我想吐下槽，因为也是热门款，但是用下来感觉不怎么好，案板很单薄，刀子也不怎么好用，牛油果都切不动。。。案板使用几次以后就有很多刮痕。如果你有好用的适合宝宝的刀具和案板可以在后台给我留言。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_j));
//        map.put("title","Norpro多功能擦菜板";
//        map.put("description","这款Norpro擦菜板主打多功能设计，集切片、切丝、擦丝、榨汁于一身，有了他给宝宝做辅食就方便多了。做工扎实，容易清洗，可折叠设计，便于存放。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_k));
//        map.put("title","Vidalia Chop Wizard蔬菜水果切丁切块器";
//        map.put("description","切蔬菜切水果什么的最没有技术含量最耽误时间了，有了这款切块器就能轻松搞定蔬菜、奶酪、水果等食材，干净又卫生，还可以节省时间。值得一提的是，切洋葱很给力，麻麻们不用担心流眼泪了！";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_l));
//        map.put("title","OXO玉米剥粒器";
//        map.put("description","这货绝对是剥玉米神器，使用方便。有了它玉米粥玉米汁就都不再麻烦了。剥下来的玉米用辅食机做成玉米泥，简直再好不过。你家宝宝爱吃玉米吗？我家小小包是玉米控呢。";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_m));
//        map.put("title","Chef'n草莓去蒂挖核器";
//        map.put("description","很可爱的草莓去蒂挖核器，吃草莓方便干净又卫生，不需要再用手把草莓蒂抠下来。宝宝也可以轻松吃草莓咯！";
//        map.put("seecount",1000;
//        map.put("collectionCount",389;
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//
//        childItem=new ChildItem();
//        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_n));
//        map.put("title","Alessi外星人趣味榨汁机";
//        map.put("description","这货采用银色蜘蛛造型，看起来像是外星来客，其实是用来榨汁的！鬼才菲利浦·斯达克的设计，超有个性。妞们将切好的果肉放在榨汁机顶部，来回旋转挤压，就可以榨出果汁了！摆放在厨房也是一道靓丽的风景线呢。当然，最好还是让男人们来操作，这个挤压起来还是稍微费点劲的。";
//        map.put("seecount",1000);
//        map.put("collectionCount",389);
//        map.put("buyCount",200;
//        groupItem2.item.add(childItem);
//        list.add(groupItem2);
//
//        groupItem3.title="宝宝辅食储存工具";
//        list.add(groupItem3);
//
//        groupItem4.title="宝宝餐具";
//        list.add(groupItem4);
//
//        groupItem5.title="宝宝用的防水围兜";
//        list.add(groupItem5);
//
//        groupItem6.title="其它有意思的辅食工具";
//        list.add(groupItem6);
//    }
    private void getDatas() {
        lists=new ArrayList<>();
        map=new HashMap<>();

        map.put("url", ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_a)));
        map.put("title","Beaba电动辅食机");
        map.put("description","Beaba电动辅食机是这次生了二宝以后买的，果然是众多妈妈推荐的神物，蒸和搅拌一次完成，非常方便，而且打出来的泥状食物非常细腻，夏天天气炎热，可以给宝宝做些开胃的水果泥和蔬菜泥。我觉得如果条件允许，电动辅食机还是很有必要的，辅食做起来省时省力，这样妈妈们才会有更多精力去研究辅食的多样化。虽然使用的时间可能只是6个月到1岁多，但是这个阶段也是宝宝成长的关键阶段，各种营养的摄入很重要。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",389);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_b)));
        map.put("title","飞利浦新安怡 食品蒸制搅拌一体机");
        map.put("description","飞利浦新安怡的这款辅食机也是相当好用的一款，相比Beaba来说价格更适中，使用起来也非常省心，先蒸煮，再翻转即可打泥，不用再几个容器倒腾来倒腾去，弄的哪里都是，或者手忙脚乱，从食材放入都收获泥糊一气呵成，最后倒出来就能直接喂给宝宝吃，是给宝宝添加健康辅食不可或缺的得力助手。");
        map.put("seecount",1000);
        map.put("collectionCount",354);
        map.put("buyCount",100);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_c)));
        map.put("title","Vitamix搅拌机");
        map.put("description","Vitamix搅拌机真的各种长草，搅打功能强，据说石头都能打碎，更别提宝宝辅食了！功率大，细胞破壁率高，营养全面均衡。制作出来的全谷类制品、水果汁、蔬菜汁、芝麻糊等十分细腻，宝宝容易消化。就是海淘的话就没有7年的保修了，而买国行的话，价格又贵的离谱。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_d)));
        map.put("title","Easiyo易极优酸奶机");
        map.put("description","因为喜欢易极优的酸奶粉，所以推荐这款同品牌的酸奶机。它是全球最大的DIY酸奶品牌，有了这款工具轻轻松松就可以让在家吃到新鲜美味的酸奶，操作简单，配合易极优酸乳粉，内罐放入水和酸乳粉摇匀、外罐倒入开水、盖盖等着，三步就能完成酸奶DIY，完全适合懒人。宝宝6个月就可以加酸奶了，易极优的酸奶粉原味的就可以做给宝宝喝。顺便说之前我用的是小熊的可以分杯的酸奶机，我觉得也挺好的，分杯功能特别适合给宝宝用，一次一杯,很方便！");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_e)));
        map.put("title","很棒的辅食");
        map.put("description","面条是很棒的辅食，出去买担心会放什么添加剂，自己做又费劲，这款全自动面条机能自动和面，18分钟全自动成面，操作简单。可以制作鸡蛋面、胡萝卜面、菠菜面...想要什么面都能实现。另外还有很多高大上的厨师机，比如KitchenAid，如果你特别喜欢下厨，不妨买一台，什么和面啦，绞肉啦，打蛋啦，做面条，做冰淇淋感觉无所不能。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_f)));
        map.put("title","NUK freshfood研磨碗");
        map.put("description","妞们对NUK freshfood研磨碗肯定不会陌生，便宜又好用。内侧设计很赞，一半光滑，一半有纹路，使用起来很省力，现做现吃。不含双酚A，清洁也方便，便宜好用还携带方便。从哥哥的时候就开始用，简直是做香蕉泥，牛油果泥，压石榴汁的利器，你值得拥有！");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_g)));
        map.put("title","Fox Run肉丸子制作器");
        map.put("description","如果宝宝爱吃肉丸子，你觉得弄起来麻烦，肿么办？这款神器是制作肉丸子的好帮手，做出来的肉丸子大小均匀，干净又方便。等弟弟到了能次大丸子的时候，我准备入一个试试。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_h)));
        map.put("title","Gino婴儿辅食剪");
        map.put("description","这款萌萌的婴儿辅食剪非常好用，适合碾碎熟软食物，操作方便，容易上手，也适合外出携带。外出就餐很多饭店没有专门给小宝宝的食物，碰到大块的食物宝宝嘴小吃不了怎么办？用这个辅食剪一切就都能搞定了。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_i)));
        map.put("title","日本京瓷Kyocera案板刀具");
        map.put("description","这款我想吐下槽，因为也是热门款，但是用下来感觉不怎么好，案板很单薄，刀子也不怎么好用，牛油果都切不动。。。案板使用几次以后就有很多刮痕。如果你有好用的适合宝宝的刀具和案板可以在后台给我留言。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_j)));
        map.put("title","Norpro多功能擦菜板");
        map.put("description","这款Norpro擦菜板主打多功能设计，集切片、切丝、擦丝、榨汁于一身，有了他给宝宝做辅食就方便多了。做工扎实，容易清洗，可折叠设计，便于存放。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_k)));
        map.put("title","Vidalia Chop Wizard蔬菜水果切丁切块器");
        map.put("description","切蔬菜切水果什么的最没有技术含量最耽误时间了，有了这款切块器就能轻松搞定蔬菜、奶酪、水果等食材，干净又卫生，还可以节省时间。值得一提的是，切洋葱很给力，麻麻们不用担心流眼泪了！");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_l)));
        map.put("title","OXO玉米剥粒器");
        map.put("description","这货绝对是剥玉米神器，使用方便。有了它玉米粥玉米汁就都不再麻烦了。剥下来的玉米用辅食机做成玉米泥，简直再好不过。你家宝宝爱吃玉米吗？我家小小包是玉米控呢。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_m)));
        map.put("title","Chef'n草莓去蒂挖核器");
        map.put("description","很可爱的草莓去蒂挖核器，吃草莓方便干净又卫生，不需要再用手把草莓蒂抠下来。宝宝也可以轻松吃草莓咯！");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);

        map=new HashMap<>();
        map.put("url",ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.t_n)));
        map.put("title","Alessi外星人趣味榨汁机");
        map.put("description","这货采用银色蜘蛛造型，看起来像是外星来客，其实是用来榨汁的！鬼才菲利浦·斯达克的设计，超有个性。妞们将切好的果肉放在榨汁机顶部，来回旋转挤压，就可以榨出果汁了！摆放在厨房也是一道靓丽的风景线呢。当然，最好还是让男人们来操作，这个挤压起来还是稍微费点劲的。");
        map.put("seecount",1000);
        map.put("collectionCount",389);
        map.put("buyCount",200);
        lists.add(map);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.school_tools,container,false);
//        expLv= (AnimatedExpandableListView) view.findViewById(R.id.school_tool_explv);
//        ExpListAdapter adapter=new ExpListAdapter(list);
//        expLv.setAdapter(adapter);
//        expLv.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                ((SchoolFragment) getParentFragment()).onDrag(AttachUtil.isAdapterViewAttach(view));
//            }
//        });
//        expLv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                Intent intent=new Intent(getActivity(), ToolsDetailActivity.class);
//                getActivity().startActivity(intent);
//                return false;
//            }
//        });
        school_tools_lv=(ListView)view.findViewById(R.id.school_tools_lv);
        SchoolToolsAdapter adapter=new SchoolToolsAdapter(lists);
        school_tools_lv.setAdapter(adapter);
        school_tools_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), ToolsDetailActivity.class);
                getActivity().startActivity(intent);
            }
        });
        school_tools_lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                ((SchoolFragment) getParentFragment()).onDrag(AttachUtil.isAdapterViewAttach(view));
            }
        });
        return view;
    }
}
