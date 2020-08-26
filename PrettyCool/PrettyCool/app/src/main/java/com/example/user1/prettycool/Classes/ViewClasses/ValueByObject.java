package com.example.user1.prettycool.Classes.ViewClasses;

import com.example.user1.prettycool.Classes.Objects;
import com.example.user1.prettycool.Classes.Persons.AllItems;
import com.example.user1.prettycool.Classes.Persons.HeroParameters;
import com.example.user1.prettycool.Classes.Persons.MonstersParameters;

import java.util.HashMap;

/**
 * Created by user1 on 13.04.2016.
 */
public class ValueByObject {
int type;
    public int getSomething(HashMap<String,Object> hm,String uniqueType,String fieldName) {

//           clas = hm.get(uniqueType).getClass();
//                  type = clas.getField(fieldName).getInt(hm.get(uniqueType));
//            type = hm.get(uniqueType).getClass().getField(fieldName).getInt(hm.get(uniqueType).getClass());

        Objects obj = (Objects) hm.get(uniqueType);
        if (obj != null) {
            switch (obj.getImHeroNotMonstr()) {
                case (1):
                    HeroParameters heroParameters = (HeroParameters) obj;
                    getForHero(heroParameters, fieldName);
                    break;
                case (0):
                    MonstersParameters monstersParameters = (MonstersParameters) obj;
                    getForMonstr(monstersParameters, fieldName);
                    break;
                case (-1):
                    AllItems allItems = (AllItems) obj;
                    getForItem(allItems, fieldName);
                    break;
            }
        }
            return type;

        }



   private void getForHero(HeroParameters heroParameters,String fieldName) {
       switch (fieldName) {
           case "HP":
               type = heroParameters.getHP();
               break;
           case "ATTACK":
               type = heroParameters.getATTACK();
               break;
           case "ATTACKDISTANCE":
               type = heroParameters.getATTACKDISTANCE();
               break;
           case "imHeroNotMonstr":
               type = heroParameters.getImHeroNotMonstr();
               break;
           case "drawableId":
               type = heroParameters.getDrawableId();
               break;
           case "MOVEPOINTS":
               type = heroParameters.getMOVEPOINTS();
               break;
           case "SHIELD":
               type = heroParameters.getSHIELD();
               break;
//           case "NAME":
//               type =heroParameters.getNAME();
//               break;
           case "LVL":
               type = heroParameters.getLVL();
               break;
           case "EXP":
               type = heroParameters.getEXP();
               break;
           case "SPEED":
               type = heroParameters.getSPEED();
               break;
           case "POINTS":
               type = heroParameters.getPOINTS();
               break;
           case "maxHP":
               type = heroParameters.getMaxHP();
               break;

       }
   }

    private void getForMonstr(MonstersParameters monstersParameters,String fieldName){
        switch(fieldName){
            case "HP":type = monstersParameters.getHP();
                break;
            case "ATTACK":type = monstersParameters.getATTACK();
                break;
            case "ATTACKDISTANCE":
                type = monstersParameters.getATTACKDISTANCE();
                break;
            case "imHeroNotMonstr":type = monstersParameters.getImHeroNotMonstr();
                break;
            case "drawableId":
                type = monstersParameters.getDrawableId();
                break;
            case "MOVEPOINTS":
                type = monstersParameters.getMOVEPOINTS();
                break;
            case "EXP":
                type = monstersParameters.getEXP();
                break;
            case "SHIELD":
                type = monstersParameters.getSHIELD();
                break;
        }

   }

    private void getForItem(AllItems allItems,String fieldName){
        switch(fieldName){
            case "drawableId":
                type = allItems.getDrawableId();
                break;
            case "imHeroNotMonstr": type = allItems.getImHeroNotMonstr();
                break;
            case "addHp":type = allItems.getAddHp();
                break;
            case "addMaxHp":type = allItems.getAddMaxHp();
                break;
            case "addAttack":type = allItems.getAddAttack();
                break;
            case "addShield":type = allItems.getAddShield();
                break;
            case "addSpeed":type = allItems.getAddSpeed();
                break;
            case "addAttackDistance":type = allItems.getAddAttackDistance();
                break;
            case "itemHp":type = allItems.getItemHP();
                break;
            case "isCaniwear":type = allItems.isCaniwear();
                break;
            case "isWearing": type = allItems.isWearing();
                break;
        }
    }




