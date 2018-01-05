package com.rothenflue.services.bdd.firestore;

import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by apest on 05/01/2018.
 */

public class FirestoreDAO {
    FirebaseFirestore db;

    public FirestoreDAO() {
        db = FirebaseFirestore.getInstance();
    }
}
