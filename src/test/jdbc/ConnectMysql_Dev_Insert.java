package test.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: ConnectMysql.java
 * @Package test.jdbc
 * @Description: 造供应数据
 * @Company www.viewhigh.com
 * @date 2016年7月6日 下午7:09:09
 */
public class ConnectMysql_Dev_Insert {

    private static String insert_sql = "INSERT INTO `yzmm`.`m_kja_task_selftest_item_config` (`task_id`,`code`,`name`,`score`,`status`) VALUES  (?,?,?,?,?)";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        doStore();
    }

    private static void doStore() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DBUtils.getConnection();
        conn.setAutoCommit(false); // 设置手动提交  
        int count = 0;
        PreparedStatement psts = conn.prepareStatement(insert_sql);
        int resIndex=0;
        for (int i = 1; i <= 132; i++) {
            for (int j = 1; j <= 3; j++) {
                if(resIndex==128){
                    resIndex=0;
                }
                psts.setInt(1, i);
                psts.setString(3,res[resIndex]);
                psts.setInt(4,j);
                psts.setInt(5,1);
                switch (j) {
                    case 1:
                        psts.setString(2,"A");
                        break;
                    case 2:
                        psts.setString(2,"B");
                        break;
                    case 3:
                        psts.setString(2,"C");
                        break;
                    default:
                        break;
                }
                psts.addBatch();          // 加入批量处理
                resIndex++;
                count++;
            }
        }
        psts.executeBatch(); // 执行批量处理
        conn.commit();  // 提交
        System.out.println("All down : " + count);
        conn.close();
    }

    public final static String[] res = {"准备好了", "正在准备中", "还没开始准备", "孩子很喜欢听幼儿园故事，聊幼儿园的话题", "孩子没太多反应，一般都是大人说孩子听", "以前的言语让孩子对幼儿园产生了抵触情绪，还需要慢慢修正", "带孩子去幼儿园参观过了，孩子对幼儿园很向往，我也对这所幼儿园有了感性认识", "已经确定好参观时间，即将去参观", "还没做好参观幼儿园的计划安排，要尽快安排", "已了解清楚幼儿园的作息时间表", "还不了解幼儿园的作息时间表，要抓紧去落实", "已经做好孩子的作息时间表，可以开始执行了", "还没有做好孩子的作息时间表，得抓紧时间了", "孩子很喜欢玩情景模拟“上幼儿园”游戏", "孩子还不太会玩“上幼儿园”游戏，需要爸爸妈妈引导", "孩子不喜欢玩“上幼儿园”游戏，还得再变换形式，找他/她的兴趣点", "这些让孩子不想睡觉的障碍我家已经都扫清了，给孩子创造良好的入睡环境", "还有部分让孩子不想睡觉的障碍没扫清，正在努力调整中", "每天睡前做一些安静的活动，之后可以顺利入睡", "临睡前如果有爸妈陪着玩，还是会玩到兴奋。爸妈需要把陪孩子玩的时间提前", "孩子一玩起来就特别容易兴奋，可能和大人陪他/她玩的方式有关，继续调整", "已经完成了睡前流程表", "制定出了睡前流程的时间和环节，图表正在制作中", "还没开始制定睡前流程，我会加油", "孩子已经清楚了睡前流程图上的内容，在鼓励下可以照着去做", "孩子对睡前流程图上的内容似懂非懂，还需要给他/她讲解该怎么做", "孩子不明白睡前流程图和自己有什么关系，需要把流程图画得更简单易懂", "孩子能够在大人的协助下完成睡前流程中的每一步，在规定时间里上床睡觉", "孩子有配合大人完成睡前流程的意识或行为，还需要练习，好让过程变得更熟练", "睡前流程还没有发挥出作用，不过我不会放弃", "孩子不用大人抱着哄，能够在床上完成从醒着到睡着的过程", "需要先抱着哄，趁快睡着的时候放到床上，孩子就睡着了，不会再次醒来或哭闹", "孩子只要一放下就会醒过来哭闹，我知道改变需要时间，我会耐心陪着孩子", "我家的家庭会议开得很顺利，争取到了全家人的支持", "召开了家庭会议，部分人不支持，还需要再单独沟通争取支持", "还没开家庭会议或开了家庭会议，但是还没争取到家人的支持，我会继续耐心沟通", "经常和别的孩子一起玩，慢慢也能认识几个小伙伴，见面会主动打招呼", "经常和别的孩子一起玩，但还没有特别熟悉或能叫出名字的小伙伴", "很少和别的孩子们一起玩，以后得给孩子多创造社交机会", "孩子有认识的小伙伴，并能主动和他们打招呼", "孩子有认识的小伙伴，但是不太敢打招呼", "孩子没有什么熟悉的小伙伴，还得多让他和小朋友一起玩", "找到了几个入园伙伴，每天都创造机会让孩子们在一起玩", "找到了一个入园伙伴，每天都创造机会让孩子们在一起玩", "还没找到入园伙伴，我们会再努力去找", "每天大运动3个小时以上，运动能力比较好", "每天大运动2个小时左右，运动能力中等", "每天大运动不足2小时，运动能力较弱", "游戏阅读角已经布置好，并且利用起来了", "游戏阅读角正在布置中，孩子很期待", "还没有开始布置游戏阅读角，必须克服拖延症", "孩子喜欢在游戏阅读角玩，有时还能自己想出好玩的点子", "愿意在游戏阅读角玩，但是需要靠大人的鼓励、引导，才能玩下去", "在游戏阅读角玩，一次超不过5分钟，就被别的事情吸引了注意力", "我经常主动发现孩子的优点，并且鼓励他/她", "我还不习惯鼓励孩子，需要多练习", "以前数落孩子数落惯了，但是我有决心改变", "当孩子明白了规矩是什么，他/她基本能够按照规矩去做", "在有些事情上还是有规矩的，不过执行得不好，经常不按规矩来", "从来没给孩子定过规矩。我打算先从最头疼的问题开始，订立和执行规矩", "我基本能够做到接纳孩子的情绪，孩子大多数时候也乐于服从我的要求", "我明白应该接纳孩子的情绪，正在刻意练习这样做", "我以前没意识到应该接纳孩子的情绪，以后要注意了", "我会使用“暂停法”来制止孩子的坏行为，效果还不错", "我刚刚尝试使用“暂停法”，但效果不太好，还需要调整我的做法", "我没用过“暂停法”，孩子一哭闹我就忍不住发火。改变应该先从我做起", "孩子和家里的每个人单独相处都没问题，都是开开心心的", "孩子和妈妈、老人都还比较亲，对爸爸有生疏感，所以要提醒爸爸多陪孩子", "孩子特别黏妈妈，只要妈妈在，别人谁都不跟。妈妈准备适当“后撤”，给别人制造和孩子相处的机会", "孩子见到不熟悉的人，可以和对方打招呼，甚至简单交流", "孩子见到不熟悉的人，一开始会比较紧张，但是过一会儿就能够放松下来", "孩子见到不熟悉的人，会表现得很紧张。我要提醒自己别着急，慢慢引导孩子", "孩子可以自己去向陌生人寻求帮助，他/她真勇敢，也很大方！", "在爸爸妈妈的陪伴和鼓励下，孩子能去找陌生人求助。继续鼓励孩子，他/她一定会做得更好。", "孩子还不敢自己向陌生人求助，以后我要多留心，制造一些机会锻炼孩子。", "孩子对陌生人很友好，但是他/她不会随便接受陌生人的东西，也不会跟陌生人走。", "孩子对陌生人没有戒心，我需要继续加强对孩子的安全教育", "孩子在公共场合能够很自觉地坚持等候，和小朋友们轮流玩耍", "孩子可以做到排队等候，但是看到有人插队会非常不开心", "孩子原本可以排队等候，但是看到有人插队，自己也会不遵守规则", "短时间可以等。长时间的等待，孩子会放弃，但是他/她会去玩别的，不会不开心", "短时间可以等。如果等的时间长，孩子想放弃，又不甘心，会很烦躁", "孩子不喜欢等待/没有排队等候的意识，我得注意加强引导", "孩子经过暂停游戏的惩罚，感受到了插队的后果，最近可以做到排队去玩了", "暂停法对孩子有的点效果，但是他/她还是经常会忘记排队，需要大人不断提醒", "暂停法还没起到作用，我还需要再加上讲绘本、多鼓励、树立榜样等方法来帮助孩子", "孩子发现去和小朋友沟通也没那么难，他/她已经可以做到了", "孩子经过鼓励或者提示，能够自己去和小朋友沟通了", "孩子还需要更多时间积攒勇气，我要继续引导他/她，鼓励他/她", "孩子在大部分时候可以做到不抢玩具，而是和小朋友好好说，或者交换玩具玩", "孩子有进步，有时候可以克制自己，不去抢玩具了，但有些时候还会抢，要继续纠正，同时鼓励进步", "孩子还是经常抢玩具，但是我会按照任务指导中的方法，坚持引导和鼓励他/她", "孩子基本能用完整语句清楚地说出他/她想要得到的帮助，我也会去帮助他/她", "孩子会用简单的词组和句子来表达，不熟悉他/她的人可能需要靠猜测来揣摩他/她的意思。还需要继续锻炼孩子的语言表达能力", "孩子说不清楚想要大人帮他/她做什么。需要我一句一句地教给他/她该怎么说，别人才能听明白", "孩子乐于分享玩具，自己特别看重的玩具例外，我尊重孩子的意愿", "孩子还是不喜欢和别人分享玩具，我不强迫他/她，但是我会一直鼓励他/她。", "孩子能在7:30前高兴地醒来", "孩子7:30之前能醒来，可是有起床气", "7:30之前根本叫不醒孩子", "孩子大部分时间在12:30/21:30之前睡着", "孩子大部分时间在14:00/22:30之前睡着", "孩子大部分时间是在14:00/22:30之后睡着", "孩子已经习惯了午睡睡前流程，可以自己午睡", "正在建立和适应午睡睡前流程的过程中", "还没建立起午睡睡前流程", "大小便的准备工作已做好", "已完成50%以上的大小便准备工作", "完成20%以下的大小便准备工作", "80%的情况下孩子愿意早晚坐便盆", "50%的情况下孩子愿意早晚坐便盆", "20%的情况下孩子愿意早晚坐便盆", "80%的情况下我可以发现孩子的排便信号并提醒孩子", "50%的情况下我可以发现孩子的排便信号并提醒孩子", "20%的情况下我可以发现孩子的排便信号并提醒孩子", "孩子学会自己穿裤子了", "孩子还不会自己穿裤子", "孩子学会自己穿衣服了", "孩子还不会自己穿衣服", "孩子学会自己脱裤子了", "孩子还不会自己脱裤子", "孩子学会自己脱衣服了", "孩子还不会自己脱衣服", "孩子学会自己脱鞋了", "孩子还不会自己脱鞋", "孩子学会自己穿鞋，并能分清左右了", "孩子会自己穿鞋，但还分不清左右", "孩子不会自己穿鞋，也分不清左右"};
}
