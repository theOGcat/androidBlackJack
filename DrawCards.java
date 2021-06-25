package com.example.finalproject;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DrawCards extends AppCompatActivity {
    Card card;
    public DrawCards(Card card){
        this.card = card;
    }


    public String returnCards(int suit,int rank)
    {
     suit = card.suit;
     rank = card.rank;
     String s1 = new String();
     if(suit == 0) {
         switch (rank) {
             case 0:
                 s1 = "@drawable/ace_of_spades";
                 break;
             case 1:
                 s1 = "@drawable/two_of_spades";
                 break;
             case 2:
                 s1 = "@drawable/three_of_spades";
                 break;
             case 3:
                 s1 = "@drawable/four_of_spades";
                 break;
             case 4:
                 s1 = "@drawable/five_of_spades";
                 break;
             case 5:
                 s1 = "@drawable/six_of_spades";
                 break;
             case 6:
                 s1 = "@drawable/seven_of_spades";
                 break;
             case 7:
                 s1 = "@drawable/eight_of_spades";
                 break;
             case 8:
                 s1 = "@drawable/nine_of_spades";
                 break;
             case 9:
                 s1 = "@drawable/ten_of_spades";
                 break;
             case 10:
                 s1 = "@drawable/jack_of_spades";
                 break;
             case 11:
                 s1 = "@drawable/queen_of_spades";
                 break;
             case 12:
                 s1 = "@drawable/king_of_spades";
                 break;
         }
     }


        if(suit == 1) {
            switch (rank) {
                case 0:
                    s1 = "@drawable/ace_of_hearts";
                    break;
                case 1:
                    s1 = "@drawable/two_of_hearts";
                    break;
                case 2:
                    s1 = "@drawable/three_of_hearts";
                    break;
                case 3:
                    s1 = "@drawable/four_of_hearts";
                    break;
                case 4:
                    s1 = "@drawable/five_of_hearts";
                    break;
                case 5:
                    s1 = "@drawable/six_of_hearts";
                    break;
                case 6:
                    s1 = "@drawable/seven_of_hearts";
                    break;
                case 7:
                    s1 = "@drawable/eight_of_hearts";
                    break;
                case 8:
                    s1 = "@drawable/nine_of_hearts";
                    break;
                case 9:
                    s1 = "@drawable/ten_of_hearts";
                    break;
                case 10:
                    s1 = "@drawable/jack_of_hearts";
                    break;
                case 11:
                    s1 = "@drawable/queen_of_hearts";
                    break;
                case 12:
                    s1 = "@drawable/king_of_hearts";
                    break;
            }
        }

        if(suit == 2) {
            switch (rank) {
                case 0:
                    s1 = "@drawable/ace_of_clubs";
                    break;
                case 1:
                    s1 = "@drawable/two_of_clubs";
                    break;
                case 2:
                    s1 = "@drawable/three_of_clubs";
                    break;
                case 3:
                    s1 = "@drawable/four_of_clubs";
                    break;
                case 4:
                    s1 = "@drawable/five_of_clubs";
                    break;
                case 5:
                    s1 = "@drawable/six_of_clubs";
                    break;
                case 6:
                    s1 = "@drawable/seven_of_clubs";
                    break;
                case 7:
                    s1 = "@drawable/eight_of_clubs";
                    break;
                case 8:
                    s1 = "@drawable/nine_of_clubs";
                    break;
                case 9:
                    s1 = "@drawable/ten_of_clubs";
                    break;
                case 10:
                    s1 = "@drawable/jack_of_clubs";
                    break;
                case 11:
                    s1 = "@drawable/queen_of_clubs";
                    break;
                case 12:
                    s1 = "@drawable/king_of_clubs";
                    break;
            }
        }


        if(suit == 3) {
            switch (rank) {
                case 0:
                    s1 = "@drawable/ace_of_diamonds";
                    break;
                case 1:
                    s1 = "@drawable/two_of_diamonds";
                    break;
                case 2:
                    s1 = "@drawable/three_of_diamonds";
                    break;
                case 3:
                    s1 = "@drawable/four_of_diamonds";
                    break;
                case 4:
                    s1 = "@drawable/five_of_diamonds";
                    break;
                case 5:
                    s1 = "@drawable/six_of_diamonds";
                    break;
                case 6:
                    s1 = "@drawable/seven_of_diamonds";
                    break;
                case 7:
                    s1 = "@drawable/eight_of_diamonds";
                    break;
                case 8:
                    s1 = "@drawable/nine_of_diamonds";
                    break;
                case 9:
                    s1 = "@drawable/ten_of_diamonds";
                    break;
                case 10:
                    s1 = "@drawable/jack_of_diamonds";
                    break;
                case 11:
                    s1 = "@drawable/queen_of_diamonds";
                    break;
                case 12:
                    s1 = "@drawable/king_of_diamonds";
                    break;
            }
        }


    return s1;
    }



}
