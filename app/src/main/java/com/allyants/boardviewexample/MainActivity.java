package com.allyants.boardviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.allyants.boardview.BoardView;
import com.allyants.boardview.Item;
import com.allyants.boardview.SimpleBoardAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BoardView boardView = (BoardView)findViewById(R.id.boardView);
        final ArrayList<SimpleBoardAdapter.SimpleColumn> data = new ArrayList<>();
        list.add(new Item("Item 1"));
        list.add(new Item("Item 1"));
        list.add(new Item("Item 1"));
        list.add(new Item("Item 1"));
        list.add(new Item("I am a very long list that is not the same size as the others. I am a multiline"));
        list.add(new Item("Item 1"));
        final ArrayList<Item> empty = new ArrayList<>();
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 1",(ArrayList)list));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 2",(ArrayList)empty));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 3",(ArrayList)empty));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 4",(ArrayList)empty));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 5",(ArrayList)empty));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 6",(ArrayList)empty));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 7",(ArrayList)empty));
        final SimpleBoardAdapter boardAdapter = new SimpleBoardAdapter(this,data);
        boardView.setAdapter(boardAdapter);
        boardView.setOnDoneListener(new BoardView.DoneListener() {
            @Override
            public void onDone() {
                Log.e("scroll","done");
            }
        });
        boardView.setOnItemClickListener(new BoardView.ItemClickListener() {
            @Override
            public void onClick(View v, int column_pos, int item_pos) {
                Log.e("OnClickItem","Column Pos: "+String.valueOf(column_pos)+ " Item Pos: "+String.valueOf(item_pos));
            }
        });
        boardView.setOnHeaderClickListener(new BoardView.HeaderClickListener() {
            @Override
            public void onClick(View v, int column_pos) {
                Log.e("OnClickItem","Column Pos: "+String.valueOf(column_pos));
            }
        });
        boardView.setOnDragColumnListener(new BoardView.DragColumnStartCallback() {
            @Override
            public void startDrag(View view, int i) {
                Log.e("Start Drag Column",String.valueOf(i));
            }

            @Override
            public void changedPosition(View view, int i, int i1) {
                Log.e("Change Drag Column",String.valueOf(i1));
            }

            @Override
            public void dragging(View itemView, MotionEvent event) {
                Log.e("Pos X",String.valueOf(event.getRawX()));
                Log.e("Pos Y",String.valueOf(event.getRawY()));
            }

            @Override
            public void endDrag(View view, int i, int i1) {
                Log.e("End Drag Column",String.valueOf(i1));
            }
        });
        boardView.setOnFooterClickListener(new BoardView.FooterClickListener() {
            @Override
            public void onClick(View v, int column_pos) {
                Log.e("Footer Click","Column: "+String.valueOf(column_pos));
            }
        });
        boardView.setOnDragItemListener(new BoardView.DragItemStartCallback() {
            @Override
            public void startDrag(View view, int i, int i1) {
                Log.e("Start Drag Item","Item: "+String.valueOf(i1)+"; Column:"+String.valueOf(i));
            }

            @Override
            public void changedPosition(View view, int i, int i1, int i2, int i3) {
                Log.e("Change Drag Item","Item: "+String.valueOf(i2)+"; Column:"+String.valueOf(i3));
            }

            @Override
            public void dragging(View itemView, MotionEvent event) {
                Log.e("Pos X",String.valueOf(event.getRawX()));
                Log.e("Pos Y",String.valueOf(event.getRawY()));
            }

            @Override
            public void endDrag(View view, int i, int i1, int i2, int i3) {
                Log.e("End Drag Item","Item: "+String.valueOf(i2)+"; Column:"+String.valueOf(i3));
            }
        });
    }

}
