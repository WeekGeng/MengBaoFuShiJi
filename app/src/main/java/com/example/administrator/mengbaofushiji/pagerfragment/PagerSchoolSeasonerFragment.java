package com.example.administrator.mengbaofushiji.pagerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.SchoolSeasonerAdapter;
import com.example.administrator.mengbaofushiji.fragment.SchoolFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import github.chenupt.dragtoplayout.AttachUtil;

/**
 * Created by Administrator on 2015/4/8.
 */
public class PagerSchoolSeasonerFragment extends Fragment {
    private ListView school_seasoner_lv;
    private List<Map<String,Object>> list;
    private Map<String,Object> map;
    private SchoolSeasonerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }
    private void getData() {
        list=new ArrayList<>();
        map=new HashMap<>();
        map.put("type",0);
        map.put("title","宝宝各阶段所需盐量大公开");
        map.put("content","宝宝各个阶段所需盐的数量都不一样，具体标准如下：0-6个月：每天钠的摄入量不超过200毫克。6-12个月：每天钠的摄入量不超过500毫克。12-36个月：每天钠的摄入量不超过650毫克。摄入过量的盐，对宝宝的健康将产生以下危害：●宝宝的肾脏功能还未发育完全，不足以渗透过多的盐，摄盐过多会加重肾脏负担，同时增加心脏负担，从而影响宝宝的生长发育。\n" +
                "●摄盐过多会抑制口腔黏膜上皮细胞的繁殖，使得口腔唾液分泌减少，并导致唾液里所含的溶菌酶的数量减少。溶菌酶有杀菌的作用，它的减少会降低口腔对细菌、病毒的防御功能，从而削弱宝宝的抗病能力。\n" +
                "●宝宝的味觉极为灵敏，只要一点点盐，他们就会感觉很有滋味。摄盐过多的话，宝宝即使感觉很咸但由于不会表达，只能慢慢适应这样的咸度，最终口味变得越来越重，味觉发育受到严重影响。\n" +
                "●摄盐过多会影响锌的吸收，并增加钙等其他矿物质的排泄。●从小养成重盐的饮食习惯，长大后不容易纠正，容易引起高血压等疾病。");
        list.add(map);
        map=new HashMap<>();
        map.put("type",1);
        map.put("title","宝宝过量吃糖危害很大");
        map.put("content","宝宝每天除了摄入食物本身固有的天然糖以外，更多的糖来源于各种食品(如糖果、 巧克力、碳酸饮料、果汁、冰淇淋、蛋糕、饼干、果脯、膨化食品等)中的添加糖，正是这些人为添加到食品中的糖直接威胁着宝宝的健康。过量摄入糖的危害主要指的是过量摄入简单糖。摄入太多的单糖和双糖对宝宝的健康不利，容易引起龋齿；还会刺激人体内胰岛素水平升高，增加血中胰岛素，使儿茶酚胺分泌，交感神经活性增高，引起高血压；体内多余的糖还会转化为脂肪贮藏起来，造成肥胖；长期摄入过多的糖，可影响宝宝的注意力不集中；经常吃糖和甜点会降低味觉的灵敏度，对食欲也有抑制作用，加上其引起的维生素和微量元素缺乏，所以常吃甜食的宝宝易出现厌食、偏食等不良饮食习惯，进而发生营养不良。");
        map.put("img",R.drawable.eat_suager);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        map.put("title","必须记住，宝宝加盐最佳月龄");
        map.put("content","6个月以下的宝宝，其主要食物是母乳和配方奶，而母乳和配方奶中都含有钠(食盐中的主要成分)，且含量已经能够满足宝宝的需求，因此无需再额外补充盐。6-12个月的宝宝开始尝试辅食，而辅食中也基本含有钠盐，尤其是蛋白质含量丰富的食物，辅食中的盐分和母乳或配方奶中的盐分加起来还是能完全满足该年龄段的宝宝的需求，因此也无需再额外补充盐。\n" +
                "宝宝12个月以后，可以在辅食里适当地添加少量的盐。\n" +
                "TIPS：母乳喂养的妈妈也要少吃盐吗？\n" +
                "母乳喂养的妈妈食用过多的盐，乳汁里就可能含有相对更多的盐分，从而导致宝宝也摄入过多的盐。因此，母乳喂养的妈妈每天的食盐量也需要加以控制，以不超过正常人的标准——6克为宜。");
        list.add(map);

        map=new HashMap<>();
        map.put("type",1);
        map.put("title","妈咪必看！0¬¬-3岁宝宝摄糖标准");
        map.put("content","其实，日常饮食中的糖分很多种，应给宝宝选择“合适的糖”，并且要控制其摄入量。现代饮食环境下，对于糖的摄入，父母应该根据宝宝的不同年龄采取不同的控制方法和量。\n" +
                "\uF06C\t0-6个月\n" +
                "不足6个月的小宝宝，消化功能弱，只能代谢乳糖、蔗糖等简单的糖，所以推荐奶类以乳糖；妈妈只要哺喂宝宝母乳或配方奶粉就可以了，不必再额外添加糖。\n" +
                "\uF06C\t6-12个月\n" +
                "半岁以上的宝宝开始分泌淀粉酶，初步具备消化多糖淀粉的能力，因而4-6个月时，父母要及时为宝宝添加辅食。父母要尽量为宝宝自制辅食，尽量少让宝宝吃成品食物。在购买成品辅食时，应尽量选择低糖或无糖食品。\n" +
                "\uF06C\t1-3岁\n" +
                "这一年龄段的宝宝胃肠消化功能进一步加强，能吃的饮食种类已接近成人，主要让宝宝均衡摄入各类食物包括谷物类、蔬菜和水果、畜禽肉类和鱼虾、蛋类、奶豆类及其制品。这样能基本保证宝宝对糖、膳食纤维以及其它营养素的需求。\n" +
                "1-3岁的宝宝，每天摄入的简单糖在10克左右为最佳，不要超过20-30克。像糖果、甜点、冰淇淋、甜饮料等高糖食品，可以用作对宝宝口味的调剂而偶尔食用，但不能天天吃。\n" +
                "\n" +
                "Tips ：特别提醒\n" +
                "选择食物时，应有适应比例的粮食，并要多吃些蔬菜和水果，以利于摄取适量的膳食纤维、维生素和无机盐；不宜多吃高糖食品和高糖饮料。饭前、睡前不要让宝宝吃糖果和甜食。否则，会使血糖升高，导致饥饿感消失，宝宝食欲差。长期这样，宝宝身体所需要的其它营养供应不足，造成营养不良。此外，过多的糖留在胃里，会导致反腹胀等肠胃不适。\n" +
                "\n" +
                "糖并非十恶不赦的恶魔，大可不必受错误观念的束缚 ，父母们只要把科学知识应用到日常生活中去，合理安排宝宝们的饮食，完全可以轻松享受到生活的“甜蜜”。\n");
        map.put("img",R.drawable.eat_suager);
        list.add(map);

        map=new HashMap<>();
        map.put("type",0);
        map.put("title","宝宝用油选购技巧");
        map.put("content","颜色 一般来说，精炼程度越高，油的颜色越淡。当然，每种油都会有自己特有的一种颜色，不可能也没有必要精炼至无色。透明度 要选择清澄透明的油，透明度越高越好。\n" +
                "闻味道 取一两滴油放在手心，双手摩擦发热后，以闻不出异味（哈喇味或刺激味）为佳。\n" +
                "油的储存方式\n" +
                "置在阴凉干燥处，注意避光；每次用完后要将瓶盖拧紧，以减少与空气接触的时间；分装时要注意瓶子的干燥清洁；用过的油不可倒回瓶中与新油混合；不要长期用一个油瓶放油，要常换新油瓶。\nTips：用油须知\n" +
                "能够直接调用的油，尽量选择直接调用的方式；需要经过加热烹调后食用的油，其油温不宜过热，以加热时不冒油烟为佳。\n");
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        map.put("title","“甜食综合征”可是种病哦");
        map.put("content","属于双糖的蔗糖会在体内转化为葡萄糖，而葡萄糖在氧化分解的过程中需要含有维生素B1的酶来参与。大部分的糖果和甜点都含有蔗糖。儿童如果长期摄入糖分简单糖过量，会消耗掉大量维生素B1，造成维生素B1不足，最终会影响到葡萄糖的氧化，会影响中枢神经系统的活动，使宝宝表现出精力不集中、情绪不稳定、爱哭闹、好发睥气等，称为“甜食综合征”。所以对于那些偏爱甜食的孩子，家长平时应多给他吃一些富含维生素B1的食物，如糙米、豆类、动物肝脏等作为补充。");
        list.add(map);
        map=new HashMap<>();
        map.put("type",1);
        map.put("title","避开两大误区，给宝宝聪明加“油”");
        map.put("content","误区1：吃油容易引起肥胖，那就索性不要给宝宝吃或者等宝宝长大以后再吃。\n" +
                "专家解误：油脂摄入超标，的确容易引起肥胖。但油脂是人体生长和代谢过程中不可或缺的三大基本营养素之一，是构成人体细胞组织的重要成分。其主要功能有提供宝宝生长所必须的必需脂肪酸和能量、促进脂溶性维生素A、维生素D、维生素E和维生素K的吸收利用，还可以增加食物的美味、促进食欲，并减缓胃酸的分泌，使食物在胃里停留较长时间而增加饱腹感。因此，当宝宝10个月之后，可以慢慢尝试吃油。\n" +
                "\n" +
                "误区2：橄榄油是最好的油，所以只给宝宝吃橄榄油。\n" +
                "专家解误：橄榄油清香宜人，具有极高的营养价值；而且由于橄榄油在生产过程中未经过任何化学处理，其天然的营养成分保持得非常完好，的确非常适合宝宝食用。但是，从食用油的营养作用来讲，只要是天然的油脂，就没有最好也没有最坏；给宝宝选择食用油，应该注重其脂肪酸的组成，当宝宝体内的各种脂肪酸达到了平衡状态，才最健康。\n");
        map.put("img",R.drawable.shiyongyou);
        list.add(map);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.school_seasoner_fragment,container,false);
        school_seasoner_lv=(ListView)view.findViewById(R.id.school_seasoner_lv);
        adapter=new SchoolSeasonerAdapter(list);
        school_seasoner_lv.setAdapter(adapter);
        school_seasoner_lv.setOnScrollListener(new AbsListView.OnScrollListener() {
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