    public void setSomething(HashMap<String,Object> hm,String uniqueType,String fieldName,int value){

//           clas = hm.get(uniqueType).getClass();
//                  type = clas.getField(fieldName).getInt(hm.get(uniqueType));
//            type = hm.get(uniqueType).getClass().getField(fieldName).getInt(hm.get(uniqueType).getClass());

        Objects obj = (Objects) hm.get(uniqueType);
        if(obj!=null) {
            switch (obj.getImHeroNotMonstr()) {
                case (1):
                    HeroParameters heroParameters = (HeroParameters) obj;
                    setForHero(heroParameters, fieldName, value);
                    break;
                case (0):
                    MonstersParameters monstersParameters = (MonstersParameters) obj;
                    setForMonstr(monstersParameters, fieldName, value);
                    break;
                case (-1):
                    AllItems allItems = (AllItems) obj;
                    setForItem(allItems, fieldName, value);
                    break;
            }
        }


    }
    private void setForHero(HeroParameters heroParameters,String fieldName,int value) {
        switch (fieldName) {
            case "HP":
                heroParameters.setHP(value);
                break;
            case "imHeroNotMonstr":
                heroParameters.setImHeroNotMonstr(value);
                break;
            case "drawableId":
                heroParameters.setDrawableId(value);
                break;
            case "MOVEPOINTS":
                heroParameters.setMOVEPOINTS(value);
                break;
            case "ATTACK":
                heroParameters.setATTACK(value);
                break;
            case "ATTACKDISTANCE":
                heroParameters.setATTACKDISTANCE(value);
                break;
            case "SHIELD":
                heroParameters.setSHIELD(value);
                break;
            case "LVL":
                heroParameters.setLVL(value);
                break;
            case "EXP":
                heroParameters.setEXP(value);
                break;
            case "SPEED":
                heroParameters.setSPEED(value);
                break;
            case "POINTS":
                heroParameters.setPOINTS(value);
                break;
            case "maxHP":
                heroParameters.setMaxHP(value);
                break;

        }
    }

    private void setForMonstr(MonstersParameters monstersParamters,String fieldName,int value){
        switch(fieldName){
            case "HP":monstersParamters.setHP(value);
                break;
            case "imHeroNotMonstr":monstersParamters.setImHeroNotMonstr(value);
                break;
            case "drawableId":
                monstersParamters.setDrawableId(value);
                break;
            case "MOVEPOINTS":
                monstersParamters.setMOVEPOINTS(value);
                break;
        }

    }

    private void setForItem(AllItems allItems,String fieldName,int value){
        switch(fieldName){
            case "drawableId":
                allItems.setDrawableId(value);
                break;
            case "imHeroNotMonstr":allItems.setImHeroNotMonstr(value);
                break;
            case "isWearing": allItems.setWearing(value);
                break;
        }


    }

    public String[][] getItemsMas(HeroParameters heroParameters){
        return heroParameters.getItemsMas();
    }

    public void addItemsMas(HeroParameters heroParameters,String uniqueType){
        heroParameters.addItemsMas(uniqueType);
    }

    public HashMap<String,Object> getItemsHashMap(HeroParameters heroParameters){
        return heroParameters.getItemsHashMap();
    }


    public void addItemsHashMap(HeroParameters heroParameters,String uniqueType,AllItems allItems){
        heroParameters.addItemsHashMap(uniqueType, allItems);
    }

    public void onExpGot(HeroParameters heroParameters,int EXP){
        heroParameters.onExpGot(EXP);
    }

    public String getType(AllItems allItems){
        return allItems.getType();
    }


    public void onHPgot(HeroParameters heroParameters,int HP){
        heroParameters.onHPgot(HP);
    }

    public void onDamageHave(HeroParameters heroParameters,int Damage){
        heroParameters.onDamageHave(Damage);
    }

    public void onPointUsed(HeroParameters heroParameters,String Param){
        heroParameters.onPointUsed(Param);
    }

    public void onHpGot(HeroParameters heroParameters,int hpgot){
        heroParameters.onHPgot(hpgot);
    }


}
