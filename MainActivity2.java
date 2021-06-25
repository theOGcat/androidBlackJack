package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.room.Query;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    UserDatabase db;
    UserDAO userDAO;
    public int winCount;
    public int loseCount;
    private String username;
    int n = 0;
    static int pIndividual = 2;
    static int dIndividual = 2;
    static int pointCard = 0;
    Card[] deck;
    boolean isDealerbusted;
    boolean isPlayerbusted;
    public static boolean tie;
    public static boolean playerWin;
    static int playerScore;
    static int dealerScore;
    Card[] Playerhand;
    Card[] DealerHand;
    ImageView P1;
    ImageView P2;
    ImageView P3;
    ImageView D1;
    ImageView D2;
    ImageView D3;


    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        db = UserDatabase.getDatabase(getApplicationContext());
        userDAO = db.userDAO();
        username = getIntent().getStringExtra("username");


        P1 = (ImageView)findViewById(R.id.playerC1);
        P2 = (ImageView)findViewById(R.id.playerC2);
        P3 = (ImageView)findViewById(R.id.playerC3);
        D1 = (ImageView)findViewById(R.id.dealerC1);
        D2 = (ImageView)findViewById(R.id.dealerC2);
        D3 = (ImageView)findViewById(R.id.dealerC3);
        TextView textviewPlayer = (TextView)findViewById(R.id.playerScore);
        TextView textviewDealer = (TextView)findViewById(R.id.dealerScore);
        deck = new Card[52];
        Playerhand = new Card[52];
        DealerHand = new Card[52];
        for(int suit = 0; suit < 4 ; suit++){
            for(int rank = 0; rank < 13; rank++){
                deck[n] = new Card(suit,rank);
                n++;
            }
        }
        deck = shuffleDeck(deck);
        Playerhand[pointCard] = deck[pointCard];
        Playerhand[pointCard + 1] = deck[pointCard + 1];
        DealerHand[pointCard] = deck[pointCard + 2];
        DealerHand[pointCard + 1] = deck[pointCard + 3];

        Log.v("asd","Player suit:" + Playerhand[pointCard].suit);
        Log.v("asd","Player rank:" + Playerhand[pointCard].rank);

        Log.v("asd","Player suit1:" + Playerhand[pointCard + 1].suit);
        Log.v("asd","Player rank1:" + Playerhand[pointCard + 1].rank);

        Log.v("asd","Dealer suit:" + DealerHand[pointCard].suit);
        Log.v("asd","Dealer rank:" + DealerHand[pointCard].rank);

        Log.v("asd","Dealer suit1:" + DealerHand[pointCard + 1].suit);
        Log.v("asd","Dealer rank1:" + DealerHand[pointCard + 1].rank);

        switch (Playerhand[pointCard].rank){
            case 0:
                playerScore = 10;
                break;
            case 11:
                playerScore = 10;
                break;
            case 12:
                playerScore = 10;
                break;
            default:
                playerScore = Playerhand[pointCard].rank+1;
                break;
        }
        switch (Playerhand[pointCard + 1].rank){
            case 0:
                playerScore += 10;
                break;
            case 11:
                playerScore += 10;
                 break;
            case 12:
                playerScore += 10;
                break;
            default:
                playerScore += Playerhand[pointCard+1].rank+1;
                break;
        }
        switch (DealerHand[pointCard].rank){
            case 0:
                dealerScore = 10;
                break;
            case 11:
                dealerScore = 10;
                break;
            case 12:
                dealerScore = 10;
                break;
            default:
                dealerScore = DealerHand[pointCard].rank+1;
                break;
        }
        switch (DealerHand[pointCard + 1].rank){
            case 0:
                dealerScore += 10;
                break;
            case 11:
                dealerScore += 10;
                break;
            case 12:
                dealerScore += 10;
                break;
            default:
                dealerScore += DealerHand[pointCard+1].rank+1;
                break;
        }
        textviewPlayer.setText(""+playerScore);
        textviewDealer.setText(""+dealerScore);


        DrawCards player1 = new DrawCards(Playerhand[pointCard]);
        String player1a = player1.returnCards(Playerhand[pointCard].suit,Playerhand[pointCard].rank);
        getCardPic(player1a,P1);

        DrawCards player2 = new DrawCards(Playerhand[pointCard+1]);
        String player2a = player2.returnCards(Playerhand[pointCard+1].suit,Playerhand[pointCard+1].rank);
        getCardPic(player2a,P2);

        DrawCards dealer1 = new DrawCards(DealerHand[pointCard]);
        String dealer1a = dealer1.returnCards(DealerHand[pointCard].suit,DealerHand[pointCard].rank);
        getCardPic(dealer1a,D1);

        DrawCards dealer2 = new DrawCards(DealerHand[pointCard+1]);
        String dealer2a = dealer2.returnCards(DealerHand[pointCard+1].suit,DealerHand[pointCard+1].rank);
        getCardPic(dealer2a,D2);
        pointCard = 4;
        if(playerScore < 15){
            Context context = getApplicationContext();
            CharSequence text = "Your must draw another card";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

/*
        Log.v("asd","Player Score:" + playerScore);
        Log.v("asd","Dealer Score:" + dealerScore);

*/

    }


    public void clickMethodHit(View view){

       Playerhand[pIndividual] = deck[pointCard];
            DrawCards player3 = new DrawCards(Playerhand[pIndividual]);
            String player3a = player3.returnCards(Playerhand[pIndividual].suit, Playerhand[pIndividual].rank);
            getCardPic(player3a, P3);
            switch (Playerhand[pIndividual].rank) {
                case 0:
                    if (playerScore + 10 >= 21){
                        playerScore+=1;
                    }
                    else{
                    playerScore += 10;
                    }
                    break;
                case 11:
                    playerScore += 10;
                    break;
                case 12:
                    playerScore += 10;
                    break;
                default:
                    playerScore += Playerhand[pIndividual].rank + 1;
                    break;
            }
            TextView textviewPlayer = (TextView) findViewById(R.id.playerScore);
            textviewPlayer.setText("" + playerScore);

        if(playerScore > 21){
            isPlayerbusted=true;
            loseCount++;
            Context context = getApplicationContext();
            CharSequence text = "Your are busted, Please play again";
            int duration = Toast.LENGTH_SHORT;
            playerWin = false;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            UserDatabase.databaseWriteExecutor.execute(() -> {
                UserScores newUserscore = new UserScores(username,0,loseCount);
                userDAO.Insert(newUserscore);

            });

            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        }

            Log.v("asd", "PointCARD:" + pointCard);
            pointCard++;
            pIndividual++;
        Log.v("asd", "PointCARD:" + pIndividual);
    }




    public void clickMethodStay(View view) throws InterruptedException {
        while(dealerScore<=21) {
            if (dealerScore >= 18) {
                break;
            }


            DealerHand[dIndividual] = deck[pointCard];
            DrawCards dealer3 = new DrawCards(DealerHand[dIndividual]);
            String dealer3a = dealer3.returnCards(DealerHand[dIndividual].suit, DealerHand[dIndividual].rank);
            getCardPic(dealer3a, D3);

            switch (DealerHand[dIndividual].rank) {
                case 0:
                    if (dealerScore + 10 >= 21) {
                        dealerScore += 1;
                    } else {
                        dealerScore += 10;
                    }
                    break;
                case 11:
                    dealerScore += 10;
                    break;
                case 12:
                    dealerScore += 10;
                    break;
                default:
                    dealerScore += DealerHand[dIndividual].rank + 1;
                    break;
            }
            TextView textviewPlayer = (TextView) findViewById(R.id.dealerScore);
            textviewPlayer.setText("" + dealerScore);

            if(dealerScore > 21){
                isDealerbusted = true;
                playerWin = true;
                break;
            }
            dIndividual++;
            pointCard++;

        }
            if(!isDealerbusted) {
                if (dealerScore > playerScore) {
                    Log.v("asd", "Dealer Wins");
                    playerWin=false;
                    loseCount++;
                    UserDatabase.databaseWriteExecutor.execute(() -> {
                        UserScores newUserscore = new UserScores(username,0,loseCount);
                        userDAO.Insert(newUserscore);

                    });
                    Intent intent = new Intent(this, MainActivity3.class);

                    startActivity(intent);
                } else if (dealerScore == playerScore) {
                    tie=true;
                    Log.v("asd", " Tie");
                    Intent intent = new Intent(this, MainActivity3.class);
                    startActivity(intent);
                } else{
                    playerWin=true;
                    Log.v("asd", "Player Wins");
                winCount++;
                    UserDatabase.databaseWriteExecutor.execute(() -> {
                        UserScores newUserscore = new UserScores(username,winCount,0);
                        userDAO.Insert(newUserscore);

                    });
                Intent intent = new Intent(this, MainActivity3.class);
                    startActivity(intent);
                }
            }
            else {
                winCount++;
                playerWin=true;
                Context context = getApplicationContext();
                CharSequence text = "Dealer busted, You win";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                UserDatabase.databaseWriteExecutor.execute(() -> {
                    UserScores newUserscore = new UserScores(username,winCount,0);
                    userDAO.Insert(newUserscore);

                });

                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
            }



    }



    public void clickMethodShow(View view){

        List<UserScores>list = userDAO.getUserScores(username);
        String result ="";
        for(UserScores a :list){
            result += "User Name:"+ a.username + "Win: "+a.win + "Lose:"+ a.lose+"\n";
        }
        Toast toast = Toast.makeText(this, result, Toast.LENGTH_LONG);
        toast.show();

    }


    public void getCardPic(String url,ImageView pic){
        int imageResource = getResources().getIdentifier(url,null,getPackageName());
        pic.setImageResource(imageResource);
    }



    public Card[] shuffleDeck(Card[] deck){
        Random random = new Random();
        Card cardHolder = new Card(0,0);
        for (int n = 0; n <52; n++){
            int randomIndex = random.nextInt(52);
            cardHolder = deck[randomIndex];
            deck[randomIndex] = deck[n];
            deck[n] = cardHolder;

        }
        return deck;
    }




























}
