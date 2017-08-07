package com.springinaction.knights;

import org.junit.Test;

/**
 * Created by qiu_zhongqiang on 2017/3/18.
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);

        BraveKnight knight = new BraveKnight(mockQuest);

        knight.embarkOnQuest();


    }


    private Quest mock(Class<Quest> questClass) {
        return questClass.cast(
                new Quest() {
                    @Override
                    public void embark() {
                        System.out.print("计划开始");
                    }
                }
        );
    }
}
