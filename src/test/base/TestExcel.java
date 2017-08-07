package test.base;

import test.bean.KjaTaskAnswer;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * Created by qiu_zhongqiang on 2017/6/30.
 */
public class TestExcel {

    public static void main(String[] args) {
        File csv = new File("/Users/qiu_zhongqiang/Downloads/20170629/aa.csv");  // CSV文件路径
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            List<String> titles = new ArrayList<>();
            List<List<String>> selects=new ArrayList<List<String>>();
            Map<String,List<String>> mapList=new HashMap<>();
            while ((line = br.readLine()) != null)  //读取到的内容给line变量
            {
                everyLine = line;
                String[] split = everyLine.split(",");
                titles.add(split[0]);
                String s = split[1];
                //选项任务
                String[] zp = s.split("、");
                List<String> tasks=new ArrayList<>();
                for (int i = 0; i <zp.length ; i++) {
                    tasks.add(zp[i]);
                }
                selects.add(tasks);
                //mapList.put(split[0],)
            }
            System.out.println("csv表格中所有行数："+titles.size());
            //ConnectMysql_Dev_m_kja_task_answer_Insert
            List<KjaTaskAnswer> list = new ArrayList<>();
            Integer titleStart=42;//题目起始id
            Integer itemStart=150;//选项起始id


            int itemid=0;
            for (int i = 0; i < selects.size(); i++) {
                List<String> tasks = selects.get(i);
                for (int j = 0; j <tasks.size() ; j++) {
                    KjaTaskAnswer taskAnswer= new KjaTaskAnswer();
                    taskAnswer.setItemId(String.valueOf((itemid+itemStart)));
                    taskAnswer.setTargetId(Long.valueOf(titles.get(i)));
                    taskAnswer.setSubjectId("5");
                    taskAnswer.setTitleId(String.valueOf(Integer.valueOf(titles.get(i))-1+titleStart));
                    taskAnswer.setTaskId(Long.valueOf(tasks.get(j)));
                    list.add(taskAnswer);
                    itemid++;
                }
            }
            //录入关系
            //ConnectMysql_Dev_m_kja_task_answer_Insert.doStore(list);

            //过滤重复的ta过滤重复的taskidskid
            List<KjaTaskAnswer> collect = list.stream().collect(
                    collectingAndThen(
                            toCollection(() -> new TreeSet<>(Comparator.comparingLong(KjaTaskAnswer::getTaskId))), ArrayList::new)
            );
            //任务表添加
            //ConnectMysql_Dev_m_kja_task_Update.doStore(collect);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void aaa(){

        List<String[]> list = new ArrayList<>();

        Map<Integer,List<String>> root = new HashMap<>();

        String[] codes = new String[]{"A","B","C","D"};

        for (String[] ss:list) {
            Integer key = Integer.valueOf(ss[0]);
            List<String> temp = root.get(key);
            if(null==temp){
                temp=new ArrayList<>();
                root.put(key,temp);
            }
            temp.add(ss[2]);
        }

        Map<String,Integer> tt = new HashMap<>();

        List<String[]> taskOp = new ArrayList<>();

        root.forEach((a,b)->{
            //a 1
            //b list<String> 30、31、1、3、4
            for(int i=0;i<b.size();i++){
                String code = codes[i];
                String[] ttt = b.get(0).split("、");
                for(String t : ttt){
                    tt.put(t,a);
                    taskOp.add(new String[]{a.toString(),code,t.toString()});
                }
            }
        });

        //目标任务关系
        tt.forEach((c,d)->{

        });
       //选项任务关系
        taskOp.forEach(e->{
            String titleId = e[0];
            String code=e[1];
            String taskId=e[2];
            //根据 titleid 和 code 查询 选项id=itemId

        });
    }

}