package com.rothenflue.services.bdd.entities;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

/**
 * Created by apest on 03/01/2018.
 */

public class LiteBitMobileDAO {

    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public LiteBitMobileDAO(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, "LitebitDb", null);
        daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }


    public long setCurrency(Currency c) {
        try {
            return daoSession.getCurrencyDao().insert(c);
        } catch (SQLiteConstraintException e) {
            return -1;
        }
    }

    public long setCurrencyAvailiability(CurrencyAvailability c) {
        try {
            return daoSession.getCurrencyAvailabilityDao().insert(c);
        } catch (SQLiteConstraintException e) {
            return -1;
        }
    }

    public Currency getCurrency(long currencyId) {
        return daoSession.getCurrencyDao().loadByRowId(currencyId);

    }


}
