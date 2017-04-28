package com.springinaction.knights;

/**
 * Created by qiu_zhongqiang on 2017/3/18.
 */
public class BraveKnight implements Knight{

    private Quest quest;

    public BraveKnight(Quest quest){
        this.quest=quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
