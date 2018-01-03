package com.rothenflue.services.bdd.entities;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by apest on 03/01/2018.
 */
@Entity(
        // Flag to make an entity "active": Active entities have update,
        // delete, and refresh methods.
        active = true,

        // Whether an all properties constructor should be generated.
        // A no-args constructor is always required.
        generateConstructors = true,

        // Whether getters and setters for properties should be generated if missing.
        generateGettersSetters = true
)
public class CurrencyValue {

    @Id(autoincrement = true)
    private Long id;

    private long currencyId;

    @ToOne(joinProperty = "currencyId")
    private Currency currency;

    private long timestamp;

    private double deviceValue;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 379111094)
    private transient CurrencyValueDao myDao;
    @Generated(hash = 1489923924)
    private transient Long currency__resolvedKey;

    @Generated(hash = 1755416540)
    public CurrencyValue(Long id, long currencyId, long timestamp, double deviceValue) {
        this.id = id;
        this.currencyId = currencyId;
        this.timestamp = timestamp;
        this.deviceValue = deviceValue;
    }

    @Generated(hash = 1184531596)
    public CurrencyValue() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getDeviceValue() {
        return this.deviceValue;
    }

    public void setDeviceValue(double deviceValue) {
        this.deviceValue = deviceValue;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 670547195)
    public Currency getCurrency() {
        long __key = this.currencyId;
        if (currency__resolvedKey == null || !currency__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CurrencyDao targetDao = daoSession.getCurrencyDao();
            Currency currencyNew = targetDao.load(__key);
            synchronized (this) {
                currency = currencyNew;
                currency__resolvedKey = __key;
            }
        }
        return currency;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 2029286997)
    public void setCurrency(@NotNull Currency currency) {
        if (currency == null) {
            throw new DaoException(
                    "To-one property 'currencyId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.currency = currency;
            currencyId = currency.getId();
            currency__resolvedKey = currencyId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 866385431)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCurrencyValueDao() : null;
    }

}
