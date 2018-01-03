package com.rothenflue.services.bdd.entities;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

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
public class Currency {

    @Id(autoincrement = true)
    private Long id;

    private String name;

    private String attr;

    private String iconPath;

    @ToMany(referencedJoinProperty = "currencyId")
    @OrderBy("timestamp ASC")
    private List<CurrencyValue> Values;

    @ToMany(referencedJoinProperty = "currencyId")
    @OrderBy("timestamp DESC")
    private List<CurrencyAvailability> CurrencyAvailability;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1033120508)
    private transient CurrencyDao myDao;

    @Generated(hash = 5614048)
    public Currency(Long id, String name, String attr, String iconPath) {
        this.id = id;
        this.name = name;
        this.attr = attr;
        this.iconPath = iconPath;
    }

    @Generated(hash = 1387171739)
    public Currency() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttr() {
        return this.attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 803777469)
    public List<CurrencyValue> getValues() {
        if (Values == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CurrencyValueDao targetDao = daoSession.getCurrencyValueDao();
            List<CurrencyValue> ValuesNew = targetDao._queryCurrency_Values(id);
            synchronized (this) {
                if (Values == null) {
                    Values = ValuesNew;
                }
            }
        }
        return Values;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 857916428)
    public synchronized void resetValues() {
        Values = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1802136271)
    public List<CurrencyAvailability> getCurrencyAvailability() {
        if (CurrencyAvailability == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CurrencyAvailabilityDao targetDao = daoSession.getCurrencyAvailabilityDao();
            List<CurrencyAvailability> CurrencyAvailabilityNew = targetDao
                    ._queryCurrency_CurrencyAvailability(id);
            synchronized (this) {
                if (CurrencyAvailability == null) {
                    CurrencyAvailability = CurrencyAvailabilityNew;
                }
            }
        }
        return CurrencyAvailability;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1152367930)
    public synchronized void resetCurrencyAvailability() {
        CurrencyAvailability = null;
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
    @Generated(hash = 869658167)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCurrencyDao() : null;
    }


}
