package com.wojnar.GameEngine.board;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by paul on 04.07.17.
 */
public interface BoardDrawer {

    static void drawBoard(Boards myPlayBoard){
        Set set = myPlayBoard.entrySet();
        Iterator iterator = set.iterator();
        int counter =0;
        while (iterator.hasNext()) {
            Map.Entry<Integer,AvailableMarks> mEntry = (Map.Entry) iterator.next();
            if (counter!=0&& counter%myPlayBoard.getWidth() == 0)
                System.out.println();
            if(mEntry.getValue().equals(AvailableMarks.EMPTY_MARK))
                System.out.printf(mEntry.getKey().toString() + mEntry.getValue().getCharacter());
            else
                System.out.printf(mEntry.getValue().getCharacter()+"|");
            counter++;
        }
        System.out.println();
    }
}


