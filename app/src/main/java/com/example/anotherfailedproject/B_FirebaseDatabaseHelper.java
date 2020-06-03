package com.example.anotherfailedproject;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class B_FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencePlayer;
    private List<Player> playerArray = new ArrayList<>();

    public B_FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferencePlayer = mDatabase.getReference().child("saison1").child("player");
    }

    public interface DataStatus{
        void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public void readPlayer (final DataStatus dataStatus){
        mReferencePlayer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerArray.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Player player = keyNode.getValue(Player.class);
                    playerArray.add(player);

                }
                dataStatus.DataIsLoaded(playerArray,keys);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }

    public void addPlayer (Player player, final DataStatus dataStatus){
        String key = mReferencePlayer.push().getKey();
        mReferencePlayer.child(key).setValue(player).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void updatePlayer(String key, Player player, final DataStatus dataStatus){
        mReferencePlayer.child(key).setValue(player)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsUpdated();
                    }
                });
    }


    public void deletePlayer(String key, final DataStatus dataStatus){
        mReferencePlayer.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsDeleted();
                    }
        });
    }
}
